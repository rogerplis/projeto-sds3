package com.roger.backend.controller;

import com.roger.backend.entitie.Person;
import com.roger.backend.entitie.PersonSocialMedia;
import com.roger.backend.repositories.PersonSocialMediaRepository;
import com.roger.backend.services.PersonService;
import com.roger.backend.services.SocialMediaService;
import com.roger.backend.storage.Disco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonService repository;

    @Autowired
    private PersonSocialMediaRepository socialMediaRepository;

    private PasswordEncoder encoder;

    @GetMapping("/pessoa")
    public ResponseEntity<List<Person>> listarTodos() {
        return ResponseEntity.ok(repository.listarTodos());
    }

    //cadastro da pessoa com os links
    @RequestMapping(path = "/pessoa", method = RequestMethod.POST )
    public ResponseEntity<Object> cadastrar(@RequestBody Person person ) {

        //recupera o cpf vindo pelo body
        String pessoacpf = person.getCpf();

        //pega os links dentro do body
        List<PersonSocialMedia> socialLink = person.getSocialLink();

        //verifica se o cpf ja esta cadastrado
        if (repository.buscarCpf(pessoacpf).isPresent()) {

            // tras o objeto pessoa do banco para ser cadastrado no personSocialMedia
            Optional<Person> pessoa = repository.buscarCpf(pessoacpf);
            // for para correr o os links vindos do body
            // poderia salvar direto a lista mas precisa passar a pessoa e verificar se o perfil nao existe.
            for (PersonSocialMedia personSocialMedia : socialLink) {
                // seta a pessoa com a pessoa que vem do banco para ser cadastrado no socialMedia
                personSocialMedia.setPerson(pessoa.get());
                // pega o link dentro do objeto socialLink
                String link = personSocialMedia.getLink();
                //verifica se ja não existe um link identico cadastrado
                if(socialMediaRepository.existsByLink(link)){
                    // se existir nao grava
                    return ResponseEntity.ok("O perfil ja existe nos cadastros!");
                } else {
                    // se nao existir grava na tabela PersonSocialMedia
                    socialMediaRepository.save(personSocialMedia);
                }
            }
            // retorna que a pessoa já esta cadastrada
            return ResponseEntity.ok("o CPF : " + pessoacpf + " Já esta cadastrado!");
        }
        // caso nao esteja grava a pessoa
        repository.cadastrar(person);
        // pega a pessoa recem cadastrada para ser gravada na tabela PersonSocialMedia
        Optional<Person> pessoa1 = repository.buscarCpf(pessoacpf);
        // for para tratamento de duplicidade
        for (PersonSocialMedia personSocialMedia : socialLink) {
            personSocialMedia.setPerson(pessoa1.get());
            String link = personSocialMedia.getLink();
            if(socialMediaRepository.existsByLink(link)){
                return ResponseEntity.ok("O perfil ja existe nos cadastros!");
            } else {
                socialMediaRepository.save(personSocialMedia);
            }
        }
        // retorno caso a pessoa tenha sido cadastrada
        return ResponseEntity.ok("Cadastro com sucesso: " + pessoacpf);
    }

    @PutMapping("/pessoa/{id}")
    public ResponseEntity<Person> atualizar(@PathVariable(name = "id") @RequestBody Person person) {
        return ResponseEntity.ok(this.repository.atualizar(person));
    }

    @DeleteMapping("/pessoa/{id}")
    public ResponseEntity<String> remover(@PathVariable(name = "id") Long id) {
        this.repository.deletar(id);
        return ResponseEntity.ok("Excluido com sucesso");
    }
    @GetMapping("/pessoa/{cpf}")
    public ResponseEntity<Optional<Person>> buscarPorCPF(@PathVariable(name = "cpf") String cpf) {
        return  ResponseEntity.ok(this.repository.buscarCpf(cpf));
    }


}

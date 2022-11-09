package com.roger.backend.storage;

import com.roger.backend.entitie.MarkingPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class Disco {
    //formato da hora vindo do txt e transformando em objeto date com formatação em ingles
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy")
            .withLocale(Locale.FRANCE);

    @Value("${contato.disco.raiz}/")
    private String raiz;

    @Value("${contato.disco.diretorio-fotos}")
    private String diretorioFotos;

    @Value("${contato.disco.diretorio-ponto}")
    private  String diretorioMarcacao;


    public void salvarFoto(MultipartFile foto) {
        this.salvar(this.diretorioFotos, foto);
    }

    public void salvarMarcacao(MultipartFile marcacao) {
        this.salvar(this.diretorioMarcacao, marcacao);
    }

    public List<String> abrirArquivo(String nameFile) throws IOException { return this.abrir(this.diretorioMarcacao,nameFile); }



    private void salvar(String diretorio, MultipartFile arquivo) {
        Path diretorioPath = Paths.get(this.raiz, diretorio);
        Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

        try{
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar o arquivo " + e);
        }
    }

    private List<String> abrir(String diretorio, String nameFile) throws IOException {
        Path diretorioPath = Paths.get(this.raiz, diretorio);
        String caminho = diretorioPath.toString() +'\\'+ nameFile;
        System.out.println(caminho);
        Path path = Path.of(caminho);
        List<String> marcacoes = Files.readAllLines(path);
        Files.writeString(Path.of(caminho), "Importado !!", StandardOpenOption.APPEND);
        return marcacoes;
    }

}

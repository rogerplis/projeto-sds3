# projeto-sds3

Projeto criado com base em um curso do Nelio Alves.

Utilizando Java no Backend e React no FrontEnd.

O projeto constituia de um sistema que tinha uma base de dados de vendas, na qual teria endpoints que retornariam o todas as vendas e tambem analise qualitativa das mesmas. 
Como percentual de sucesso de visitas versus vendas e total de vendas de cada vendedor.
No bakcend utilzando o Framework Spring. 
com os modulos:
- Spring Web
- JPA

Foram criados dois controllers:
- Um para que retornassem as vendas, as vendas por vendedor e a taxa de sucesso por vendedor.
Foi usado o padrao DTO para que fosse exposto todo o retorno da entidade e utilizar algums metodos auxiliares.
``` sh
@GetMapping(value = "/sales")
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/sales/amount-by-seller")
    public ResponseEntity<List<SalerSumDTO>> amountGroupedBySeller() {
        List<SalerSumDTO> list = service.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/sales/success-by-seller")
    public ResponseEntity<List<SalerSuccessDTO>> successGroupedBySeller() {
        List<SalerSuccessDTO> list = service.successGroupedBySeller();
        return ResponseEntity.ok(list);
```
- O segundo para retornar a lista de vendedores
```sh
@GetMapping
    public ResponseEntity<List<SellerDTO>> findAll() {
        List<SellerDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }
```
No FrontEnd foram criadas duas paginas uma home e um dashboard com graficos e tabela de vendas paginada.

![Captura de tela 2022-11-10 101009](https://user-images.githubusercontent.com/54747995/201100830-75eed76f-4ae2-432d-9f90-893ad82bc07b.png)

![image](https://user-images.githubusercontent.com/54747995/201100533-b03ec8ed-f2a0-4cde-8345-13dea2832081.png)

Ao final foram feitos deploys dos dois projetos nas ferramentas Netlify(frontEnd) e Heroku(bakend).
Apesar do FrontEnd ainda estar online o backend ficou offline pela descontinuação da gratuidade do Heroku.
E como é um projeto de estudo ele nao sera mais ativado em outra plataforma.
Sobre o backend apos ser colocado em produção, foi feitas alterações relevantes no mesmo:
- Inclusao do sistema de documentação Swagger.
- Inclusao no controller de salles a funcionalidade de cadastrar novas vendas e listagem de vendas por data.
- Inclusao de sistema de authenticação via JWT.
- Inclusao de sistema de upload, leitura e gravaçao de dados de arquivos txt, pelo backend.
- Inclusao de cadastros de Pessoas e seus respectivos dados de redes sociais.
- Inclusao de cadastros de Empresas.
Essas alterações não estao em produção, somente implementação de codigo.

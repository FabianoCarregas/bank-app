# Projeto TQI

## Sobre o projeto

Uma empresa de empréstimo precisa criar um sistema de análise de crédito para fornecer aos seus clientes as seguintes funcionalidades:

## i. Cadastro de clientes
    O cliente pode cadastrar: nome, e-mail, CPF, RG, endereço completo, renda e senha.
## ii. Login
    A autenticação será realizada por e-mail e senha.
## iii. Solicitação de empréstimo
    Para solicitar um empréstimo, precisamos do valor do empréstimo, data da primeira parcela e quantidade de parcelas.
    O máximo de parcelas será 60 e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.
## iv. Acompanhamento das solicitações de empréstimo
    O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de seus empréstimos.
    Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
    No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, data da primeira parcela, e-mail do cliente e renda do cliente.

São utilizadas as tecnologias:

- Java 11
- Spring Boot
- Spring Web
- Bean Validation
- H2, o BD relacional em memória
- Swagger/Documentation
- JWT Authentication


Swagger:    http://localhost:8080/swagger-ui.html#

## Os seguintes endpoints estão implementados:

- `GET /loans/{id}` obtém os detalhes de empréstimos
- `GET /loans` obtém lista de Empréstimos
- `POST /loans` Faz pedido de um novo empréstimo

- `GET /users` lista os usuarios já cadastrados
- `POST /users` Adiciona um novo usuario e seu endereço
- `GET /courses/{id}` obtém os detalhes de um usuario e seus empréstimos



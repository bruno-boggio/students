# Projeto CRUD Hibernate com Spring Boot

Bem-vindo ao repositório do projeto CRUD Hibernate desenvolvido com Spring Boot. Neste projeto, utilizamos a arquitetura MVC para criar operações CRUD (Create, Read, Update, Delete) para entidades de Curso e Estudante. O banco de dados PostgreSQL
é utilizado para persistência de dados.

## Funcionalidades

- Operações CRUD completas para entidades de Curso e Estudante.
- Relacionamento bidirecional entre Curso e Estudante.
- Validações de entrada para garantir dados consistentes.

## Estrutura do Projeto

- **/src/main/java/com.hibernate.CrudHibernate.modules.Course**: Contém classes relacionadas à entidade Curso.
- **/src/main/java/com.hibernate.CrudHibernate.modules.Student**: Contém classes relacionadas à entidade Estudante.
- **/src/main/java/com.hibernate.CrudHibernate.modules.Course.controller**: Controladores relacionados a operações de Curso.
- **/src/main/java/com.hibernate.CrudHibernate.modules.Student.controller**: Controladores relacionados a operações de Estudante.
- **/src/main/java/com.hibernate.CrudHibernate.modules.Course.useCases**: Casos de uso para operações de Curso.
- **/src/main/java/com.hibernate.CrudHibernate.modules.Student.useCases**: Casos de uso para operações de Estudante.

## Configuração do Banco de Dados

- Configure as propriedades do banco de dados no arquivo `application.properties`.
- Certifique-se de ter um servidor PostgreSQL em execução.

## Como Executar

1. Clone este repositório.
2. Configure as propriedades do banco de dados em `src/main/resources/application.properties`.
3. Execute o projeto usando sua IDE preferida ou usando o comando `./mvnw spring-boot:run` no terminal.




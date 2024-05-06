# Desapega

Bem-vindo ao projeto Desapega! Este é um sistema de trocas de produtos entre usuários, onde os usuários podem cadastrar produtos para trocar, interagir com outros usuários por meio de mensagens, enviar solicitações de troca e etc.

## Sobre o Projeto 

O Desapega é um projeto desenvolvido como trabalho de conclusão de curso (TCC) para o curso técnico em informática integrado ao ensino médio na escola CEDUP ABILIO PAULO. O objetivo do projeto é criar uma plataforma online para facilitar a troca de produtos entre usuários, promovendo a reutilização e sustentabilidade. Lembrando que este é um projeto em desenvolvimento, qualquer contribuição ou observação é bem vinda!

## Estrutura de Pastas
```

├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── rafaelaugustor
│       │           └── desapega
│       │               ├── broker
│       │               │   ├── consumers
│       │               │   └── producers
│       │               ├── config
│       │               ├── domain
│       │               │   ├── entities
│       │               │   └── enums
│       │               ├── rest
│       │               │   ├── controllers 
│       │               │   └── dtos
│       │               │       ├── request
│       │               │       └── response
│       │               ├── repositories
│       │               ├── services
│       │               └── utils
│       └── resources
│           └── db
│               └── migration
│         
│         
├── target
├── mvnw
├── mvnw.cmd
└── pom.xml

```

A arquitetura do projeto segue uma estrutura em camadas típica, consistindo nos seguintes módulos:

- `src/main/java/com/rafaelaugustor/desapega`: Este é o diretório raiz do código-fonte Java da sua aplicação.
    - `broker`: Contém os módulos relacionados ao RabbitMQ, como consumidores e produtores.
        - `consumers`: Contém os consumidores que recebem mensagens do RabbitMQ.
        - `producers`: Contém os produtores que enviam mensagens para o RabbitMQ.
    - `config`: Contém as configurações da aplicação, como configurações de banco de dados e de segurança.
    - `domain`: Contém as classes que representam o domínio da sua aplicação, como entidades e enums.
        - `entities`: Contém as classes que representam entidades do domínio.
        - `enums`: Contém as classes que representam enums utilizados no domínio.
    - `rest`: Contém os recursos da sua aplicação RESTful, como controladores e DTOs.
        - `controllers`: Contém os controladores responsáveis por receber e responder às requisições HTTP.
        - `dtos`: Contém os DTOs (Data Transfer Objects) que representam os objetos transferidos entre o cliente e o servidor.
            - `request`: Contém os DTOs usados para representar os dados recebidos do cliente.
            - `response`: Contém os DTOs usados para representar os dados enviados para o cliente.
    - `repositories`: Contém as interfaces dos repositórios responsáveis pela interação com o banco de dados.
    - `services`: Contém as classes de serviço que implementam a lógica de negócios da sua aplicação.
    - `utils`: Contém classes utilitárias que fornecem funcionalidades auxiliares para toda a aplicação.
- `src/main/resources/db/migration`: Contém os arquivos de migração do banco de dados, usados para versionar e manter o esquema do banco de dados.

Além disso, existem outros arquivos e diretórios, como arquivos de licença, arquivos de construção e README. No geral, a arquitetura do projeto é clara, com responsabilidades claras para cada módulo, facilitando o entendimento e a manutenção.

## Tecnologias Utilizadas

- **Spring Framework**
- **RabbitMQ**
- **PostgreSQL**
- **H2**
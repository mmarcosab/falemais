# VxTel - FaleMais
## _Adquira já seu plano_

FaleMias da VxTel é o produto onde o cliente adquire um plano e pode falar de graça até um determinado tempo, pagando apenas os minutos excedentes.


## Regras de negócio:

- O tempo de cada plano é contado em minutos
- Cada minuto excedente tem um acréscimo de 10% sobre a tarifa normal do minuto
- Planos:
    - FaleMais30 - 30 minutos
    - FaleMais60 - 60 minutos
    - FaleMais30 - 120 minutos
- O custo inicial de aquisição do plano deve ser desconsiderado para este
problema


## Requisitos Funcionais:
- RF01: Dispobibilizar uma plataforma web com a simulação de um plano
- RF02: O cliente pode escolher o código de origem. O código de origem é o DDD.
- RF03: O cliente pode escolher o código de destino. O código de destino é o DDD.
- RF04: O cliente pode escolher o tempo da ligação, em minutos.  
- RF05: O cliente pode escolher o plano FaleMais, de acordo com os planos disponibilizados acima
- RF06: O sistema deve retornar o valor da ligação com o plano
- RF07: O sistema deve retornar o valor da ligação sem o plano

Exemplo de valores:

| Origem  |  Destino  | Tempo   | Plano FaleMais | Com FaleMais | Sem FaleMais |
| ------- | --------- | -----   | -------------- | ------------ | ------------ |
| 011     | 016       | 20      | FaleMais 30    | $ 0,00       |    $ 38,00   |
| 011     | 017       | 80      | FaleMais 60    | $ 37,40      |    $ 136,00  |
| 018     | 011       | 200     | FaleMais 120   | $ 167,20     |    $ 380,00  |
| 018     | 017       | 100     | FaleMais 30    |      -       |       -      |

## Requisitos Não Funcionais

- RNF01: O Acesso às funcionalidades do sistema deverá ser autenticado e autorizado. O módulo backend deve fazer uso de JWT, enquanto que o módulo frontend deve utilizar usuário e senha.
- RNF02: A aplicação deve estar disponível 24/7
- RNF03: O módulo backend do projeto deve utilizar a arquitetura limpa para organização do código
- RNF04: A aplicação deve ser entregue em um container docker para abstrair tarefas complexas  de instalação


## Funcionalidades

- Cálculo do valor da ligação usando ou não algum dos planos


## Tecnologias

FaleMais usa as seguintes tecnologias:

- [Java](https://www.java.com/pt-BR/) - Linguagem de programação utilizada para desenvolvimento do módulo backend
- [Spring Boot](https://spring.io/projects/spring-boot/) - Framewwork utilizado para auxiliar no desenvolvimento do módulo backend
- [JavaScript](https://www.javascript.com/) - Linguagem de programação utilizada para desenvolvimento do módulo frontend
- [React](https://pt-br.reactjs.org/) - Framewwork utilizado para auxiliar no desenvolvimento do módulo frontend
- [MySql Database](https://www.mysql.com/) - Banco de dados utilizado para lidar com as informações necessárias para uso da aplicação
- [Docker](https://www.docker.com/) - Tecnologia utilizada a entrega da aplicação


## Instalação


## Testes
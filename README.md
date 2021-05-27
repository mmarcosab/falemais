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

- Cálculo do valor da ligação usando um plano;
- Cálculo do valor da ligação sem usar um plano;

## Tecnologias

FaleMais usa as seguintes tecnologias:

Backend:
- [Java](https://www.java.com/pt-BR/) - Linguagem de programação utilizada para desenvolvimento do módulo backend
- [Spring Boot](https://spring.io/projects/spring-boot/) - Framewwork utilizado para auxiliar no desenvolvimento do módulo backend
- [Docker](https://www.docker.com/) - Tecnologia utilizada para a entrega da aplicação
- [Lombok](https://projectlombok.org/) - Para simplificar o código 
- [Swagger](https://swagger.io/) - Para documentar e testar a api

## Instalação


## Testes
### Testes unitários

#### O que foi usado?

- Plugins instalados via pom.xml para execução dos testes unitários no build
- JUnit 5
- Mockito
- JaCoCo para os devs ficarem atentos a cobertura, sem precisarem iniciar a esteira

#### Documentação
- Os métodos estão disponiveis na rota http://localhost:8080/falemais/swagger-ui.html

#### Dependências:

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-launcher</artifactId>
            <version>1.7.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.7.1</version>
            <scope>test</scope>
        </dependency>


#### Plugins:

            <plugin>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
            </plugin>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.4</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report</id>
                        <phase>prepare-package</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>


#### Como verificar a cobertura de testes ?

- Na IDE execute o comando "mvn clean install" ou "mvn build", o arquivo /target/site/jacoco/index.html será gerado e toda a cobertura pode ser verificada.
- Sem IDE, use o prompt do windows ou o git bash e navegue até a raiz do projeto, execute o comando "mvn clean install" ou "mvn build", o arquivo /target/site/jacoco/index.html será gerado e toda a cobertura pode ser verificada.

 
 
## Health

Rotas disponíveis para verificar a saúde e métricas da aplicação:

- http://localhost:8080/actuator/health
- http://localhost:8080/falemais/actuator/info
- http://localhost:8080/falemais/actuator/prometheus
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
- [JUnit](https://junit.org/junit5/) - Para testes unitários e de integração
- [Mockito](https://site.mockito.org/) - Para testes unitários

## Instalação

#### mvn package
- Execute o comando mvn package na raiz do projeto para gerar o jar
- Use esse jar aonde preferir, exemplo no windows: java -jar .\target\falemais-0.0.1-SNAPSHOT.jar

#### Docker
- Use o arquivo dockerfile na raiz do projeto e gere uma imagem, exemplo de comandos:
        docker build . -- tag repositorio/nome-da-imagem
        docker push tag repositorio/nome-da-imagem
        docker pull repositorio/nome-da-imagem
        
        

## Testes
### Testes unitários

#### O que foi usado?

- Plugins instalados via pom.xml para execução dos testes unitários no build
- JUnit 5
- Mockito
- JaCoCo para os devs ficarem atentos a cobertura, sem precisarem iniciar a esteira

#### Como verificar a cobertura de testes ?

- Na IDE execute o comando "mvn clean install" ou "mvn build", o arquivo /target/site/jacoco/index.html será gerado e toda a cobertura pode ser verificada.
- Sem IDE, use o prompt do windows ou o git bash e navegue até a raiz do projeto, execute o comando "mvn clean install" ou "mvn build", o arquivo /target/site/jacoco/index.html será gerado e toda a cobertura pode ser verificada.

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

### Testes de integração

#### O que foi feito?

- Um plugin foi instalado para que durante o build seja executada uma etapa de testes de integração:

            
                        <plugin>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-maven-plugin</artifactId>
                            <configuration>
                                <excludes>
                                    <exclude>
                                        <groupId>org.projectlombok</groupId>
                                        <artifactId>lombok</artifactId>
                                    </exclude>
                                </excludes>
                            </configuration>
                            <executions>
                                <execution>
                                    <id>run-app-for-integration-tests</id>
                                    <phase>pre-integration-test</phase>
                                    <goals>
                                        <goal>start</goal>
                                    </goals>
                                </execution>
                                <execution>
                                    <id>stop-app-after-integration-tests</id>
                                    <phase>post-integration-test</phase>
                                    <goals>
                                        <goal>stop</goal>
                                    </goals>
                                </execution>
                            </executions>
                        </plugin>
                        <plugin>
                            <groupId>org.apache.maven.plugins</groupId>
                            <artifactId>maven-failsafe-plugin</artifactId>
                            <executions>
                                <execution>
                                    <goals>
                                        <goal>integration-test</goal>
                                        <goal>verify</goal>
                                    </goals>
                                </execution>
                            </executions>
                        </plugin>

- A anotação @SpringBootTest auxilia nos testes de integração, pois faz com que a aplicação seja iniciada e os testes sejam feitos.            
É possível ver o início dessa etapa:

        [INFO] 
        [INFO] --- spring-boot-maven-plugin:2.5.0:start (run-app-for-integration-tests) @ falemais ---

- Exemplo de teste:

        @Test
        public void testCriarSimulacao018to011Plano120TempoDeChamadaMaior120() throws Exception {
            RestTemplate restTemplate = new RestTemplate();
            SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                    .valorMinuto(1.90)
                    .minutosPlano(120)
                    .duracaoChamada(200)
                    .codigoOrigem("018")
                    .codigoDestino("011")
                    .build();
            SimulacaoResponseModel response = restTemplate.postForObject(urlBase, request, SimulacaoResponseModel.class);
    
            Assertions.assertEquals(380.0, response.getValorSemPlano());
            Assertions.assertEquals(167.20, response.getValorComPlano());
            Assertions.assertEquals("018", response.getCodigoOrigem());
            Assertions.assertEquals("011", response.getCodigoDestino());
            Assertions.assertEquals(120, response.getMinutosPlano());
            Assertions.assertEquals(200, response.getDuracaoChamada());
        }

- A quantidade de minutos de cada plano foi utilizada como base para os testes, isso significa que foram feitos testes com valor menor, valor igual e valor maior que a quantidade de minutos de cada plano.

#### Documentação
- Os métodos estão disponiveis na rota http://localhost:8080/falemais/swagger-ui.html
 
## Health

Rotas disponíveis para verificar a saúde e métricas da aplicação:

- http://localhost:8080/actuator/health
- http://localhost:8080/falemais/actuator/info
- http://localhost:8080/falemais/actuator/prometheus

Com isso é possível utilizar softwares como o grafana para monitorar esse serviço.

## Docker
### /dockerfile
- Na raiz do projeto existe um arquivo dockerfile, pronto para ser usado e gerar uma imagem docker
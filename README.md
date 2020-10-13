```
  .   ____          _            __ _ _      
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \ 
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )  
  '  |____| .__|_| |_|_| |_\__, | / / / /  
 =========|_|==============|___/=/_/_/_/ 
 :: Spring Boot ::        (v2.3.4.RELEASE)
```
Documentação de referência:


# Desenvolvimento micro serviços com Spring

Neste projeto será desenvolvido uma aplicação de delivery, apenas para simular
um ambiente com arquitetura de micro serviços com fila, gateway, discovery ...

Salve o código abaixo em arquivo com o nome de docker-compose.yaml:
Este arquivo também está disponível na pasta resources
```
version: '3.5'

services:

  rabbitmq:
    image: rabbitmq:3.8.3-management
    ports:
      - 5672:5672
      - 15672:15672
    volumes:
      - $PWD/storage/rabbitmq1:/var/lib/rabbitmq
    environment:
      - RABBITMQ_ERLANG_COOKIE=This_is_my_secret_phrase
      - RABBITMQ_DEFAULT_USER=admin
      - RABBITMQ_DEFAULT_PASS=admin
volumes:
  rabbitmq:
```

Após criar o arquivo e instalar o docker, execute o comando abaixo;
```
docker-compose up
```

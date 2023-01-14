### Notes
Não consegui deixar o projeto 100% como eu gostaria, pois estou de férias e irei viajar, mas vou listar aqui algumas coisa que eu faria se tivesse mais tempo:
- Ajustar os testes que foram criados e crias mais testes seguindo a mesma lógica.
- Criar enventuais Mappers e Builders para ficar mais facil de entender.
- Fazer o deploy em alguma plataforma
- removeria os `thows Exception` e usaria o `ResponseEntity`para apenas mudar o estado da aplicação e não retornar um erro, pois isso não é uma exception de fato na minha opinião
- Criaria verificações nos `types` dos itens dos `bodys` para não retornar apenas um `500`
- Criaria um arquivo OpenAPI para documentar  

### Executando local
Abre o projeto numa IDE (recomendo IntelliJ) e o execute após o build do maven.

### Requests (curl)
##### Criar pessoa
```
curl --location --request POST 'http://localhost:8080/api/people' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "xxxx",
    "birthDate": "2020-10-30",
    "address": [
        {"publicPlace": "AAA", "zipCode": 12345678, "number": 123, "city": "city", "isPrincipal": true},
        {"publicPlace": "BBB", "zipCode": 9999, "number": 777, "city": "aaaaa", "isPrincipal": false}
    ]
}'
```
#### Obter uma pessoa cadastrada
```
curl --location --request GET 'http://localhost:8080/api/people/{peopleId}'
```

#### Obter todas pessoas cadastradas
```
curl --location --request GET 'http://localhost:8080/api/people'
```
#### Obter todos endereços de umas pessoa cadastrada
```
curl --location --request GET 'http://localhost:8080/api/people/{peopleId}/address'
```
#### Adicionar endereços para uma pessoa cadastrada
```
curl --location --request PUT 'http://localhost:8080/api/people/{peopleId}/address' \
--header 'Content-Type: application/json' \
--data-raw '{
    "publicPlace": "zzzz",
    "zipCode": 14455118,
    "number": 13,
    "city": "camp",
    "isPrincipal": true
}'
```
#### Definir um endereço cadastrado como principal
```
curl --location --request PUT 'http://localhost:8080/api/people/address/{addressId}?isPrincipal=true'
```
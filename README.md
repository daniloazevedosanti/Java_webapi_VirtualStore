
# Descrição da Web API
Aplicação em Java 11 com Sprig boot / framework, 
utilizando persistência JPA + PostgresSQL Cloud da AmazonAWS, 
com JWT autenticação sem usuário e senha, somente por tempo limite. 
Patterns: MVC + Java architecture
Link heroku: https://webapi2020testings.herokuapp.com/

# Como usar, testar consumir!
De posso do link https://webapi2020testings.herokuapp.com/, 
para acessar os registro utilize uma aplicação para simular requisições http (ex: postman)
existem 3 frente Clientes, Produtos, e pedidos ou compras.

# Item A -TESTE VIA https://webapi2020testings.herokuapp.com/
# 1 - Clientes
Para cadastrar um cliente segue o link https://webapi2020testings.herokuapp.com/clients (método POST),
Corpo da requisição: {"name": "NomeDoCliente"} (formato json). 

Para consultar segue o link https://webapi2020testings.herokuapp.com/clients (método GET),

# 2 - Produtos
Para cadastrar um produtos segue o link https://webapi2020testings.herokuapp.com/products (método POST),
Corpo da requisição: {"name" : "NomeProduto", "price" : 100.00} (formato json). 

Para consultar segue o link https://webapi2020testings.herokuapp.com/clients (método GET),

# 3 - Pedidos/Compras
Para cadastrar uma compra segue o link https://webapi2020testings.herokuapp.com/orders (método POST),
Corpo da requisição: {"clientId" : IdDoClient, "productId" : IdDoProduto, "quantity": quantidade} (formato json). 

Para consultar segue o link https://webapi2020testings.herokuapp.com/orders (método GET),

# Item B - TESTE LOCAL https://localhost:{8080} "{sua porta de conexão}" 
Para testes local disponilizo uma classe de teste class, nessa classe se faz um seeding na "mão" ou em um banco local (estou usando o Postgressql), mas 
para tal é preciso modificar o arquivo "application.properties" (local src/main/resources) na linha "spring.profiles.active=prod" mude de 'prod' para:
'test' --> atraves da classe "TestConfig.java" faz um seeding e gerar um banco em memória, preenchendo as tabelas e daí é possivel ver as informações via GET com postman ou outro programa de requisição.
'dev' --> Funciona igual ao Item A, porém é preciso ter o banco de dados PostgresSQL no seu computador.

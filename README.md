
# Descrição da Web API
Aplicação em Java 11 com Sprig boot / framework, utilizando com persistência JPA (PostgresSql) 
com JWT autenticação sem usuário e senha, somente por tempo limite. 
Patterns: MVC + Java architecture
Link heroku: https://webapi2020testings.herokuapp.com/

# Como usar, testar consumir!
De posso do link https://webapi2020testings.herokuapp.com/, 
para acessar os registro utilize uma aplicação para simular requisições http (ex: postman)
existem 3 frente Clientes, Produtos, e pedidos ou compras.

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

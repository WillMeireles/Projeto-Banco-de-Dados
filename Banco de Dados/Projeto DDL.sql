CREATE SCHEMA ecommerce;


-- Criar tabela Cliente
CREATE TABLE ecommerce.cliente (
id_cliente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
nome_completo TEXT NOT NULL,
email TEXT NOT NULL,
senha TEXT NOT NULL,
telefone TEXT NOT NULL,
data_cadastro TEXT NOT NULL 
);



-- Criar tabela Pedido
CREATE TABLE ecommerce.pedido(
id_pedido INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
id_cliente INT NOT NULL,
FOREIGN KEY (id_cliente)
REFERENCES ecommerce.cliente(id_cliente),
data_pedido TIMESTAMPTZ NOT NULL,
valor_total NUMERIC (18,4) NOT NULL,
status TEXT NOT NULL
);


-- Criar tabela produto
CREATE TABLE ecommerce.produto(
id_produto INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
nome_produto TEXT NOT NULL,
descricao TEXT NOT NULL,
preco NUMERIC (18,4) NOT NULL,
estoque_disponivel INT NOT NULL, 
imagem_url TEXT NOT NULL
);


-- Criar tabela pagamento
CREATE TABLE ecommerce.pagamento(
id_pagamento INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
id_pedido INT NOT NULL,
FOREIGN KEY (id_pedido)
REFERENCES ecommerce.pedido(id_pedido),
forma_pagamento TEXT NOT NULL,
status TEXT NOT NULL,
data_pagamento TIMESTAMPTZ NOT NULL
);


-- Criar tabela Item
CREATE TABLE ecommerce.item(
id_item INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
id_pedido INT NOT NULL, 
FOREIGN KEY (id_pedido)
REFERENCES ecommerce.pedido(id_pedido),
id_produto INT NOT NULL,
FOREIGN KEY (id_produto)
REFERENCES ecommerce.produto(id_produto),
quantidade INT NOT NULL 
);

/**
	Lojinha de tenis
    @author Dimitri Saraiva
*/

create database DimiTenis;

use DimiTenis;

create table produto (
	codigo int primary key auto_increment,
    tenis varchar(50) not null,
    descricao varchar(50) not null,
    fabricante varchar(50) not null,
    datacad timestamp default current_timestamp,
    estoque int not null,
    estoquemin int not null,
    localizacao varchar(255) ,
    custo decimal (10,2)not null,
    lucro decimal (10,2),
    venda decimal (10,2),
    idfor int not null,
    foreign key(idfor) references fornecedores (idfor)
);

describe produto;

drop table produto;

insert into produto(tenis,descricao,fabricante,estoque,
estoquemin,localizacao,custo,lucro,venda,idfor)
values ('Air Force 1', 'Air Force 1 Branco','Nike',4,5,'Prateleira 2',300,150,800,1);

insert into produto(tenis,descricao,fabricante,estoque,
estoquemin,localizacao,custo,lucro,venda,idfor)
values ( 'Air Jordan 1', 'Air Jordan 1 Vermelho','Nike',5,5,'Prateleira 7',800,75,1500,2);

insert into produto(tenis,descricao,fabricante,estoque,
estoquemin,localizacao,custo,lucro,venda,idfor)
values ('Dunk', 'Dunk Preto','Nike',3,5,'Prateleira 5',500,100,1000,2);

insert into produto(tenis,descricao,fabricante,estoque,
estoquemin,localizacao,custo,lucro,venda,idfor)
values ( 'Puma', 'Puma Suede','Puma',15,5,'Prateleira 10',175,100,350,2);

insert into produto(tenis,descricao,fabricante,estoque,
estoquemin,localizacao,custo,lucro,venda,idfor)
values ('Mizuno', 'Mizuno Camaleão','Mizuno',9,5,'Prateleira 1',650,100,1300,2);

describe produto;

select codigo as código,tenis ,estoque,estoquemin as estoque_minimo
from produto where estoque < estoquemin;

select * from produto;


create table clientes(
idcli int primary key auto_increment,
nome varchar(30) not null,
nascimento date not null,
fone varchar(20) not null,
cpf varchar(15) unique,
email varchar (30),
mkt varchar(3) not null,
cep varchar(15),
endereco varchar(50),
numero varchar (10),
complemento varchar (30),
bairro varchar(50),
cidade varchar(15),
uf char(2)
);

describe clientes;

insert into clientes(nome,nascimento,fone,cpf,email,mkt,cep,endereco,numero,complemento,bairro,cidade,uf)
values ('Dimitri',20031224,950280735,32453494723,'dimitri2055@gmail.com','sim',02239050,'Rua Tuiuti',322,'Uma Avenida','Tatuape','São Paulo','SP');

insert into clientes(nome,nascimento,fone,cpf,email,mkt,cep,endereco,numero,complemento,bairro,cidade,uf)
values ('Renan',20040731,967629824,32456380830,'renan@gmail.com','não',62278350,'Avenida Amador Bueno',243,'Uma Avenida Larga','Vila Marieta','São Paulo','SP');

select email from clientes where mkt=('sim');

select * from clientes;

create table usuarios(
idusu int primary key auto_increment,
usuario varchar(40) not null,
login varchar(40) not null unique,
senha varchar(255) not null,
perfil varchar (40) not null 
);

describe usuarios;


insert into usuarios(usuario,login,senha,perfil)
values('Administrador','admin',md5('admin'),'admin');

insert into usuarios(usuario,login,senha,perfil)
values('Dimitri','dimitri',md5('dimitri24'),'user');

select * from usuarios;

create table fornecedores(
idfor int primary key auto_increment,
cnpj varchar (40)  unique not null,
ie varchar(40) unique,
im varchar(40) unique, 
razao varchar(40) not null,
fantasia varchar(30) not null,
site varchar(20),
fone varchar(30) not null,
contato varchar (20),
email varchar(20),
cep varchar(20) not null,
endereco varchar(30) not null,
complemento varchar(40),
bairro varchar(30) not null,
cidade varchar(30) not null,
uf char(2) not null
);

describe fornecedores;



select produto.codigo as Produto,
date_format(produto.datacad, '%d/%m/%Y - %H:%i') as data_Cadastro,
fornecedores.fantasia as Fornecedores, 
fornecedores.fone as Telefone
from  fornecedores inner join produto
on fornecedores.idfor = produto.idfor;


insert into fornecedores(cnpj,ie,im,razao,fantasia,site,fone,contato,email,cep,endereco,complemento,bairro,cidade,uf)
values (2167289158234,32445688,52447399,'Comércio de Produtos Esportivos Ltda','Nike','nike.com',2563772,'Adilson','nike@lojasnike.com','03326738','Rua Coronel Xavier de Toledo 23','Loja 43','Centro Historico','São Paulo','SP');

insert into fornecedores(cnpj,ie,im,razao,fantasia,site,fone,contato,email,cep,endereco,complemento,bairro,cidade,uf)
values (2137334153234,32327488,524234569,' Adidas do Brasil Ltda','Adidas','Adidas.com',2563342,'Mike','adidas@lojasadidas.com','03335738','Rua Gonçalo Coelo','Loja 21','Vila Formosa','São Paulo','SP');

select * from fornecedores;


create table pedidos (
pedido int primary key auto_increment,
dataped timestamp default current_timestamp,
total decimal(10,2),
idcli int not null,
foreign key (idcli) references clientes(idcli)
);

insert into pedidos(idcli) values(1);
insert into pedidos(idcli) values(2);

select*from pedidos;

create table carrinho(
pedido int not null,
codigo int not null,
quantidade int not null,
foreign key(pedido) references pedidos(pedido),
foreign key(codigo) references produto(codigo)
);

insert into carrinho values (1,1,3);
insert into carrinho values (2,2,3);

select pedidos.pedido,
carrinho.codigo as codigo,
produto.codigo,
carrinho.quantidade,
produto.venda,
produto.venda * carrinho.quantidade as sub_total
from (carrinho inner join pedidos on carrinho.pedido = 
pedidos.pedido)
inner join produto on carrinho.codigo = produto.codigo;

select sum(produto.venda * carrinho.quantidade) as total
from carrinho inner join produto
on carrinho.codigo = produto.codigo;

update carrinho
inner join produto
on carrinho.codigo = produto.codigo
set produto.estoque = produto.estoque - carrinho.quantidade
where carrinho.quantidade > 0;

select * from carrinho;

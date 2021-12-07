-- Inserir valores na tabela categoria
insert into tb_categoria (descricao) values
("Fisrt person shooter" ),
("Role playing game" ),
("Esportes" ),
("Corrida" );

-- Inserir valores na tabela produto
insert into tb_produto (descricao, valor, categoria_id) values
("Call of Duty Vanguard" , 299.90, 1),
("The Witcher 3" , 249.90, 2),
("FIFA 2022" , 249.90, 3),
("Need for Speed" , 249.90, 4);

-- Retorna os resultados das 2 tabelas
SELECT 
tb_produto.id as ID,
tb_produto.descricao as Descrição,
tb_produto.valor as Valor,
tb_categoria.descricao as Categoria
FROM db_ecommerce.tb_produto
inner join tb_categoria on
tb_categoria.id = tb_produto.categoria_id;
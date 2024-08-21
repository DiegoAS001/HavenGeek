

INSERT INTO CLIENTE (NOME, EMAIL, ENDERECO, USERNAME) VALUES
('Diego Souza', 'diego.souza@example.com', 'Rua das Flores, 123', 'dsouza'),
('Maria Silva', 'maria.silva@example.com', 'Avenida Central, 456', 'msilva'),
('João Oliveira', 'joao.oliveira@example.com', 'Praça das Águas, 789', 'joliveira'),
('Ana Costa', 'ana.costa@example.com', 'Rua do Sol, 101', 'acosta'),
('Lucas Mendes', 'lucas.mendes@example.com', 'Avenida Brasil, 202', 'lmendes');

INSERT INTO ACESSORIO (DESCRICAO, PRECO) VALUES
('Controle sem fio', 249.99),
('Headset gamer', 399.50),
('Capa protetora', 59.90),
('Teclado mecânico', 499.00),
('Mouse gamer', 299.99);

INSERT INTO JOGO (NOME, TIPO_MIDIA, PRECO, CATEGORIA, PLATAFORMA) VALUES
('The Witcher 3', 'F', 149.90, 'RPG', 'PC'),
('FIFA 24', 'D', 199.90, 'Esportes', 'PS5'),
('Minecraft', 'D', 99.90, 'Aventura', 'Xbox'),
('Cyberpunk 2077', 'F', 179.90, 'Ação', 'PC'),
('GTA V', 'D', 129.90, 'Ação', 'PS4');

INSERT INTO CARRINHO (ID_CLIENTE, ID_JOGO, ID_ACESSORIO) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5);

INSERT INTO VENDA (ID_CARRINHO) VALUES
(1),
(2),
(3),
(4),
(5);



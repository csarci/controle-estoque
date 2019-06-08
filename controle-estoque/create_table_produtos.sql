CREATE TABLE `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `loja_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `loja_id_idx` (`loja_id`),
  CONSTRAINT `loja_id` FOREIGN KEY (`loja_id`) REFERENCES `lojas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
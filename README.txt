Roteiro para a execu��o do projeto de controle-estoque:

Criar um schema (o atualizado durante o desenvolvimento deste projeto teve como nome controle_estoque) no Mysql.

Executar os scripts de cria��o das tabelas de Lojas e de Produtos, ambas est�o neste pacote (Foi utilizado o Mysql Workbench 8.0 para a cria��o das tabelas).

Importar como projeto Maven o projeto contido no pacote enviado (Projeto foi nomeado de estoque).

Configurar a senha de acesso ao banco no arquivo Configuration.java, no m�todo DataSource (Linhas 25 e 26 mais especificamente). Caso o schema n�o seja criado
com o nome sugerido e nem utilize a porta padr�o do Mysql, alterar a url de conex�o ao banco na linha 24.

Ap�s todos estes passos terem sido feitos corretamente, clicar com o bot�o direito na classe Configuration.java e selecionar Run As Java Application.

Acessar a aplica��o no browser pelo endere�o localhost:8080
Roteiro para a execução do projeto de controle-estoque:

Criar um schema (o atualizado durante o desenvolvimento deste projeto teve como nome controle_estoque) no Mysql.

Executar os scripts de criação das tabelas de Lojas e de Produtos, ambas estão neste pacote (Foi utilizado o Mysql Workbench 8.0 para a criação das tabelas).

Importar como projeto Maven o projeto contido no pacote enviado (Projeto foi nomeado de estoque).

Configurar a senha de acesso ao banco no arquivo Configuration.java, no método DataSource (Linhas 25 e 26 mais especificamente). Caso o schema não seja criado
com o nome sugerido e nem utilize a porta padrão do Mysql, alterar a url de conexão ao banco na linha 24.

Após todos estes passos terem sido feitos corretamente, clicar com o botão direito na classe Configuration.java e selecionar Run As Java Application.

Acessar a aplicação no browser pelo endereço localhost:8080
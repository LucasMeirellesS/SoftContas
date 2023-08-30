/*Para as roles e usuários, optei por dividi-los em 3 tipos: usuários comuns, administradores e super administrador.
Os usuários comuns são a maioria dos usuários do sistema. Esses usuários utilizarão o sistema para fazer pesquisas no banco de dados 
e apenas isso.
Os administradores serão os responáveis por atualizar o banco de dados, excluindo dados e adicionando-os em tabelas.
O super administrador será o administrador com todos os privilegios garantidos sobre o banco de dados. Ele será responsável por fazer a manutenção total do banco
 de dados, podendo excluir e adicionar tabelas, além de novos usuários comuns e administradores.*/

-- Criação de roles para cada tipo de usuário
create role 'usuario_comum';
create role 'administradores';
create role 'super_administrador';

--  Garantindo permições às roles
grant select on contasoft.* to 'usuario_comum';
grant select, update, delete on contasoft.* to 'administradores';
grant all privileges on contasoft.* to 'super_administrador';

-- Criando usuários comuns
create user 'usuario1'@'localhost' identified by 'hadouken';
create user 'usuario2'@'localhost' identified by 'shoryuken';
create user 'usuario3'@'localhost' identified by 'tatsumakisempukiaku';

-- Criando usuários administradores
create user 'administrador1'@'localhost' identified by 'asenhaeh1';
create user 'administrador2'@'localhost' identified by 'empleno2022';
create user 'administrador3'@'localhost' identified by '1100111';

-- Criando o usuário do super administrador
create user 'administrador_mestre'@'localhost' identified by 'theruler';

-- Atribuindo as roles a cada usuário --

-- Usuário comum --
grant 'usuario_comum' to 'usuario1'@'localhost';
set default role 'usuario_comum' to 'usuario1'@'localhost';
grant 'usuario_comum' to 'usuario2'@'localhost';
set default role 'usuario_comum' to 'usuario2'@'localhost';
grant 'usuario_comum' to 'usuario3'@'localhost';
set default role 'usuario_comum' to 'usuario3'@'localhost';

-- Administrador --
grant 'administradores' to 'administrador1'@'localhost';
set default role 'administradores' to 'administrador1'@'localhost';
grant 'administradores' to 'administrador2'@'localhost';
set default role 'administradores' to 'administrador2'@'localhost';
grant 'administradores' to 'administrador3'@'localhost';
set default role 'administradores' to 'administrador3'@'localhost';

-- Super Administrador -- 
grant 'super_administrador' to 'administrador_mestre'@'localhost'; 

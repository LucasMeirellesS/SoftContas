-- ------------------------ -------------------------------------- ---------------------------------- --
-- Rotina de administração do banco de dados em questão --
/*Para a manutenção do software objetivando uma melhor experiência de usuário
Os dados serão atualizados com frequência de acordo com a atualização do plano de contas
nacional para assim manter os dados atualizados de acordo com as decisões dos comitês de contabilidade,
e assim alcançar o objetivo proposto.
Além disso, outros procedimentos serão realizados para a manutenção do projeto. Abaixo defino todos esses procedimentos, detalhando-os 
para melhor entendimento.
*/
-- Backups --
/*Os backups serão realizados para garantir a integridade do banco de dados
preservando, assim, suas informações. Tal prossedimento irá garantir a durabilidade 
e intefridade dos dados do sistema em casos de danos no hardware, alterações indevidas, entre outros
imprevistos que podem comprometer a integridade das informações.
Para esse banco de dados, serão realizados backups de 3 em 3 dias ao meio-dia (12:00 am) em alguns servidores em núvem e, se possível,
em outros hardwares locais, diversificando o armazenamento e garantindo uma maior segurança à integridade das informações*/

-- Restore --
/*As restaurações serão realizadas sempre que houver algum problema com o banco de dados local. Isso ocorrerá com o objetivo de 
trazer o banco de dados de volta ao seu estado funcional, em caso de anomalias que prejudiquem sua integridade, e preservar os dados 
da forma proposta pelo sistema.*/

-- Checagem periódica --
/*A checagem periódica ocorrerá um dia antes do proximo backup periódico, dessa forma não haverá sobreposição de dados nem 
a gravação de dados incorretos nos servidores nem nos hardwares onde os backups ocorrerão.*/
-- ------------------------ -------------------------------------- ---------------------------------- --

/*A seguir, esta o script criado para a otimização do banco de dados*/

-- Indices --
/*Esses indices foram criados para colunas as quais estão presentes na maioria das clausulas de pesquisa utilizadas no script*/
create index idx_natureza_conta on plano_de_contas(natureza);
create index idx_nome_conta on plano_de_contas(nome);
create index idx_grupo_ativo on ativo(grupo);
create index idx_grupo_passivo on passivo(grupo);
create index idx_grupo_pl on patrimonio_liquido(grupo);
create index idx_grupo_resultado on contas_de_resultado(grupo);

-- Views --
/* Optei por criar views para pesquisas que retornam uma maior quantidade de dados por entender 
que, pelas views serem tabelas 'virtuais' do banco de dados a quantidade de dados não comprometerá o desempenho.

As views que retornam contas retificadoras retornarão dados de contas que irão reduzir o salto total do seu tipo de contas em questão, já as 
contas naturais retornarão as contas "padrões" daquele determinado tipo.*/

-- View que mostra as contas retificadoras do ativo--

create view retificadora_ativo as select pc.id, pc.nome, a.grupo, a.subgrupo, pc.natureza
from plano_de_contas as pc join ativo as a on pc.id = a.contas_id where pc.natureza = 'C';

-- View que mostra as contas retificadoras do passivo --
create view retificadora_passivo as select pc.id, pc.nome, p.grupo, pc.natureza
from plano_de_contas as pc join passivo as p on pc.id = p.contas_id where pc.natureza = 'D';

-- View que mostra as contas retificadoras do patrimônio líquido --
create view retificadora_patrimonio_liquido as select pc.id, pc.nome, pl.grupo, pc.natureza
from plano_de_contas as pc join patrimonio_liquido as pl on pc.id = pl.contas_id where pc.natureza = 'D';

-- Views para contas naturais do ativo --
create view contas_naturais_ativo as select pc.id, pc.nome, a.grupo, a.subgrupo, pc.natureza
from plano_de_contas as pc join ativo as a on pc.id = a.contas_id where pc.natureza = 'D';

-- Views para contas naturais do passivo --
create view contas_naturais_passivo as select pc.id, pc.nome, p.grupo, pc.natureza
from plano_de_contas as pc join passivo as p on pc.id = p.contas_id where pc.natureza = 'C';

-- Views para contas naturais do patrimônio líquido --
create view contas_naturais_patrimonio_liquido as select pc.id, pc.nome, pl.grupo, pc.natureza
from plano_de_contas as pc join patrimonio_liquido as pl on pc.id = pl.contas_id where pc.natureza = 'C';

-- Views para contas naturais de receita --
create view naturais_receita as select pc.id, pc.nome, r.grupo, pc.natureza from plano_de_contas as pc join 
contas_de_resultado as r on pc.id = r.contas_id where r.grupo = 'receitas' and natureza = 'C';

-- Views para contas retificadoras de receita --
create view retificadoras_receita as select pc.id, pc.nome, r.grupo, pc.natureza from plano_de_contas as pc join 
contas_de_resultado as r on pc.id = r.contas_id where r.grupo = 'receitas' and natureza = 'D';

-- Views para contas naturais de despesa --
create view naturais_despesa as select pc.id, pc.nome, r.grupo, pc.natureza from plano_de_contas as pc join 
contas_de_resultado as r on pc.id = r.contas_id where r.grupo = 'despesas' and natureza = 'D';
 
 -- Views para contas retificadoras de despesa --
create view retificadoras_despesa as select pc.id, pc.nome, r.grupo, pc.natureza from plano_de_contas as pc join 
contas_de_resultado as r on pc.id = r.contas_id where r.grupo = 'despesas' and natureza = 'C';

-- Storede Procedures --
/* Para os stored procedures, optei por criar uma serie de procedimentos nos quais retornarão uma lista de dados de 
determinado grupo ou subgrupo de contas das listas contendo as contas de ativo, passivo, patrimônio líquido e resultado */

-- Stored procedure que retornam contas de determinado grupo de contas do passivo -- 
delimiter //
create procedure contas_grupos_ativo(conta_grupo varchar(45))
begin
	select pc.id, pc.nome, a.subgrupo, pc.natureza from plano_de_contas as pc join ativo as a
    on pc.id = a.contas_id where a.grupo = conta_grupo;

end //
delimiter ;

call contas_grupos_ativo('ativo não circulante');

-- Stored procedure que retornam contas de determinado subgrupo das contas do ativo --
delimiter //
create procedure contas_subgrupos_ativo(conta_subgrupo varchar(45))
begin
	select pc.id, pc.nome, a.grupo, pc.natureza from plano_de_contas as pc join ativo as a
    on pc.id = a.contas_id where a.subgrupo = conta_subgrupo;

end //
delimiter ;

call contas_subgrupos_ativo('imobilizado')

-- Stored procedure que retornam contas de determinado grupo de contas do passivo --
delimiter //
create procedure contas_grupos_passivo(conta_grupo varchar(45))
begin
	select pc.id, pc.nome, p.grupo, pc.natureza from plano_de_contas as pc join passivo as p
    on pc.id = p.contas_id where p.grupo = conta_grupo;

end //
delimiter ;

call contas_grupos_passivo('passivo circulante');

-- Stored procedure que retornam contas de determinado grupo de contas do patrimônio líquido--
delimiter //
create procedure contas_grupos_pl(conta_grupo varchar(45))
begin
	select pc.id, pc.nome, pl.grupo, pc.natureza from plano_de_contas as pc join patrimonio_liquido as pl
    on pc.id = pl.contas_id where pl.grupo = conta_grupo;

end //
delimiter ;

call contas_grupos_pl('reservas de capital');

-- Stored Functions --

/*Para as stored functions pensei em pesquisas a partir de determinado atributo de dado
onde cada uma retornará um atributo especifico daquela tupla na qual o dado digitado se encontra.*/

-- Stored function que retorna a natureza de uma conta a partir do nome --
delimiter //
create function natureza_conta(conta_nome varchar(200)) returns char(1) deterministic
begin
	declare natureza_conta char(1);
	select pc.natureza into natureza_conta from plano_de_contas as pc where pc.nome = conta_nome;
	return natureza_conta;
end //
delimiter ;

select natureza_conta('CRÉDITOS A LONGO PRAZO');

-- Stored function que retorna a natureza de uma conta a partir do id --

delimiter //
create function nome_conta(id_conta int) returns varchar(200) deterministic
begin
	declare nome_conta varchar(200);
	select pc.nome into nome_conta from plano_de_contas as pc where pc.id = id_conta;
	return nome_conta;
end //
delimiter ;

select nome_conta(122);

-- Stored function que retorna o tipo de conta que pertence uma conta específica por meio do seu id --
delimiter //
create function tipo_conta(id_conta int) returns varchar(200) deterministic
begin
	declare contagemA int default 0;
    declare contagemP int default 0;
    declare contagemPL int default 0;
    declare contagemR int default 0;
	select count(contas_id) into contagemA from ativo where ativo.contas_id = id_conta;
    select count(contas_id) into contagemP from passivo where passivo.contas_id = id_conta;
    select count(contas_id) into contagemPL from patrimonio_liquido where patrimonio_liquido.contas_id = id_conta;
    select count(contas_id) into contagemR from contas_de_resultado where contas_de_resultado.contas_id = id_conta;
    
    if contagemA = 1 then
		return 'Ativo';
	elseif contagemP = 1 then
		return 'Passivo';
	elseif contagemPL = 1 then
		return 'Patrimônio Líquido';
	elseif contagemR = 1 then
		return 'Resultado';
	end if;

end //
delimiter ;

select tipo_conta(1);

-- Stored function que retorna o tipo de conta que pertence uma conta específica por meio do seu id --
delimiter //
create function grupo_conta(id_conta int) returns varchar(200) deterministic
begin
	declare contagemA int default 0;
    declare contagemP int default 0;
    declare contagemPL int default 0;
    declare contagemR int default 0;
    declare grupo_conta varchar(45);
	select count(contas_id) into contagemA from ativo where ativo.contas_id = id_conta;
    select count(contas_id) into contagemP from passivo where passivo.contas_id = id_conta;
    select count(contas_id) into contagemPL from patrimonio_liquido where patrimonio_liquido.contas_id = id_conta;
    select count(contas_id) into contagemR from contas_de_resultado where contas_de_resultado.contas_id = id_conta;
    
    if contagemA = 1 then
		select grupo into grupo_conta from ativo where contas_id = id_conta;
		return grupo_conta;
	elseif contagemP = 1 then
		select grupo into grupo_conta from passivo where contas_id = id_conta;
		return grupo_conta;
	elseif contagemPL = 1 then
		select grupo into grupo_conta from patrimonio_liquido where contas_id = id_conta;
		return grupo_conta;
	elseif contagemR = 1 then
		select grupo into grupo_conta from contas_de_resultado where contas_id = id_conta;
		return grupo_conta;
	end if;

end //
delimiter ;

select grupo_conta(50);

-- Triggers --

/*Não criei nenhum trigger pois não consegui pesnar em nenhum que fizesse sentido para a estrutura dessa banco de dados em questão*/

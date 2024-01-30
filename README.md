# SoftContas
## Resumo: O projeto consiste em um protótipo de um programa para verificação de contas contábeis. O usuário cadastra a conta e tem a opção de valida-la. Caso resolva validar, o programa irá verificar no banco de dados se a conta que ele cadastrou está correta, analisando natureza, grupo e subgrupo. Além disso, o programa também verifica se o método das partidas dobradas foi realizado corretamente.

## Status: Em desenvolvimento

## Tecnologias aplicadas: Java e SQL

## Time de Desenvolvedores: Lucas Emanuel Meirelles Silva

## Objetivo do software: O software em questão irá dividir as entradas em diferentes grupos de contas e subcontas em suas respectivas naturezas (Credoras ou Devedoras), onde o usuário escolherá um desses grupos e digitará o nome de uma conta específica e o seu valor em reais. Ao final da execução, o programa irá verificar se as contas estão em seus grupos, comparando-as com o plano de contas em um banco de dados, se não estiverem de acordo, o programa irá perguntar se o usuário deseja que o programa o corrija, se ele mesmo quer digitar as contas incorretas no grupo às quais pertencem ou se desejam digitar todas as contas novamente, repetindo o procedimento até que as contas estejam agrupadas em seus devidos lugares. Se estiver tudo correto, o programa irá somar todos os créditos e os débitos e compara-los, se a soma dos créditos estiver diferente da soma dos débitos ou vice-versa, o programa avisará ao usuário que houve um erro na digitação dos valores


## Funcionalidades do Sistema: 
•	Registro de contas: o programa irá apresentará opções para o usuário escolher o tipo de conta que deseja cadastrar e cada conta deverá ser registada em um grupo específico de Ativo, Passivo e Patrimônio Líquido.

•	Cálculo dos valores grupos de contas: o valor total de passivos, ativos e patrimônio líquido serão somados e seus valores serão exibidos ao usuário.

•	Comparação de valores: os valores dos créditos e dos débitos para validar se o método das partidas dobradas foi aplicado corretamente, caso contrário, o programa irá apresentar um alerta de erro sobre o valor.

•	Validação de contas em seus devidos grupos: o programa irá comparar a conta cadastrada com as contas existentes no plano de contas contido no banco de dados que será criado para o programa, caso esteja incorreto, o programa perguntará se o usuário deseja tentar colocar a conta no grupo certo ele mesmo ou se deseja que o programa corrija automaticamente. Caso o usuário erre a correção, o programa irá relatar erro até que o usuário coloque a conta no grupo certo ou escolha a opção de correção automática.
 

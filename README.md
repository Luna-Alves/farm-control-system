# Sistema de Controle de Fazenda
A fazenda possui criação de gado e porcos para abate, assim como vacas leiteiras. Além 
disso, a fazenda possui alguns tipos de funcionários: tratadores de animais, extratores 
de leite e gerente da fazenda.
# Requisitos:
* Todos os tipos de animais possuem as seguintes características: número 
identificador, peso em quilos e idade;
* Todos os animais devem se alimentar. Após se alimentarem, os animais 
aumentam de peso. Cada tipo de animal aumenta de peso de maneira diferente 
e possuem limite de peso para abate diferente. Sugestão: após se alimentarem, 
os animais têm um determinado aumento de peso em quilos. Esse acréscimo 
deve ser diferente para o gado de abate, porcos e vacas leiteiras;
* Todos os animais são capazes de emitir som. O som emitido por cada tipo de 
animal é diferente. A emissão de som corresponde a exibir uma mensagem em 
tela, com a correspondente onomatopeia (https://www.dicio.com.br/sons-deanimais/);
* Todos os animais devem poder exibir em tela o seu estado. Deve estar previsto 
para os animais a possibilidade de converter o seu peso de quilos para arroba. 
Essa conversão não deve ocorrer no atributo;
* Ao atingirem o peso de abate, os animais destinados para tal são vendidos e não devem mais fazer parte da fazenda. O preço do quilo ou arroba 
de cada tipo de animal é diferente. Após a venda de cada animal, o valor 
arrecadado com a venda deve ser contabilizado e registrado na fazenda. O 
registro deve ser feito em arquivo de texto;
* Cada tipo de animal a ser abatido tem o seu preço por quilo para abate. Do 
mesmo modo, as vacas leiteiras possuem o seu preço por litro de leite extraído. 
Essas informações devem estar em atributos e devem permitir modificação;
* Para extrair leite de uma vaca leiteira, é necessário que isso seja realizado por um 
funcionário extrator de leite. Todo leite extraído é extraído por um determinado 
valor por litro. O valor arrecadado com a venda deve ser contabilizado e 
registrado na fazenda. O registro deve ser feito em arquivo de texto;
* A quantidade de leite extraída de uma vaca leiteira pode ser obtida por meio da 
geração de um número real aleatório entre um valor mínimo e um valor máximo;
* A quantidade em litros extraída de leite também deve ser registrada para o 
funcionário extrator de leite. Esta informação será importante para o cálculo de 
seu salário;
* Todos os funcionários da fazenda devem ter o registro de seu nome, idade e CPF;
* A fazenda deve possuir um nome, dimensão em metros quadrados e informação 
de onde se encontra: cidade e estado;
* A fazenda possui um conjunto de funcionários e de animais. Deve ser possível 
adicionar e remover funcionários e animais à fazenda;
* Na fazenda, deve ser possível obter o número de cada tipo de funcionário, assim 
como o número de cada tipo de animal da fazenda;
* Na fazenda, deve ser possível obter o preço estimado de um determinado animal 
de abate, caso ele seja vendido com o seu peso atual;
* Na fazenda, deve ser possível obter o somatório do preço estimado de todos os 
animais de abate da fazenda;
* Na fazenda, deve ser possível calcular o salário de todos os seus funcionários, 
gerando uma folha de pagamento, registrada em arquivo de texto;
* Em um determinado momento, deve ser possível calcular a situação financeira 
atual da fazenda: lucro ou prejuízo em valores. Isto é feito calculando-se a 
despesa com a folha de pagamento (considerando apenas os salários) e o total 
arrecadado com vendas de animais para abate e leite extraído;
* Na fazenda, deve ser possível gerar um relatório de todos os animais da fazenda, 
ordenados por tipo de animal (gado, vaca leiteira e porcos) em arquivo de texto;

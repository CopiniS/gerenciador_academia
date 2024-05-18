# Gerenciador de academia

## Como testar a aplicação
* importar o banco de dados no MySql Workbench que está na pasta Banco

* Abrir o executável .jar que está nessa pasta inicial do projeto:
  * Pode-se apenas abrir clicando duas vezes no executável (assim ele iniciará o idioma puxando o padrão do seu sistema operacional, que se for diferente de pt-BR, en-US ou es-AR, executará em pt-BR);
    
  * Ou se quiser executar em um dos tres idiomas específicos, daí terá de executar pelo terminal com um dos comandos:
  ```
  java -jar .\gerenciador_academia-1.0-SNAPSHOT-launcher.jar pt BR
  ```
  ```
  java -jar .\gerenciador_academia-1.0-SNAPSHOT-launcher.jar en US
  ```
  ```
  java -jar .\gerenciador_academia-1.0-SNAPSHOT-launcher.jar es-AR
  ```
## Objetivo do projeto
O sistema foi desenvolvido, principalmente para treinar os conceitos de orientação a objetos e o modelo MVC. Outros fatores também treinados no projeto foram implementação de um CRUD básico, manipulação de pdfs e internacionalização para 3 idiomas.
 
## Lista de Funcionalidades
* Navegação fácil e intuitiva, com mensagens de sucesso e de erros bem definidas, para melhor entendimento do usuário;

* Menu principal, separado em 6 opções: Clientes, Instrutores, Modalidades, Planos, Treinos e Exercícios. Todos com suas próprias telas de cadastro e alteração de dados;

* A possibilidade de cadastrar até 8 modalidades para a academia;

* Cadastro de planos com a chance de adicionar diferentes combinações de modalidades previamente cadastradas;

* Exercícios divididos em 5 musculaturas: Peito, Costas, Braço, Perna e ombro. Podendo cadastrar até 20 exercícios para cada musculatura;

* Possibilidade de montar treinos com esses exercício, separados pelos dias da semana;

* Vinculação dos treinos previamente cadastrados, com os clientes e ainda podendo gerar um pdf do treino adicionado.

* Disponibilizado em 3 idiomas: ingles(US), português(BR) e espanhol(AR)



## Lista de Funcionalidades Desejadas e não implementadas ainda:
  
* Verificar informações do instrutor, CPF, formações e capacitações, onde o sistema alegaria se ele poderia ou não exercer a função;
  
* Vincular os dados de cliente a família (para o Plano Família);
  
* Fazer a implementação de uma gestão financeira para o sistema;
  
* Lista de atividade dos clientes;
  
* Implementar mais uma tela de listagem para cada opção do menu, implementada com filtros, e com opções de relatórios;
  
* Hovers nos botões.

# SD---TRABALHO-I
Trabalho 1 da disciplina de Sistemas Distribuídos – Comunicação entre processos

JEFERSON MATEUS LOPES ALVES - 538653\
DAVID SILVA FERNANDES DE OLIVEIRA - 539402

 Estrutura do Projeto
A aplicação foi organizada em camadas funcionais, distribuídas entre módulos que tratam da lógica, dados e comunicação.
Modelos: contém as classes que representam as entidades do sistema.


Funcionario.java, Caixa.java, Vendedor.java, Balconista.java, Gerente.java, Supermercado.java, Escala.java. Representam os diversos papéis e estruturas dentro do supermercado.


Fluxos de entrada/saída: FuncionarioInputStream, FuncionarioOutputStream, e suas variantes binárias, responsáveis pela serialização e desserialização.


serviços: define a lógica de negócios.


ServicoFuncionario.java: serviços relacionados às operações com funcionários.


ServicoSupermercado.java: serviços gerais do supermercado (como controle de escala, organização de caixas).

Como é arquitetado: 


Main.java: ponto de entrada da aplicação. interage com os dados dos funcionários usando serialização e desserialização.


Server.java e Client.java: implementação de uma arquitetura cliente-servidor, baseada em sockets, para comunicação e processamento remoto.




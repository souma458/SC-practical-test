# Exercício prático de JAVA

Desenvolver uma solução, em queo objetivo é disponibilizar uma página que permita o cálculo de uma prestação mensal para a compra de uma viatura e caso o utilizador esteja interessado, deve guardar essa informação.

Dados necessários para o cálculo da prestação:  
- Tipo de Financiamento: Interno ou Externo  
- Nº de Mensalidade (A)  
- Valor da Viatura (B)  
  
Regra de cálculo:  
- Prestação Mensal = B x Fator / A 

Em que Fator, corresponde a um incremento de 4% sobre o preço da viatura para tipo de financiamento interno e 6,5% para tipo de financiamento externo.  

- Mensalidades: As mensalidades variam entre 12 e 60 meses (com intervalos de 12 meses) para o tipo de financiamento externo, entanto caso o tipo de financiamento seja interno, as mensalidades não podem ser superiores a 48 meses  

Notas/Considerações:  
1. É obrigatório o cálculo da prestação mensal ser efetuado do lado do servidor.  
2. Se possível, os valores do Fator devem ficar num ficheiro de configuração  
3. Resultado: O Resultado deve ser apresentado numa página, com um botão para guardar a informação. Caso o utilizador carregue no botão "Guardar", deve indicar o nome e contacto. Essa informação deve ficar guardada num ficheiro no lado do servidor.
#6. Faça um Programa que pergunte quanto você ganha por hora e o número de horas trabalhadas no mês. Calcule e mostre o total do seu salário no referido mês, sabendo-se que são descontados 11% para o Imposto de Renda, 8% para o INSS e 5% para o sindicato, faça um programa que nos dê o salário bruto, quanto pagou ao INSS, quanto pagou ao sindicato e o salário líquido. Observe que Salário Bruto - Descontos = Salário Líquido. Calcule os descontos e o salário líquido, conforme a tabela abaixo:
#a. + Salário Bruto : R$
#       b. - IR (11%) : R$
#       c. - INSS (8%) : R$
#       d. - Sindicato ( 5%) : R$
#       e. = Salário Liquido : R$

ph = float(input("Digite o quanto você ganha por hora: R$"))
h = float(input("Digite a quantidade de horas trabalhadas no mês: "))

sb = ph * h
inss = (8*sb)/100
sind = (5*sb)/100
sl = sb-inss-sind
ir = (5*sb)/100

print("Salário Bruto: R$%.2f" %sb)
print("Salário Líquido: R$%.2f" %sl)
print("Desconto do INSS: R$%.2f" %inss)
print("Desconto do SINDICATO: R$%.2f" %sind)
print("Desconto IR: R$%.2f" %ir)

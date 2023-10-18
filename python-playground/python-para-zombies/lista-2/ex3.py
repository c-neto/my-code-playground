#   3. João Papo-de-Pescador, homem de bem, comprou um microcomputador para
#   controlar o rendimento diário de seu trabalho. Toda vez que ele traz um
#   peso de peixes maior que o estabelecido pelo regulamento de pesca do estado
#   de São Paulo (50 quilos) deve pagar uma multa de R$ 4,00 por quilo excedente.
#   João precisa que você faça um programa que leia a variável peso (peso de peixes)
#   e verifique se há excesso. Se houver, gravar na variável excesso e na variável
#   multa o valor da multa que João deverá pagar. Caso contrário mostrar tais
#   variáveis com o conteúdo ZERO.

kg = float (input("João Papo-de-Pescador, quantos kg você pescou: "))
excesso = 0
multa = 0
if (kg>50):
    excesso = kg-50
    multa = excesso*4
    print ("Excesso %.2f kg" %excesso)
    print ("Multa: R$%.2f" %multa)

else:
    print ("Excesso %.2f kg" %excesso)
    print ("Multa: R$%.2f" %multa)

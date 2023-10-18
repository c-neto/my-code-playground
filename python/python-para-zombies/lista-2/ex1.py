#   1. Faça um Programa que peça os três lados de um triângulo.
#   O programa deverá informar se os valores podem ser
#   um triângulo. Indique, caso os lados formem um triângulo,
#    se o mesmo é: equilátero, isósceles ou escaleno.

ca = float(input("CATETO A:"))
cb = float(input("CATETO B:"))
cc = float(input("CATETO C:"))

if (ca+cb>cc and cb+cc>ca and ca+cc>cb):
    if (ca==cb and cb==cc):
        print ("Triangulo equilátero")
    elif (ca==cb or cb==cc):
        print ("Triangulo Isósceles")
    elif (ca!=cb and cb!=cc):
        print ("Escaleno")

else:
    print ("Valores de catetos informado não formam um Triângulo")
        

#   1. Sorteie 10 inteiros entre 1 e 100 para uma lista e descubra o
#   maior e o menor valor, sem usar as funções max e min.

import random
vetor_lista = []
maior = 0
k = 0
aux = 0
menor = 0

while k < 5:
    vetor_lista.append(random.randint(1,100))    
    aux = vetor_lista[int(k)]

    if aux >= maior:
        maior = vetor_lista[int(k)]

    if aux <= vetor_lista[k]:
        menor = aux

    k+=1

print ("LISTA: ", vetor_lista)
print ("MAIOR: ", maior)
print ("MENOR: ", menor)

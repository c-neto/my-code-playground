#   2. Sorteie 20 inteiros entre 1 e 100 numa lista.
#    Armazene os números pares na lista PAR e os números
#    ímpares na lista IMPAR. Imprima as três listas.

import random

vetor_lista = []
vetor_impar = []
vetor_par = []

k = 0

while k < 5:
    vetor_lista.append(random.randint(1,100))

    if vetor_lista[int(k)]%2 == 0:
        vetor_par.append(vetor_lista[k])
    elif vetor_lista[int(k)]%2 != 0:
        vetor_impar.append(vetor_lista[k])

    k+=1

print ("LISTA: ", vetor_lista)
print ("PAR: ", vetor_par)
print ("IMPAR: ", vetor_impar)

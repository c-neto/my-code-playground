#   3. Faça um programa que crie dois vetores com 10 elementos aleatórios
#   entre 1 e 100. Gere um terceiro vetor de 20 elementos, cujos valores
#   deverão ser

import random
vetor_1 = []
vetor_2 = []
vetor_3 = []

k = 0
while k < 10:

    vetor_1.append(random.randint(1,100))    
    vetor_2.append(random.randint(1,100))    
    k+=1

k=0
while k < 10:

    vetor_3.append(vetor_1[k])
    
    vetor_3.append(vetor_2[k])  
    k+=1
    
print("Vetor 1: ", vetor_1)
print("Vetor 2: ", vetor_2)
print("Vetor 1 e 2 intercalados: ", vetor_3)

notas = []
ak = 0
k = 0

while k < 4:
    x = int(input("Digite uma nota: "))
    notas.append(x) #Acrescentando 
    ak += notas [k] #Posição do contador
    k+=1
print ("Média: %.2f" %(ak/4))

print (notas)

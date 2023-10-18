# C. soma_dobro
# dados dois números inteiros retorna sua soma
# porém se os números forem iguais retorna o dobro da soma
# soma_dobro(1, 2) -> 3
# soma_dobro(2, 2) -> 8

def soma_dobro(a, b):
    if a == b:
        return (a+b)*2
    else:
        return a+b
    
while True:
    n1 = int(input("Digite um numero"))
    n2 = int(input("Digite outro numero"))
    print ("%d \n\n"%(soma_dobro(n1,n2)))


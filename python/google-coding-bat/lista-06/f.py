# F. dez
# dados dois inteiros a e b
# retorna True se um dos dois é 10 ou a soma é 10

def dez(a, b):
    if a == 10 or b == 10 or a+b == 10:
        return True

while True:
    n1 = int (input("Digite um Número inteiro: "))
    n2 = int (input("Digite um Número inteiro: "))

    if dez(n1,n2)==True:
        print ("TRUE, um dos dois numeros é 10 ou a soma é 10\n\n")

    else:
        print ("FALSE, um dos dois numeros não é 10 ou a soma não é 10\n\n")

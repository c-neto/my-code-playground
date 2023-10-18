# D. diff21
# dado um inteiro n retorna a diferença absoluta entre n e 21
# porém se o número for maior que 21 retorna dobro da diferença absoluta
# diff21(19) -> 2
# diff21(25) -> 8
# dica: abs(x) retorna o valor absoluto de x

def diff21(n):
    if n<=21:
        return 21-n
    elif n>21:
        return (n-21)*2

while True:
    n1 = int(input('Digite um Número: '))
    print ("%d \n\n" %(diff21(n1)))

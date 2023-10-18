# H. apaga
# seja uma string s e um inteiro n
# retorna uma nova string sem a posição n
# apaga('kitten', 1) -> 'ktten'
# apaga('kitten', 4) -> 'kittn'

def apaga(s, n):
    sq=list(s)
    sq[int(n)-1] = ""
    return "".join(sq)

while True:
    p = input("Digite um Palava: ")
    n1 = int (input("Digite a Posição da letra a ser apagada: "))
    print(apaga(p,n1))

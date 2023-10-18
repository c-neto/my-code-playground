# I. troca
# seja uma string s
# se s tiver tamanho <= 1 retorna ela mesma
# caso contrário troca a primeira e última letra
# troca('code') -> 'eodc'
# troca('a') -> 'a'
# troca('ab') -> 'ba'

def troca(s):
    
    string_quebrada=list(s)
    primeira_letra = string_quebrada[0]
    ultima_letra = string_quebrada[-1]
    string_quebrada [-1] = primeira_letra
    string_quebrada [0] = ultima_letra
    return "".join(string_quebrada)

while True:
    p = input("Digite um Palava: ")
    print(troca(p))

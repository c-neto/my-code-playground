# J. roda2
# rodar uma string s duas posições
# a string possui pelo menos 2 caracteres
# left2('Hello') -> 'lloHe'
# left2('Hi') -> 'Hi'

def roda2(s):
    ss = s[2:] + s[:2]
    return ss

while True:
    pal = input("Digite uma Palavra: ")
    print ( roda2(pal) )

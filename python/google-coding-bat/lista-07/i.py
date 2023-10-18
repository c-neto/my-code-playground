# I. sem_pontas
# seja uma string s de pelo menos dois caracteres
# retorna uma string sem o primeiro e último caracter
# without_end('Hello') -> 'ell'
# without_end('python') -> 'ytho'
# without_end('coding') -> 'odin'

def sem_pontas(s):
    s = s[1:-1]
    return s

while True:
    pal = input("Digite uma Palavra: ")
    print ( sem_pontas(pal) )

# H. first_half
# seja uma string s
# retorna a primeira metade da string
# first_half('WooHoo') -> 'Woo'
# first_half('HelloThere') -> 'Hello'
# first_half('abcdef') -> 'abc'

def first_half(s):
    k=0
    ns = ''
    while k < int (len(s)/2):
        ns += s[k]
        k+=1
    return ns

while True:
    pal = input("Digite uma Palavra")
    print ( first_half(pal) )

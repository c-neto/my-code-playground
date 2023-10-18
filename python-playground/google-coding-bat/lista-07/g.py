# G. extra_end
# seja um string s com no mínimo duas letras
# retorna três vezes as duas últimas letras
# extra_end('Hello'), 'lololo'
# extra_end('ab'), 'ababab'
# extra_end('Hi'), 'HiHiHi' 

def extra_end(s):
    return s[-2:]*3

while True:
    pal = input("Digite uma Palavra")
    print ( extra_end(pal) )

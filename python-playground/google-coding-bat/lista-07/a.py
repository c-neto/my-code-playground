# A. multstring
# seja uma string s e um inteiro positivo n
# retorna uma string com n cópias da string original
# multstring('Hi', 2) -> 'HiHi'

def multstring(s, n):
  return s*n

pal = input ("Digite uma palavra...")
num = int ( input("Digite um numero") )

print ( multstring(pal, num) )

# Verifica se um número é soma de dois elementos distintos de uma lista
# soma_na_lista(5, [1, 2, 3, 4]) -> True
# soma_na_lista(9, [1, 2, 3, 4]) -> False
# soma_na_lista(0, [1, 2, 3, 4]) -> False
# soma_na_lista(8, [1, 2, 3, 4]) -> False
# soma_na_lista(4, [2, 2, 2, 2]) -> False
# soma_na_lista(4, [2, 2, 1, 3]) -> True

def soma_na_lista(n, lista):
	
	k=0
	kk=0
	d=0

	while k < len (lista):

		while kk < len (lista):
			if k==kk:
#				if kk<=len(lista):
#					kk+=0
#				else:
#					kk+=1	
				
			if int( lista[k]) + int( lista[kk]) == n:
				d+=1
			kk+=1
		k+=1
		
	
	if d>=1:
		return True

	else:
		return False

while True:

	n1 = int( input("Digite um Numero: "))
	conj = input ("Digite um Conjunto de Numero: ")

	print( soma_na_lista(n1, conj))


def same_first_last(a,b):
	
	n_xxx = list(a)
	n2_xxx = list(b)

	if n_xxx[:1] == n_xxx[1:2] or n2_xxx[:1] == n2_xxx[1:2]:
		return True
	else:
		return False

while True:

	n = ( input("Digite um conjunto de Números: ") )
	n2 = ( input("Digite outro Conjunto de Números: ") )

	if same_first_last(n,n2) == True:
		print ("Primeiro dois Digitos de um conjunto, É  igual aos dois ultimos digitos do outro conjunto")

	elif same_first_last(n,n2) == False:
		print ("Primeiro dois Digitos de um conjunto NÃO É igual aos doi dois ultimos digitos do outro conjuto")

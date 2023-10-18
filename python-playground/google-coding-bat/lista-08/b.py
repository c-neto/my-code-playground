def t6(nums):
	nq = list(nums)
	if nq[0] == nq[-1]:
		return True
	elif nq[0] != nq[-1]:
		return False

while True:

        n = ( input("Número: ") )
        if t6(n) == True:
                print ("Primeiro e Último número SÃO iguais")

        elif t6(n) == False:
                print ("Primeiro e Último número NÃO são iguais")

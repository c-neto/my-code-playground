# Verifica se na lista de números inteiros aparecem dois 2 consecutivos
# has22([1, 2, 2]) -> True
# has22([1, 2, 1, 2]) -> False
# has22([2, 1, 2]) -> False
def has22(nums):
	k = 0
	d = 0
	n_q = list(nums)

	while k < len (nums)-1:
		if nq[k] == nq[k+1]:
			d = 1
		k+=1
	if d==1:
		return True
	else:
		return False

while True:
	n = input("Digite um conjunto de Numeros: ")
	print( has22(n) )

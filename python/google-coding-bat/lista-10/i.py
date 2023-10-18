def count_evens (nums):
	k=0
	ak=0
	while k<len(nums):
		if int (nums [k])%2==0:
			ak+=1
		k+=1
	return ak

while True:
	p = input ("Digite um Conjunto de Numero: ")
	print ( count_evens(p) )

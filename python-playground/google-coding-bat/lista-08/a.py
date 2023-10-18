# A. first_last6
# verifica se 6 é o primeiro ou último elemento da lista nums
# first_last6([1, 2, 6]) -> True
# first_last6([6, 1, 2, 3]) -> True
# first_last6([3, 2, 1]) -> False
def fsrst_st6(nums):
	nq = list(nums)
	if nq[0] == '6' or nq[-1]:
		return True 


while True: 

	n = ( input("Número: ") )
	if fsrst_st6(n) == True:
		print ("Numero termina ou começa com 6")

	else:
		print ("Numero não começa ou termina com 6") 


# D. maior_ponta
# Dada uma lista não vazia, cria uma nova lista onde todos
# os elementos são o maior das duas pontas
# obs.: não é o maior de todos, mas entre as duas pontas
# maior_ponta([1, 2, 3]) -> [3, 3, 3]
# maior_ponta([1, 3, 2]) -> [2, 2, 2]

def maior_ponta(nums):
	
        k=0
        n_xxx=list(nums)
        vetor =[]

        if int (n_xxx [0]) <= int (n_xxx [-1]):
                while k < len (nums):
                        vetor.append(n_xxx [-1])
                        k+=1
                        
        elif int (n_xxx [-1]) <= int (n_xxx [0]):
                while k < len (nums):
                        vetor.append(n_xxx [-1])
                        k+=1       
        return vetor
while True:

	n =  input("Digite um conjunto de Números") 
	print( maior_ponta(n) )

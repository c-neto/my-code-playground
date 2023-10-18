def lone_sum(a, b, c):

	s = a+b+c
	if a==b or a==c:
		s=s-a
	if b==c or b==a:
		s=s-b
	if c==a or c==b:
		s=s-c
	return  s

while True: 
	
	n1 = int ( input("Digite um Numero: "))
	n2 = int ( input("Digite um Numero: "))
	n3 = int ( input("Digite um Numero: "))

	print (lone_sum(n1,n2,n3))

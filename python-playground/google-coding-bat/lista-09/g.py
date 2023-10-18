def count_code(s):
	k=0
	ak=0

	while k < len(s):
		if s[k]=='c' and s[k+1]=='o' and s[k+2]=='d' and s[k+3]=='e':
			ak+=1
		k+=1
	return ak

while True:
	p = input ("Digite uma Palavra: ")
	print ( count_code(p) )


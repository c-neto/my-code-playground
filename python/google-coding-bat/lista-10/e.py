def cout_hi (s):
	k=0
	ak=0
	while k < len(s):
		if s[k]=='h' and s[k+1]=='i':
			ak+=1
		k+=1
	return ak
while True:
	p = input ("Digite uma Palavra: ")
	print ( cout_hi(p) )

def cat_dog(s):
	k=0
	ak=0
	ak_c=0
	ak_d=0

	while k < len(s):
		if s[k]=='c' and s[k+1]=='a' and s[k+2]=='t':
			ak_c+=1

		if s[k]=='d' and s[k+1]=='o' and s[k+2]=='g':
                        ak_d+=1
		k+=1

	if (ak_c == ak_d ) and (ak_c and ak_d)!=0:
		return True
	else:
		return False

while True:
	p = input ("Digite uma Palavra: ")
	print ( cat_dog(p) )


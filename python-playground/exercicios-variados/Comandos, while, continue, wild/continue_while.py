#Quando X eh diferente de 0, X eh TRUE... Em qualquer liguagem de programacao
#isso tbm vale para lista nao vazia, quando tiver avacate eh True

x = 10
while x:
	x=x-1
	if x%2 != 0:
		continue
	print (x, end = ' ')

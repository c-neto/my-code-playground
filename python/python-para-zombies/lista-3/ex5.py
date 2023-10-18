c = 1
a = int(input('digite um número inteiro: '))
b = int(input('digite outro número inteiro: '))

while a or b or c != 0:

	if a > b:
		c = int(a % b)
		if c == 0:
			print ('o D.M.C é %d' %b)
			break
		if a == 0:
			print ('o D.M.C é %d' %c)
			break
		if b == 0:
			print ('o D.M.C é %d' %a)
			break
		a = c
	if a < b:
		c = int(b % a)
		if c == 0:
			print ('o D.M.C é %d' %a)
			break
		if a == 0:
			print ('o D.M.C é %d' %b)
			break
		if b == 0:
			print ('o D.M.C é %d' %c)
			break
		b = c

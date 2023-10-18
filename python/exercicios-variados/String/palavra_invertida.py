palavra = str(input('digite uma palavra: '))
#palindrome
if palavra == palavra[::-1]:
	print('%s é palindrome' %palavra)
else:
	print('%s não é palindrome' %palavra)

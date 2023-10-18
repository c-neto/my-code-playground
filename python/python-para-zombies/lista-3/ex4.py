valor_A = int(input('Insira um número (inteiro): '))
valor_B = int(input('Insira outro número (inteiro): '))
valor_C = valor_A + valor_B

while valor_A < 1000:

	print(valor_A,valor_B)
	valor_A = valor_C
	valor_B = valor_B + valor_C
	valor_C = valor_C + valor_B

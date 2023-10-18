velocidade = int(input('digite a velocidade atual do carro: '))

if velocidade > 110:
	multa = (velocidade - 110) * 5
	print ('Você foi multado em R$', multa)
else:
	print ('Você não foi multado!')

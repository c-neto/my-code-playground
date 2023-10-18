

def desenho(posicao):
    boneco = ['''
	+-------------------+
			    |
			    |
			    |
			    |
			    |
			    |
			    |
			    |
====================================''','''
	+-------------------+
	|		    |
	O		    |
			    |
			    |
			    |
			    |
			    |
			    |
====================================''','''
	+-------------------+
	|		    |
	O		    |
       /|		    |
			    |
			    |
			    |
			    |
			    |
====================================''','''
	+-------------------+
	|		    |
	O		    |
       /|\		    |
			    |
			    |
			    |
			    |
			    |
====================================''','''
	+-------------------+
	|		    |
	O		    |
       /|\		    |
       / 		    |
			    |
			    |
			    |
			    |
====================================''','''
	+-------------------+
	|		    |
	O		    |
       /|\		    |
       / \		    |
			    |
			    |
			    |
			    |
====================================''']
    print (boneco[posicao])

    if posicao > 4:
        posicao=0
def jogar_novamente():
	alternativa = input('Deseja jogar novamente? [S/n] ')
	if str(alternativa).lower() == 's':
		return desenho()
	elif str(alternativa).lower() == 'n':
		return print('fim de jogo!')
	else:
		return print("digite [S/n]",(jogar_novamente()))
	return
#função para contar os acertos e os erros por enquanto só com vogais e tals
def chute(letras):
    global k_desenho

    if letras in 'aeiou':
        print ("certo mizerávi")
    else:
        print ("Erouuu!!!")
        k_desenho+=1
        desenho (k_desenho)
    if k_desenho>4:
        print ('perdeu caralho')
        
    jogo ()
        
        
print ("BEM VINDO AO JOGO DA FORCA!!!")
k_chute = 0
k_desenho = 0
def jogo():
    x = input ("Diga o uma Letra: ")
    chute(x)

jogo()

import urllib.request

pagina = urllib.request.urlopen('https://www.ime.usp.br/~pf/dicios/br')
texto = pagina.read().decode('iso8859')
listona = texto.split('\n')

from random import randint
palavra = (listona[randint(0,int (len (listona)))])

palavra = list(palavra)
sublinhados = '_'*len(palavra)
sublinhados=list(sublinhados)
k_erro=0
while True:

	print ("\nSua palavra Contém %d letras" %(len(palavra)))	
	print (" ".join(sublinhados))
	chute = str (input ("\nDigite uma Letra: "))

	while len (chute)!= 1:
		chute = input ("\nDigite APENAS UMA palavra seu User do caralho")
	
	k=0
	while k < len (palavra):
		if chute == palavra[k]:
			print("\ncertô mizerávi")			
			sublinhados[k]=chute	
		k+=1	

	if chute not in palavra:
		k_erro+=1
		print("\nERRO CARALHO, mais %d erro vc tá fudido" %(5-k_erro) )

	if sublinhados==palavra:
		print("\nCERTO PORRA", "".join(palavra))
		break
	if k_erro==5:
		print("\nPERDEU PORRA")
		break

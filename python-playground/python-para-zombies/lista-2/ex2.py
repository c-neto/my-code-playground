#   2. Determine se um ano é bissexto. Verifique no Google como fazer isso...

ano = int (input("Digite o Ano: "))

resto4 = ano%4;
resto100 = ano%100;
resto400 = ano%400;

if (resto4==0):	
    if (resto100==0):
        if (resto400==0):
            print ("Ano Bissexto \nFim do Teste")		
        else:
            print ("Ano Normal \nFim do Teste")
    else:
        print ("Ano Bissexto \nFim do Teste")
else:
    print ("Ano Normal \nFim do Teste")	    

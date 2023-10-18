#   Questão D. Daniela é uma pessoa muito supersticiosa. Para ela,
#    um número é sortudo se ele contém o dígito 2 mas não o dígito 7.
#    Então, na opinião dela, quantos números sortudos existem
#    entre 18644 e 33087, incluindo os extremos?
#   Resposta: 7995

k = 18644
ak = 0
while k<33087:
    if "2" in str(k) and '7' not in str(k):
        ak+=1    
    k+=1
print ("Quantidade de Numeros da sorte: ", ak)

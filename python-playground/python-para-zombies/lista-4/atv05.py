#   5. Seja o mesmo texto acima “splitado”. Calcule quantas palavras possuem uma das letras “python”
#   e que tenham mais de 4 caracteres. Não se esqueça de transformar maiúsculas para minúsculas e de
#   remover antes os caracteres especiais.
    
lista_python = []
lista = '''the python software foundation and the global python community welcome and encourage participation by everyone
our community is based on mutual respect tolerance and encouragement and we are working to help each other live up to these principles
we want our community to be more diverse whoever you are and whatever your background we welcome you'''.split()
#contador = 0
print (lista,'\n')
for contador in range (len (lista)):
#while contador < len(lista):
 palavra_lista = lista [contador]
 if palavra_lista [0:-0] in 'python' and (len(palavra_lista))> 4:
  lista_python.append(palavra_lista)
# contador += 1
print('O número de palavras com as letras de "python" e com mais de 4 letras é',len(lista_python))

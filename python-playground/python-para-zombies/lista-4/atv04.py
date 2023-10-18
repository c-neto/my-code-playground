#   Gere uma lista de palavras deste texto com split(),
#   a seguir crie uma lista com as palavras
#   que começam ou terminam com uma das letras “python”.
#   Imprima a lista resultante. Não se esqueça de remover
#   antes os caracteres especiais e cuidado com maiúsculas e minúsculas.

text = '''the python software foundation and the global python community welcome and encourage participation by everyone
our community is based on mutual respect tolerance and encouragement and we are working to help each other live up to these principles
we want our community to be more diverse whoever you are and whatever your background we welcome you'''.lower()
text = text.replace(',',' ')
text = text.replace('.',' ')
text = text.replace(':',' ')
text = text.split()
k=[]
for x in range (len(text)):

    if text[x].startswith in "python":
        k.append(text[x])

    elif text[x].endswith in "python":
        k.append(text[x])
        
print ('Palavras que começam com --p, y, t, h, o, n', k)

arquivo = open ('numeros.txt', 'r')
for linha in arquivo.readlines():
    print(linha.rstrip())#tira os caracteres de controle
arquivo.close()

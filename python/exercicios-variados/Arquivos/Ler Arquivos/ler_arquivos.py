arquivos = open ('Numeros.txt', 'r')
for linha in arquivo.readlines():
    print(linha.rstrip())
arquivo.close()

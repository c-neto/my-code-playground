arquivo = open('arquivo.txt', 'w')          #criando arquivo ou sobrescrevendo

var_txt = "conteudo de uma variavel"
arquivo.write(var_txt+"Estou escrevendo no arquivo.txt")  #escrenvendo no arquivo

arquivo = open('arquivo.txt', 'a')       # >> append, acrescenta
arquivo.write("\nNovas linhas")          #escrenvendo no arquivo

arquivo = open('arquivo.txt', 'r')          #arquivo em modo leitura
print ( arquivo.read() )                    #le o arquivo

arquivo.close()                          #fechar o arquivo para abrir ou criar outro

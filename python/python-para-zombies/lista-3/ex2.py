n = input("Digite um nome de usuário: ")
s = input("Digite uma senha: ") 

while s==n: 
    print("Nome de usuário e senha se coincidem, \npor favor urtilizar NOME DE USUÁRIO e SENHA DISTINTOS. ")
    n = input("Digite um nome de usuário: ")
    s = input("Digite uma senha: ")
else:

    print ("Cadastro efetuado com sucesso")

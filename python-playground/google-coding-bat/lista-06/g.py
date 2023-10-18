# G. dista10
# seja um inteiro n
# retorna True se a diferença absoluta entre n e 100 ou n e 200
# for menor ou igual a 10
# dista10(93) -> True
# dista10(90) -> True
# dista10(89) -> False

def dista10(n):
  if (100-n1) <= 10 or (200-n1) <= 10:
      return True

while True:
    n1 = int (input("Digite um Número: "))
    if dista10(n1)==True:
        print("TRUE, A diferença absoluta entre n e 100 ou n e 200 é menor ou igual a 10")
    else:
        print("FALSE, A diferença absoluta entre n e 100 ou n e 200 não é menor ou igual a 10")

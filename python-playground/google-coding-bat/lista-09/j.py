def sum_13(a,b,c):
        s = 0
        while True:
                if a==13:
                        break
                else:
                        s=s+a
                if b==13:
                        break
                else:
                        s=s+b
                if c==13:
                        break
                else:
                        s=s+c
                        break
        return s

while True:

        n1 = int ( input("Digite um Numero: "))
        n2 = int ( input("Digite um Numero: "))
        n3 = int ( input("Digite um Numero: "))

        print (sum_13(n1,n2,n3))


# string = texto = "" 
# int = numerico
operador = input("Bem vindo ao N03m1A 5.0 qual conta você vai querer fazer: ")
 
a = input("qual o valor de A: ")
b = input("qual o valor de B: ")

a_numerico = int(a)
b_numerico = int(b)

if operador!="soma" and operador != "subtração" and operador!= "multiplicação" and operador!="divisão":
    print("ERRADO TENTE COLOCAR UM CONTA DE VERDADE")
    exit(1)

x = a_numerico+b_numerico

if operador=="soma":
    print("a soma é")
    print(x)

#;-; /              hi i am the ester egg

sub = a_numerico-b_numerico

if operador=="subtração":
    print("a subtração é")
    print(sub)

vez = a_numerico*b_numerico

if operador=="multiplicação":
    print("a multiplicação é")
    print(vez)

div = a_numerico/b_numerico

if operador=="divisão":
    print("a divisão é")
    print(div)

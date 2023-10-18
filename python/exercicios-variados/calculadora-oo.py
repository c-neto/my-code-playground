class CalculadoraClass():

    def __init__(self, a, b):
        self.a = a
        self.b = b
#   __init__ inicializa valores aos atributos dentro da classe, funcionamento parecido com um constructor em java
#   "self", indica a variavel de referencia de forma genérica
#   se eu instanciar "var = CalculadoraClass(10,5)", significa que "var" será "self"
#   "a", "b" são argumentos, no exemplo, "a" receberá "10", "b" receberá "5"
    def soma(self):
        return self.a + self.b

    def subtrai(self):
        return self.a - self.b

    def multiplica(self):
        return self.a * self.b

    def divide(self):
        return self.a / self.b

class MediaClass():

    def __init__(self, a, b, c):
        self.a = a
        self.b = b
        self.c = c

    def media(self):
        return (self.a+self.b+self.c)/3


var = CalculadoraClass(10,10)
#   assumi os atributos e métodos da classe "CalculadoraClass"

var2 = MediaClass(10,8,4)
#   assumi os atributos e métodos da classe "MediaClass"

print("Soma: ", var.soma() )
#   imprimirá: ('Soma: ', 20)

print("Media: ", var2.media() )
#   imprimirá: ('Media: ', 7)

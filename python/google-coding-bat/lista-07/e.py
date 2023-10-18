# E. hello_name
# seja uma string name
# hello_name('Bob') -> 'Hello Bob!'
# hello_name('Alice') -> 'Hello Alice!'
# hello_name('X') -> 'Hello X!'

def hello_name(name):
    return "Hello "+name

while True:
    pal = input("Digite seu Nome: ")
    print (hello_name(pal))

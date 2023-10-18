# F. make_tags
# make_tags('i', 'Yay'), '<i>Yay</i>'
# make_tags('i', 'Hello'), '<i>Hello</i>'
# make_tags('cite', 'Yay'), '<cite>Yay</cite>'

def make_tags(tab, word):
    return "<"+tab+">"+word+"</"+tab+">"

while True:
    tag = input("Digite a TAG")
    pal = input("Digite uma Palavra")

    print (make_tags(tag,pal))

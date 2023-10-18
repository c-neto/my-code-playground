# A. dormir
# dia_semana é True para dias na semana
# feriado é True nos feriados
# você pode ficar dormindo quando é feriado ou não é dia semana
# retorne True ou False conforme você vá dormir ou não

def dormir(dia,feriado):
        if feriado == 1 or dia == 6 or dia == 7:
            return True
    
while True:
    d = int(input("*** DIAS DA SEMANA ***\n1 - Segunda-Feira\n2 - Terça-Feira\n3 - Quarta-Feira\n4 - Quinta-Feira\n5 - Sexta-Feira\n6 - Sábado\n7 - Domingo\n\nDigite o Número do dia da semana: "))
    f = int(input("\n\n*** FERIADO ***-\n1 - Sim\n2 - Não\n\nHoje é Feriado?: "))

    if dormir (d,f) == True:
        print("\n\nPODE DORMIR\n\n")

    else:
        print("\n\nACORDA!!!, Bora pra FATEC ter aula do MASSA\n\n")

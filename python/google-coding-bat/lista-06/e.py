# E. papagaio
# temos um papagaio que fala alto
# hora é um parâmetro entre 0 e 23
# temos problemas se o papagaio estiver falando
# antes da 7 ou depois das 20

def papagaio(falando, hora):
    if falando == 'SIM' and (hora>20 or hora<7):
        return True

while True:
    papag = input("Papagaio está Falado? (Digite 'SIM' ou 'NAO'): ")
    horas = int ( input("Que horas são? (Informe apenas as Horas 0 a 23', não informe os minutos): ") )

    if papagaio(papag, horas) == True:
        print("PROBLEMA!!!")
    else:
        print ("Tranquilo...")



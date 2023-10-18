# J. alarm_clock
# day: 0=domingo, 1=segunda, 2=terça, ..., 6=sábado
# vacation = True caso você esteja de férias
# o retorno é uma string que diz quando o despertador tocará
# dias da semana '07:00'
# finais de semana '10:00'
# a menos que você esteja de férias, neste caso:
# dias da semana '10:00'
# finais de semana 'off'
# alarm_clock(1, False) -> '7:00'
# alarm_clock(5, False) -> '7:00'
# alarm_clock(0, False) -> '10:00'

def alarm_clock(day,vacation):
    x = ''
    if vacation == True:
        if day > 0 and day < 6:
            x = "10:00"
        elif day == 0 or day == 6:
            x = "off"
        else:
            x = "\n\n!!!Valor (day) NÃO Válido!!!\n\n"
    elif vacation == False:
        if day > 0 and day < 6:
            x = "07:00"
        elif day == 0 or day == 6:
            x = "10:00"
        else:
            x = "\n\n!!!Valor (day) NÃO Válido!!!\n\n"
    return x

 

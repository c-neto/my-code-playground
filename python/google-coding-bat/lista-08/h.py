def squirrel_play(temp, is_summer):
    
    if is_summer == 'SIM' or is_summer == True:
        if temp>=60 and temp<=100:
            return True
        else:
            return False
            
    elif is_summer == 'NÃO' or is_summer == False:
        if temp>=60 and temp<=90:
            return True
        else:
             return False

while True:
    v = input("É Verão? (Responda SIM ou NÃO)")
    t = int (input("Qual a Temperatura?"))

    print(squirrel_play(t,v))

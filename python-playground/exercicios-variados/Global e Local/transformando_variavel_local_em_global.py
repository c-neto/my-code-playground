a=5                         #Varaiável Global
def muda_e_imprime():       #
    global a                #A virou global
    a = 7
    print ("a dentro da função: %d" %a)
print ("A antes ")

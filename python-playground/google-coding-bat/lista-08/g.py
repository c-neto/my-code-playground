def date_fashion(eu, par):
    if (eu or par)<=2:
        return 0
    elif (eu and par)>8:
        return 2
    else:
        return 1
    
    
while True:
    x = int( input("Diga a NOTA da SUA Roupa: "))
    y = int( input("Diga a NOTA da roupa da sua NAMORADA"))

    print( date_fashion(x,y) )

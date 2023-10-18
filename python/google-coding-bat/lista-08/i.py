def pego_correndo(speed, is_birthday):

    tol=0
    
    if is_birthday == True:
        tol=5
    if speed<=(60+tol):
        return 0
    elif speed <=(80+tol):
        return 1
    elif speed >=(81+tol):
        return 2


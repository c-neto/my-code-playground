xxx = int (input("Fala aee"))

def fat(n):
    f=1
    while n > 0:
        f = f*n
        n = n-1
    return f

for i in range(xxx): print (fat(i))

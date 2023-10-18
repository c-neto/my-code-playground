meses = '''janeiro fevereiro março abril maio junho julho agosto setembro outubro novembro dezembro'''.split()
dd, mm, aaaa = input('dd/mm/aaaa: ').split('/')
print('%s de %s de %s' %(dd, meses[int(mm)-1], aaaa))

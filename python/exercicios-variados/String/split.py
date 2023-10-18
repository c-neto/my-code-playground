meses = '''Janeiro fevereiro Março Abril Junho Julho Agosto Setembro Outubro Novembro Dezembro'''.split()

d, m, a, = input ("dd/mm/aaaa: ").split('/')
print ("%s de %s de %s" %(d, meses [int(m)-1],a))

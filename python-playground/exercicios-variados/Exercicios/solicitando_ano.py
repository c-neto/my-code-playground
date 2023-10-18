'''
programa que solicita data de nascimento no formato (dd/mm/aaaa) e imprimir a data por extenso'''
data = input('digite a data no formato "dd/mm/aaaa" e a data será exibida em extenso: ')
dd, mm, aaaa = data.split ('/')
meses = ['','janeiro', 'fevereiro', 'março', 'abril', 'maio', 'junho', 'julho', 'agosto', 'setembro', 'outubro', 'novembro', 'dezembro']
mm = int(mm)
print ('dia', dd, 'de',meses[mm],'de', aaaa)




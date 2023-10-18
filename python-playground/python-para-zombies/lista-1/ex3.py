#   3) Escreva um programa que leia a quantidade de dias,
#   horas, minutos e segundos do usuário. Calcule o total em segundos.

d = float(input("Dias: "))
h = float(input("Horas: "))
m = float(input("Minutos: "))

print ("Segundos: ",(d*24*3600)+(60*m)+(3600*h))

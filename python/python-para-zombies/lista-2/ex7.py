#   7. Faça um programa para uma loja de tintas. O programa deverá pedir
#   o tamanho em metros quadrados da área a ser pintada. Considere que a
#   cobertura da tinta é de 1 litro para cada 3 metros quadrados e que a
#   tinta é vendida em latas de 18 litros, que custam R$ 80,00. Informe
#   ao usuário a quantidades de latas de tinta a serem compradas e o preço
#   total. Obs. : somente são vendidos um número inteiro de latas.


mq = float (input("Digite em metros quadrados, a área a ser pintada: "))
mp=0
l=0
k=0
lata=1

while mp < mq:
    mp+=3
    l+=1
    k+=1
    if (k==18):
        lata+=1
        k=0
        
p=lata*80

print("Você vai precisar de %d litros" %l)
print("Então será necessário comprar %d Lata de tinta de 18 Litros cada:" %lata)
print("Uma unidade de Lata de tinta custa R$80.00, então você gastará: R$:%.2f" %p)



pa = 80000
pb = 200000
ano = 0

while pa < pb:
    pa= pa+(pa*0.03)
    pb= pb+(pb*0.015)
    ano+=1
print ("Anos Necessário: ", ano)

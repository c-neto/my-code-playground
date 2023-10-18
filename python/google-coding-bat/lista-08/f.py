def middle_way(a,b):
        a_xxx=list(a)
        b_xxx=list(b)
        x=0
        aux=0
        vetor = []
        
        if len(a_xxx)%2 != 0:
                aux = int (len(a_xxx)/2)
                mieo_a = a_xxx[aux:-aux]
                vetor.append(meio_a)

        elif int (len (a_xxx))%2 == 0:
                x = int ( len(a_xxx)/2 )-1
                vetor.append(a_xxx[aux:-aux])  

        if len (b_xxx)%2 != 0:
                x = int ( len(b_xxx)/2 )-1
                vetor.append(b_xxx[aux:-aux])  

        elif int (len (b_xxx))%2 == 0:
                x = int ( len(b_xxx)/2 )-1
                vetor.append(b_xxx[aux:-aux])
        return "".join(vetor)


while True: 

        cn1 = input ("Digite um Conjunto de Número: ")
        cn2 = input ("Digite um Conjunto de Número: ")
        print ( middle_way(cn1, cn2) )

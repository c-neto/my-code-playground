# B. string_splosion
# string_splosion('Code') -> 'CCoCodCode'
# string_splosion('abc') -> 'aababc'
# string_splosion('ab') -> 'aab'

def string_splosion(s):
    sq=list(s)
    k = 0
    juncao = []
    kk = 0
    
    while k < int ( len (s)):
        while kk <= k:
            juncao.append(sq[kk])
            kk+=1
        k+=1
        kk=0
    
    return "".join(juncao)

pal = input ("Digite uma palavra: ")
print ( string_splosion(pal) )

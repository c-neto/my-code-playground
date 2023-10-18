# C. array_count9
# conta quantas vezes aparece o 9 numa lista nums

def array_count9(nums):
    k = 0
    ak = 0
    while k < len(nums):
        if nums[k] in '9':
            ak+=1
        k+=1
    return ak

while True:
    conj = input ("Digite um conjunto de números: ")
    print ( "%s \n\n" % (array_count9(conj)) )

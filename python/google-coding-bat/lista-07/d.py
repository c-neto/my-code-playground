# D. array_front9
# verifica se pelo menos um dos quatro primeiros é nove
# array_front9([1, 2, 9, 3, 4]) -> True
# array_front9([1, 2, 3, 4, 9]) -> False
# array_front9([1, 2, 3, 4, 5]) -> False

def array_front9(nums):

    if '9' in nums[:4]:
        return True
    else:
        return False

while True:
    conj = input ("Digite um conjunto de Números: ")
    print (array_front9(conj))

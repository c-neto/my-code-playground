'''definir função 'embaralha' e misturar strings de uma variável'''

def eu_quero_sabê(palavra):
    import random
    palavra = list(palavra)
    random.shuffle (palavra)
    return ''.join(palavra)

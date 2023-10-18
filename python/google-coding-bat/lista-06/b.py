# B. alunos_problema
# temos dois alunos a e b
# a_sorri e b_sorri indicam se a e b sorriem
# temos problemas quando ambos estão sorrindo ou ambos não estão sorrindo
# retorne True quando houver problemas

def alunos_problema(a_sorri, b_sorri):
    if (a_sorri == 'NAO' and b_sorri == 'NAO') or (a_sorri == 'SIM' and b_sorri == 'SIM'):
        return True
    else:
        return False

while True:
    print ("Digite 'SIM' ou 'NAO' para as respectivas perguntas")
    aluno_a = input("Aluno A está sorrindo?: ")
    aluno_b = input("Aluno B está sorrindo?: ")

    if alunos_problema(aluno_a, aluno_b) == True:
        print("\nPROBLEMA\n")

    else:
        print("\nSem Problemas\n")

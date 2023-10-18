# M.Difícil: Fila de tijolos sem usar loops
# queremos montar uma fila de tijolos de um tamanho denominado meta
# temos tijolos pequenos (tamanho 1) e tijolos grandes (tamanho 5)
# retorna True se for possível montar a fila de tijolos
# é possível uma solução sem usar for ou while
# fila_tijolos(3, 1, 8) -> True
# fila_tijolos(3, 1, 9) -> False
# fila_tijolos(3, 2, 10) -> True

def fila_tijolos(n_peq, n_gra, meta):
	if (n_peq*1)+(n_gra*5)>=meta:
		return True
	else:
		return False


while True:
	tp = int ( input("Numeros de Tijolos PEQUENOS: "))
	tg = int ( input("Numero de Tijolos GRANDES: "))
	mt = int ( input("Qual a sua Meta: "))
	print(fila_tijolos(tp,tg,mt))

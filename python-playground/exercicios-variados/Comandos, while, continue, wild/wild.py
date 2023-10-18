def f():
	yield 3
	yield 4
	yield 'abacate'
	yield 42


# return inteligente, entrega o resultado por demanda,,, eh jeito de guardar as coisa por estado

# x = f()
# next (x)

def fat():
	n = 1
	f = 1
	while True:
		f = f*n
		yield f
		n=n+1



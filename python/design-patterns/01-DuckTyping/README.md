# Duck Typing

É uma brincadeira que se pensa da seguinte forma:

```
" *Voa como pato? Anda como pato?, Nada como Pato? então é pato* "
```

Você insere uma instância como argumento de uma função, desde que ele esteja convencionada em um contrato que tenha detenha um conjunto de commpotamento condizente a sua entidade

---

* Quando passamos como parametro para uma metodo, a instancia de uma classe,

``
calculador.realiza_calculo(orcamento, ISS())
``

* E no escopo deste método, utilizamos um comportamento da instancia da classe passada

```
def realiza_calculo(self, orcamento, imposto):

    imposto_calculado = imposto.calcula(orcamento) # imposto = Duck Typing

    print(imposto_calculado)
```

* Isso so pode ser feito, pois foi convencionado um contrato para todo imposto, isto é, quem for um imposto deve ter o método calcula.

```
class ISS(object):

    def calcula(self, orcamento):

        return orcamento.valor * 0.1

class ICMS(object):

    def calcula(self, orcamento):

        return orcamento.valor * 0.5
```

---

# Conclusão

O animal (pato) no caso, é o imposto, que tem metodo *calcula* como todo imposto (análogamente seria voar, nadar etc..;)
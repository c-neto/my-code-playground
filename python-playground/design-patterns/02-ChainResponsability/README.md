# Chain Responsability

**Objetivo:** Evitar verificações procedurais de um método que fará uma lógica que necessite de uma propiedade de instância de uma classe.

**Como:** Cada responsabilidade será uma classe, e esta classe receberá no método construtor a próxima responsabilidade, criando uma corrente de responsabilidade.

---

A ideia do padrão é evitar que um metódo verifique as propiedades de uma instância varias as vezes, em um contexto em que estas propiedades por necessidade deverão de alguma forma ser verificadas de forma procedural.

Se tal verificação for feita pelo o método que manipula a instância (```calcula(self, orcamento):```), surgirá vários comandos de verificação de fluxo ```if```

```
class Calculador_de_descontos(object):

    def calcula(self, orcamento):

        if orcamento.total_itens > 5:
            return orcamento.valor * 0.1

        elif orcamento.valor > 500:
            return orcamento.valor * 0.07

        # outras possíveis regras aqui ...
        # vão surgir vários if neste contexto
```

Ao invés de escrevermos código procedural, e deixarmos um único método descobrir o que deve ser feito, quebramos essas responsabilidades em várias diferentes classes, e as unimos como uma corrente.


```
class Calculador_de_descontos(object):


    def calcula(self, orcamento):

        desconto = Desconto_por_cinco_itens(
            Desconto_por_mais_de_quinhentos_reais(
                Sem_desconto()
            )
        )
```


A responsabilidades são uma classe, e elas recebem a proxima responsabildiade como argumento em seu método construtor

```
class Desconto_por_cinco_itens(object):

  def __init__(self, proximo_desconto):
    self.__proximo_desconto = proximo_desconto

  def calcula(self, orcamento):

    if orcamento.total_itens > 5:
        return orcamento.valor * 0.1
    else:
      return self.__proximo_desconto.calcula(orcamento)

class Desconto_por_mais_de_quinhentos_reais(object):

  def __init__(self, proximo_desconto):
    self.__proximo_desconto = proximo_desconto

  def calcula(self, orcamento):

    if orcamento.valor > 500:
      return orcamento.valor * 0.07
    else:
      return self.proximo_desconto.calcula(orcamento)

class Sem_desconto(object):

  def calcula(self, orcamento):

    return 0
```
# Python e classes abstratas
Podemos deixar explícito nesse código que cada um desses métodos anotados com o **@abstractmethod**, tem que ser implementado pela classe que herdar a classe abstrata **Template_de_imposto_condicional**. Os métodos que não tiverem anotação, serão reaproveitadas pelas classes filhas.

```
from abc import ABCMeta, abstractmethod

class Template_de_imposto_condicional(object):

    __metaclass__ = ABCMeta

    def calcula(self, orcamento):
        if self.deve_usar_maxima_taxacao(orcamento):
            return self.maxima_taxacao(orcamento)
        else:
            return self.minima_taxacao(orcamento)

    @abstractmethod
    def deve_usar_maxima_taxacao(self, orcamento): 
        pass

    @abstractmethod
     def maxima_taxacao(self, orcamento): 
        pass

    @abstractmethod
    def minima_taxacao(self, orcamento): 
        pass

```

As classes filhas só tem por obrigação de implementar os métodos abstratos, os não abstratos, são omitidos, porém são exitentes

```
class ICPP(Template_de_imposto_condicional):

    def deve_usar_maxima_taxacao(self, orcamento):
        return orcamento.valor > 500

    def maxima_taxacao(self, orcamento):
        return orcamento.valor * 0.07

    def minima_taxacao(self, orcamento):
        return orcamento.valor * 0.05

class IKCV(Template_de_imposto_condicional):

    def deve_usar_maxima_taxacao(self, orcamento):
        return orcamento.valor > 500 and self.__tem_item_maior_que_100_reais(orcamento)

    def maxima_taxacao(self, orcamento):
        return orcamento.valor * 0.10

    def minima_taxacao(self, orcamento):
        return orcamento.valor * 0.06

    def __tem_item_maior_que_100_reais(self, orcamento):
        for item in orcamento.obter_itens():
            if item.valor > 100:
                return True
        return False
```


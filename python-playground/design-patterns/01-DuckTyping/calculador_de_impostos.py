#!/bin/python3.5
# -*- coding: UTF-8 -*-

from impostos import ICMS, ISS

class Calculador_de_impostos(object):

    def realiza_calculo(self, orcamento, imposto):

        imposto_calculado = imposto.calcula(orcamento) # imposto = Duck Typing

        print(imposto_calculado)

if __name__ == '__main__':

    from orcamento import Orcamento

    calculador = Calculador_de_impostos()

    orcamento = Orcamento(500)

    calculador.realiza_calculo(orcamento, ISS())
    calculador.realiza_calculo(orcamento, ICMS())
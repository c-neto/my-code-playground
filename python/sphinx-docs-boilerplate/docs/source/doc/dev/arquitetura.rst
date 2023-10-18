Arquitetura do módulo
======================

O seguinte diagrama, mostra as possíveis comunicações do módulo **my-module** com os demais serviços do sistema **my-module-enterprise**.

.. raw:: html
    :file: _static/diagram.svg



Estrutura do Código
===================

A estrutura básica do código se dá como base na seguinte estrutura::

    ├── config                  # Descricao rapida do q faz esse arquivo
    │   └── settings.json       # Descricao rapida do q faz esse arquivo
    ├── __init__.py             # Descricao rapida do q faz esse arquivo
    ├── requirements.txt        # Descricao rapida do q faz esse arquivo
    └── utils                   # Descricao rapida do q faz esse arquivo
        ├── log.py              # Descricao rapida do q faz esse arquivo
        └── ...                 # tres pontos para coisas que nao precisa explicar
            └── log.cpython-37.pyc


.. note::

    Foi adotado a criação dos objetos por meio de um *Abstract Factory*, por que no início do desenvolvimento do produto, não se tinha uma definição exata da tecnologias/bibliotecas a serem utilizadas, então foi adotado este formato para que mudanças de tecnologias não impactem a corpo das rotinas.
    O único submódulo que não possuí interfaces a serem implementadas, blablabla.


Documentação do Código Fonte
============================

Esta seção concentra a documentação dos Submódulos, Classes, Métodos e Rotinas a nível de código. 

Para consultar a documentação agruprado por classes e métodos, acessar . Já para consulta da documentação agrupadas por Submódulos, acessar

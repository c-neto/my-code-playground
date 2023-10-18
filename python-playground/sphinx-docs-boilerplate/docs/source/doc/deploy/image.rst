Imagem de container
===================

O **my-module** possui uma rotina automática para a criação de imagens de containers, e entrega ao servidor de repositório [SERVIDOR]. A rotina cria e entrega imagens compatíveis com arquitetura ``x86`` e ``arm32v7``.


Estrutura do nome de Registro
-----------------------------

O nome de registro da imagem segue o seguinte formato ``[REPOSITORIO]/my-module``. Assim, na atual versão, o registro de ``my-module`` está assim::

    dockerhub/my-module

As tags das imagens indicam a versão do projeto, o ambiente e a arquitetura correspondente. Para tags de versão de produção, e adotado a estrutura ``ARQUITETURA-VERSÃO``, para tags de *desenvolvimento* e *homologação* é adotado a estrutura ``ARQUITETURA-AMBIENTE``. Segue em tópico a descrição dos componentes das tags:

* ``VERSÃO``: A versão do projeto é composta por três digitos separados por ``.``, primeiro dígito indica a versão do projeto a nível de funcionalidades, o segundo dígito obdece a nível de características, e o terceiro dígito obdece a nível de correções de bugs;

* ``AMBIENTE``: O ambiente define qual estágio a imagem foi preparada. Para imagens em testes em ambiente de desenvolvimento, receberá o rótulo de `develop`;  Para imagens em etapas de validação em equipamentos em campo, receberá o rótulo `homolog` e por fim, imagens maduras e estáveis, não recebem nenhum rótulo;

* ``ARQUITETURA``: Definida pelo valores ``x86`` e ``arm``, e como os propios nomes indicam, o valor ``x86`` define imagem para estrutura x86 e ``arm`` define arm32v7.


Links para Download
-------------------

A atual versão está disponivel para download com os seguintes registros:

+---------------+------------------+------------------------------------------------------------------------------+
| Arquitetura   | Ambiente         |   Registro                                                                   |
+===============+==================+==============================================================================+
|  arm32v7      | Produção         |  ``dockerhub/my-module:arm-0.1.0``                                           |
+---------------+------------------+------------------------------------------------------------------------------+
|  x86          | Produção         |  ``dockerhub/my-module:x86-0.1.0``                                           |
+---------------+------------------+------------------------------------------------------------------------------+


.. note::
   As versões de homologação e desenvolvimento são sempre sobscrita pelas imagens mais recentes. 

.. warning::
   o campo ``[REPOSITORIO]`` do nome do registro da imagem está suscetível a mudanças.

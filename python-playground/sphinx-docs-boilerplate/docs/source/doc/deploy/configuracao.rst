Configuração
============

No diretório ``config/settings.json``, há a configuração do módulo. A estrutura do arquivo está no formato JSON,
contendo chaves correspondentes as classes do sistema, abaixo há um exemplo de um conteúdo válido.

.. code:: python

    {
      "default": {
      },
      "development": {
        "LOG": {
          "level": "CRITICAL",
          "persisted": true,
          "datetime_rotation": "00:00",
          "directory": "./.temp_dev/log"
        }
      },
      "production": {
        "LOG": {
          "level": "SUCCESS",
          "datetime_rotation": "00:00",
          "directory": "/var/log/fites/fites_scripts/sender/monitran_ws",
          "retention_days": "30 days",
          "persisted": "SUCCESS"
        }
      }
    }


Seção default
-------------

Descrição das chaves:

``Chave::Valor``
   A chave faz isso com esses valores blablabla



Seção development
-----------------

Descrição das chaves:

``Chave::Valor``
   A chave faz isso com esses valores blablabla



Seção production
----------------

Descrição das chaves:

``Chave::Valor``
   A chave faz isso com esses valores blablabla

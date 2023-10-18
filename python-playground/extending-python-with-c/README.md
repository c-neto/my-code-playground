# extending-python-with-c

- __Date__: 27/09/2020
- __Author__: [@augustoliks](https://github.com/augustoliks) | <carlos.santos110@fatec.sp.gov.br>

Write in C - Import in Python. Project for educational development purpose only.

# Requirements

Dependencies            | Version   
:--:                    | :--:
python                  | 3.7
python3-virtualenv      | 16.6.2-1
python3-devel           | 3.7.9-1
gcc                     | 9.3.1

# Project Stucture 

```
├── build.py            # Extension for build C modules using Poetry
├── pyproject.toml      # Poetry: Build Properties for build C module to Python Application 
├── setup.py            # Setuptools: Build Script and Linkage C module in Python Application
├── run.py              # Python Application, import modules builded in C
└── src
    └── fputsmodule.c   # Module in C language
```

# Work with PIP

## How to Build

```python
virtualenv --python=$(which python3) venv
source venv/bin/activate
python3 setup.py install
```

## How to Run

```python
source venv/bin/activate
python3 run.py

>>> I am file created by fputs function, write in C and import Python!

```

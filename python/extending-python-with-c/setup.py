from distutils.core import setup, Extension
from pathlib import Path


def main():
    setup(
        name="fputs",
        version="1.0.0",
        description="Python interface for the fputs C library function",
        author="Carlos Neto",
        author_email="carlos.santos110@fatec.sp.gov.br",
        ext_modules=[
            Extension(
                "fputs", 
                [str(Path("src", "fputsmodule.c"))]
            )
        ]
    )


if __name__ == "__main__":
    main()

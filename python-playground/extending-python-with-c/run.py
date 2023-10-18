from pathlib import Path
import fputs    # Interface Python - C


FILENAME = "out-test-file.txt"

fputs.fputs(
    "I am file created by fputs function, write in C and import Python!", 
    FILENAME
)

print(Path(FILENAME).read_text())

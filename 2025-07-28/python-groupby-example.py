from dataclasses import dataclass
from operator import attrgetter
from itertools import groupby

# Define a Band class with relevant attributes
@dataclass
class Band:
    name: str
    category: str
    genre: str
    country: str

# List of Band instances with various attributes
bands = [
    Band(name="The Beatles", category="Rock", genre="Rock", country="UK"),
    Band(name="Queen", category="Rock", genre="Rock", country="UK"),
    Band(name="The Rolling Stones", category="Rock", genre="Rock", country="UK"),
    Band(name="Led Zeppelin", category="Rock", genre="Rock", country="UK"),
    Band(name="The Who", category="Rock", genre="Rock", country="UK"),
    Band(name="Deep Purple", category="Rock", genre="Rock", country="UK"),
    Band(name="Nirvana", category="Rock", genre="Grunge", country="USA"),
    Band(name="Temple of the Dog", category="Rock", genre="Grunge", country="USA"),
    Band(name="Pearl Jam", category="Rock", genre="Grunge", country="USA"),
    Band(name="Soundgarden", category="Rock", genre="Grunge", country="USA"),
    Band(name="Alice in Chains", category="Rock", genre="Grunge", country="USA"),
    Band(name="Stone Temple Pilots", category="Rock", genre="Grunge", country="USA"),
    Band(name="Pink Floyd", category="Rock", genre="Progressive Rock", country="UK"),
    Band(name="Genesis", category="Rock", genre="Progressive Rock", country="UK"),
    Band(name="Yes", category="Rock", genre="Progressive Rock", country="UK"),
    Band(name="King Crimson", category="Rock", genre="Progressive Rock", country="UK"),
    Band(name="The Smiths", category="Rock", genre="Indie Rock", country="UK"),
    Band(name="Arctic Monkeys", category="Rock", genre="Indie Rock", country="UK"),
    Band(name="Pet Shop Boys", category="Pop", genre="Synth-pop", country="UK"),
    Band(name="Depeche Mode", category="Pop", genre="Synth-pop", country="UK"),
    Band(name="Erasure", category="Pop", genre="Synth-pop", country="UK"),
    Band(name="Korine", category="Pop", genre="Synth-pop", country="USA"),
    Band(name="Oasis", category="Rock", genre="Britpop", country="UK"),
    Band(name="Blur", category="Rock", genre="Britpop", country="UK"),
    Band(name="Pulp", category="Rock", genre="Britpop", country="UK"),
    Band(name="Echo & the Bunnymen", category="Rock", genre="Post-Punk", country="UK"),
    Band(name="Joy Division", category="Rock", genre="Post-Punk", country="UK"),
    Band(name="The Cure", category="Rock", genre="Post-Punk", country="UK"),
    Band(name="The Killers", category="Rock", genre="Alternative Rock", country="USA"),
    Band(name="R.E.M.", category="Rock", genre="Alternative Rock", country="USA"),
    Band(name="Radiohead", category="Rock", genre="Alternative Rock", country="UK"),
    Band(name="U2", category="Rock", genre="Rock", country="Ireland"),
    Band(name="Thin Lizzy", category="Rock", genre="Rock", country="Ireland"),
]

# Group bands using a dictionary with (genre, country, category) as key
bands_groupby_genre_country = {}

print("GROUPING BANDS BY (GENRE, COUNTRY, CATEGORY) USING A DICTIONARY:")

for band in bands:
    group_key = (band.genre, band.country, band.category)
    bands_groupby_genre_country.setdefault(group_key, []).append(band)

for (category, genre, country), band_group in bands_groupby_genre_country.items():
    print(f"\n>>> {category=}, {genre=}, {country=}")
    for band in band_group:
        print(f"- {band.name}")

print("\n\nGROUPING BANDS BY (GENRE, COUNTRY, CATEGORY) USING itertools.groupby:")

# Group bands using itertools.groupby and a lambda function as key
attribute_group = lambda item: (item.category, item.genre, item.country)

for (category, genre, country), group in groupby(bands, key=attribute_group):
    print(f"\n>>> {category=}, {genre=}, {country=}")
    for band in group:
        print(f"- {band.name}")

print("\n\nGROUPING BANDS BY (GENRE, COUNTRY, CATEGORY) USING itertools.groupby AND attrgetter:")

# Group bands using itertools.groupby and attrgetter as key
attribute_group = attrgetter("category", "genre", "country",)

for (category, genre, country), group in groupby(bands, key=attribute_group):
    print(f"\n>>> {category=}, {genre=}, {country=}")
    for band in group:
        print(f"- {band.name}")

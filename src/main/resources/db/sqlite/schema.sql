-- SQLite Schema

CREATE TABLE IF NOT EXISTS vets (
  id INTEGER PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30)
);
CREATE INDEX IF NOT EXISTS idx_vets_last_name ON vets(last_name);

CREATE TABLE IF NOT EXISTS specialties (
  id INTEGER PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX IF NOT EXISTS idx_specialties_name ON specialties(name);

CREATE TABLE IF NOT EXISTS vet_specialties (
  vet_id INTEGER NOT NULL,
  specialty_id INTEGER NOT NULL,
  FOREIGN KEY (vet_id) REFERENCES vets(id),
  FOREIGN KEY (specialty_id) REFERENCES specialties(id),
  UNIQUE (vet_id, specialty_id)
);

CREATE TABLE IF NOT EXISTS types (
  id INTEGER PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX IF NOT EXISTS idx_types_name ON types(name);

CREATE TABLE IF NOT EXISTS owners (
  id INTEGER PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  address VARCHAR(255),
  city VARCHAR(80),
  telephone VARCHAR(20)
);
CREATE INDEX IF NOT EXISTS idx_owners_last_name ON owners(last_name);

CREATE TABLE IF NOT EXISTS pets (
  id INTEGER PRIMARY KEY,
  name VARCHAR(30),
  birth_date DATE,
  type_id INTEGER NOT NULL,
  owner_id INTEGER,
  FOREIGN KEY (owner_id) REFERENCES owners(id),
  FOREIGN KEY (type_id) REFERENCES types(id)
);
CREATE INDEX IF NOT EXISTS idx_pets_name ON pets(name);

CREATE TABLE IF NOT EXISTS visits (
  id INTEGER PRIMARY KEY,
  pet_id INTEGER,
  visit_date DATE,
  description VARCHAR(255),
  FOREIGN KEY (pet_id) REFERENCES pets(id)
);

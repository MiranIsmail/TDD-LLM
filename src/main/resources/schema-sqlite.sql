CREATE TABLE IF NOT EXISTS vets (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  first_name TEXT,
  last_name TEXT
);

CREATE TABLE IF NOT EXISTS specialties (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT
);

CREATE TABLE IF NOT EXISTS vet_specialties (
  vet_id INTEGER NOT NULL,
  specialty_id INTEGER NOT NULL,
  FOREIGN KEY (vet_id) REFERENCES vets(id),
  FOREIGN KEY (specialty_id) REFERENCES specialties(id)
);

CREATE TABLE IF NOT EXISTS types (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT
);

CREATE TABLE IF NOT EXISTS owners (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  first_name TEXT,
  last_name TEXT,
  address TEXT,
  city TEXT,
  telephone TEXT,
  username TEXT UNIQUE,
  password TEXT,
  authority_level TEXT DEFAULT 'USER'
);

CREATE TABLE IF NOT EXISTS pets (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT,
  birth_date DATE,
  type_id INTEGER NOT NULL,
  owner_id INTEGER NOT NULL,
  FOREIGN KEY (type_id) REFERENCES types(id)
);

CREATE TABLE IF NOT EXISTS visits (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  visit_date DATE,
  description TEXT,
  pet_id INTEGER NOT NULL,
  FOREIGN KEY (pet_id) REFERENCES pets(id)
);
CREATE TABLE IF NOT EXISTS clinic_users (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  first_name TEXT,
  last_name TEXT,
  username TEXT,
  password TEXT,
  authority_level TEXT,
  UNIQUE(username)
);

INSERT OR IGNORE INTO owners (first_name, last_name, address, city, telephone,username,password)
VALUES ('Felix', 'Andersson', 'Kalle', 'K', '1234567890','fean','123' );

INSERT OR IGNORE INTO clinic_users (first_name, last_name,username,password,authority_level)
VALUES ('Belix', 'Fandersson','befa','123','ADMIN' );

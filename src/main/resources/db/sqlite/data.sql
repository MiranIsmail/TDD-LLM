-- ======================================================================
-- 1. REFERENCE DATA
-- ======================================================================

-- Vets
INSERT OR IGNORE INTO vets VALUES (1, 'James', 'Carter');
INSERT OR IGNORE INTO vets VALUES (2, 'Helen', 'Leary');
INSERT OR IGNORE INTO vets VALUES (3, 'Linda', 'Douglas');
INSERT OR IGNORE INTO vets VALUES (4, 'Rafael', 'Ortega');
INSERT OR IGNORE INTO vets VALUES (5, 'Henry', 'Stevens');
INSERT OR IGNORE INTO vets VALUES (6, 'Sharon', 'Jenkins');

-- Specialties
INSERT OR IGNORE INTO specialties VALUES (1, 'radiology');
INSERT OR IGNORE INTO specialties VALUES (2, 'surgery');
INSERT OR IGNORE INTO specialties VALUES (3, 'dentistry');

-- Vet Specialties
INSERT OR IGNORE INTO vet_specialties VALUES (2, 1);
INSERT OR IGNORE INTO vet_specialties VALUES (3, 2);
INSERT OR IGNORE INTO vet_specialties VALUES (3, 3);
INSERT OR IGNORE INTO vet_specialties VALUES (4, 2);
INSERT OR IGNORE INTO vet_specialties VALUES (5, 1);

-- Types
INSERT OR IGNORE INTO types VALUES (1, 'cat');
INSERT OR IGNORE INTO types VALUES (2, 'dog');
INSERT OR IGNORE INTO types VALUES (3, 'lizard');
INSERT OR IGNORE INTO types VALUES (4, 'snake');
INSERT OR IGNORE INTO types VALUES (5, 'bird');
INSERT OR IGNORE INTO types VALUES (6, 'hamster');

-- ======================================================================
-- 2. USERS (Base Table)
-- ======================================================================

-- System Users
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (1, 'Admin', 'System', 'ADMIN', 'admin', 'admin');
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (2, 'Vet', 'System', 'VET', 'vet', 'vet');
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (3, 'Generic', 'Owner', 'OWNER', 'user', 'user');

INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (4, 'George', 'Franklin', 'OWNER', 'gfranklin', '123');
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (5, 'Betty', 'Davis', 'OWNER', 'bdavis', '123');
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (6, 'Eduardo', 'Rodriquez', 'OWNER', 'erodriquez', '123');
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (7, 'Harold', 'Davis', 'OWNER', 'hdavis', '123');
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (8, 'Peter', 'McTavish', 'OWNER', 'pmctavish', '123');
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (9, 'Jean', 'Coleman', 'OWNER', 'jcoleman', '123');
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (10, 'Jeff', 'Black', 'OWNER', 'jblack', '123');
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (11, 'Maria', 'Escobito', 'OWNER', 'mescobito', '123');
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (12, 'David', 'Schroeder', 'OWNER', 'dschroeder', '123');
INSERT OR IGNORE INTO users (id, first_name, last_name, role, username, password) VALUES (13, 'Carlos', 'Estaban', 'OWNER', 'cestaban', '123');

-- ======================================================================
-- 3. OWNERS
-- ======================================================================

INSERT OR IGNORE INTO owners (id, address, city, telephone) VALUES (4, '110 W. Liberty St.', 'Madison', '6085551023');
INSERT OR IGNORE INTO owners (id, address, city, telephone) VALUES (5, '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
INSERT OR IGNORE INTO owners (id, address, city, telephone) VALUES (6, '2693 Commerce St.', 'McFarland', '6085558763');
INSERT OR IGNORE INTO owners (id, address, city, telephone) VALUES (7, '563 Friendly St.', 'Windsor', '6085553198');
INSERT OR IGNORE INTO owners (id, address, city, telephone) VALUES (8, '2387 S. Fair Way', 'Madison', '6085552765');
INSERT OR IGNORE INTO owners (id, address, city, telephone) VALUES (9, '105 N. Lake St.', 'Monona', '6085552654');
INSERT OR IGNORE INTO owners (id, address, city, telephone) VALUES (10, '1450 Oak Blvd.', 'Monona', '6085555387');
INSERT OR IGNORE INTO owners (id, address, city, telephone) VALUES (11, '345 Maple St.', 'Madison', '6085557683');
INSERT OR IGNORE INTO owners (id, address, city, telephone) VALUES (12, '2749 Blackhawk Trail', 'Madison', '6085559435');
INSERT OR IGNORE INTO owners (id, address, city, telephone) VALUES (13, '2335 Independence La.', 'Waunakee', '6085555487');

-- ======================================================================
-- 4. PETS
-- ======================================================================

INSERT OR IGNORE INTO pets VALUES (1, 'Leo', '2000-09-07', 1, 4);
INSERT OR IGNORE INTO pets VALUES (2, 'Basil', '2002-08-06', 6, 5);
INSERT OR IGNORE INTO pets VALUES (3, 'Rosy', '2001-04-17', 2, 5);
INSERT OR IGNORE INTO pets VALUES (4, 'Jewel', '2000-03-07', 2, 5);
INSERT OR IGNORE INTO pets VALUES (5, 'Iggy', '2000-11-30', 3, 6);
INSERT OR IGNORE INTO pets VALUES (6, 'George', '2000-01-20', 4, 7);
INSERT OR IGNORE INTO pets VALUES (7, 'Samantha', '1995-09-04', 1, 8);
INSERT OR IGNORE INTO pets VALUES (8, 'Max', '1995-09-04', 1, 8);
INSERT OR IGNORE INTO pets VALUES (9, 'Lucky', '1999-08-06', 5, 9);
INSERT OR IGNORE INTO pets VALUES (10, 'Mulligan', '1997-02-24', 2, 10);
INSERT OR IGNORE INTO pets VALUES (11, 'Freddy', '2000-03-09', 5, 11);
INSERT OR IGNORE INTO pets VALUES (12, 'Lucky', '2000-06-24', 2, 12);
INSERT OR IGNORE INTO pets VALUES (13, 'Sly', '2002-06-08', 1, 12);

-- ======================================================================
-- 5. VISITS
-- ======================================================================

INSERT OR IGNORE INTO visits VALUES (1, 7, '2010-03-04', 'rabies shot');
INSERT OR IGNORE INTO visits VALUES (2, 8, '2011-03-04', 'rabies shot');
INSERT OR IGNORE INTO visits VALUES (3, 8, '2009-06-04', 'neutered');
INSERT OR IGNORE INTO visits VALUES (4, 7, '2008-09-04', 'spayed');

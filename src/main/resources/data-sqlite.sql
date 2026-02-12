-- Types (Checking by ID because you explicitly provided IDs)
INSERT INTO types (id, name)
SELECT 1, 'cat'
WHERE NOT EXISTS (SELECT 1 FROM types WHERE id = 1);

INSERT INTO types (id, name)
SELECT 2, 'dog'
WHERE NOT EXISTS (SELECT 1 FROM types WHERE id = 2);

INSERT INTO types (id, name)
SELECT 3, 'lizard'
WHERE NOT EXISTS (SELECT 1 FROM types WHERE id = 3);

INSERT INTO types (id, name)
SELECT 4, 'snake'
WHERE NOT EXISTS (SELECT 1 FROM types WHERE id = 4);

INSERT INTO types (id, name)
SELECT 5, 'bird'
WHERE NOT EXISTS (SELECT 1 FROM types WHERE id = 5);

INSERT INTO types (id, name)
SELECT 6, 'hamster'
WHERE NOT EXISTS (SELECT 1 FROM types WHERE id = 6);

-- Specialties (Checking by ID)
INSERT INTO specialties (id, name)
SELECT 1, 'radiology'
WHERE NOT EXISTS (SELECT 1 FROM specialties WHERE id = 1);

INSERT INTO specialties (id, name)
SELECT 2, 'surgery'
WHERE NOT EXISTS (SELECT 1 FROM specialties WHERE id = 2);

INSERT INTO specialties (id, name)
SELECT 3, 'dentistry'
WHERE NOT EXISTS (SELECT 1 FROM specialties WHERE id = 3);

-- Vets (Checking by Name because IDs are auto-generated here)
INSERT INTO vets (first_name, last_name)
SELECT 'Felix', 'Andersson'
WHERE NOT EXISTS (SELECT 1 FROM vets WHERE first_name = 'Felix' AND last_name = 'Andersson');

INSERT INTO vets (first_name, last_name)
SELECT 'Belix', 'Fandersson'
WHERE NOT EXISTS (SELECT 1 FROM vets WHERE first_name = 'Belix' AND last_name = 'Fandersson');

-- Vet Specialties (Checking the relationship)
INSERT INTO vet_specialties (vet_id, specialty_id)
SELECT 2, 2
WHERE NOT EXISTS (SELECT 1 FROM vet_specialties WHERE vet_id = 2 AND specialty_id = 2);

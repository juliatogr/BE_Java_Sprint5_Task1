USE testdb;

DROP TABLE IF EXISTS sucursals ;

INSERT INTO sucursals(nom, pais) VALUES 
("Llantas y motores", "Espanya"),
("Merch", "Regne Unit"),
("Playground", "Dinamarca"),
("CustomI", "Itàlia")
;

SELECT * FROM sucursals;
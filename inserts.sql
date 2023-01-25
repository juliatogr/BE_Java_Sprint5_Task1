USE testdb;

DROP TABLE IF EXISTS sucursal ;

INSERT INTO sucursal(nom, pais) VALUES 
("Llantas y motores", "Espanya"),
("Merch", "Regne Unit"),
("Playground", "Dinamarca"),
("CustomI", "Itàlia")
;

SELECT * FROM sucursal;
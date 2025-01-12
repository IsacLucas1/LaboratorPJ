CREATE TABLE IF NOT EXISTS `masini2` (
  `nr_inmatriculare` varchar(7) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `anul` int NOT NULL,
  `culoare` varchar(45) NOT NULL,
  `numar_km` int NOT NULL,
  PRIMARY KEY (`nr_inmatriculare`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `lab9`.`masini2`
(nr_inmatriculare,
marca,
anul,
culoare,
numar_km)
VALUES
('TM11ALH',
'audi',
2023,
'alb',
20000);

INSERT INTO `lab9`.`masini2`
(nr_inmatriculare,
marca,
anul,
culoare,
numar_km)
VALUES
('CT23SOL',
'mercedes',
2019,
'rosu',
124000);

INSERT INTO `lab9`.`masini2`
(nr_inmatriculare,
marca,
anul,
culoare,
numar_km)
VALUES
('GJ19KKK',
'dacia',
2000,
'negru',
300000);

INSERT INTO `lab9`.`masini2`
(nr_inmatriculare,
marca,
anul,
culoare,
numar_km)
VALUES
('NT99OOP',
'aro',
1989,
'gri',
450000);

INSERT INTO `lab9`.`masini2`
(nr_inmatriculare,
marca,
anul,
culoare,
numar_km)
VALUES
('CJ45TMT',
'lada',
2024,
'portocaliu',
10000);

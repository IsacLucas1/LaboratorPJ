CREATE TABLE IF NOT EXISTS `masini3` (
  `anul` int NOT NULL,
  `numarkm` int NOT NULL,
  `culoare` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `nrInmatriculare` varchar(255) NOT NULL,
  PRIMARY KEY (`nrInmatriculare`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `lab9`.`masini3`
(nrInmatriculare,
marca,
anul,
culoare,
numarkm)
VALUES
('TM11ALH',
'audi',
2023,
'alb',
20000);

INSERT INTO `lab9`.`masini3`
(nrInmatriculare,
marca,
anul,
culoare,
numarkm)
VALUES
('CT23SOL',
'mercedes',
2019,
'rosu',
124000);

INSERT INTO `lab9`.`masini3`
(nrInmatriculare,
marca,
anul,
culoare,
numarkm)
VALUES
('GJ19KKK',
'dacia',
2000,
'negru',
300000);

INSERT INTO `lab9`.`masini3`
(nrInmatriculare,
marca,
anul,
culoare,
numarkm)
VALUES
('NT99OOP',
'aro',
1989,
'gri',
450000);

INSERT INTO `lab9`.`masini3`
(nrInmatriculare,
marca,
anul,
culoare,
numarkm)
VALUES
('CJ45TMT',
'lada',
2024,
'portocaliu',
10000);

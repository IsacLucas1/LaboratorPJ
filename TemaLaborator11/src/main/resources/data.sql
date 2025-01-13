CREATE TABLE `evenimente` (
  `id` int NOT NULL,
  `denumire` varchar(45) NOT NULL,
  `locatie` varchar(45) NOT NULL,
  `data` date NOT NULL,
  `timp` time NOT NULL,
  `pretBilet` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO eveniment (denumire, locatie, data, timp, pret_bilet)
VALUES ('Film', 'CinemaCity', '2024-06-09', '21:00:00', 35.0);

INSERT INTO eveniment (denumire, locatie, data, timp, pret_bilet)
VALUES ('Meci de Fotbal', 'Camp Nou', '2025-08-19', '22:00:00', 350.0);

INSERT INTO eveniment (denumire, locatie, data, timp, pret_bilet)
VALUES ('Olarit', 'Muzeul Satului', '2025-01-09', '17:00:00', 10.0);

INSERT INTO eveniment (denumire, locatie, data, timp, pret_bilet)
VALUES ('Laser Tag', 'Megazone', '2025-01-12', '19:00:00', 50.0);
CREATE TABLE IF NOT EXISTS `carti` (
  `isbn` varchar(50) NOT NULL,
  `titlul` varchar(45) NOT NULL,
  `autorul` varchar(45) NOT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT into carti (ISBN, Titlul, Autorul)
VALUES ('ISBN1', 'Scurta istorie a omenirii', 'Yuval Noah Harari');

INSERT into carti (ISBN, Titlul, Autorul)
VALUES ('ISBN2', 'Homo deus - Scurta istorie a viitorului', 'Yuval Noah Harari');

INSERT into carti (ISBN, Titlul, Autorul)
VALUES ('ISBN3', 'De veghe in lanul de secara', 'J.D. SALINGER');
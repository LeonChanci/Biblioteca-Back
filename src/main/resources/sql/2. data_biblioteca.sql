-- TRUNCATE TABLES
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE `biblioteca`.`cliente`;
TRUNCATE `biblioteca`.`libro`;
TRUNCATE `biblioteca`.`prestamo`;
SET FOREIGN_KEY_CHECKS = 1;

-- INSERT CLIENTES
INSERT INTO `biblioteca`.`cliente` (`id_cliente`, `nombres`, `apellidos`, `direccion`, `edad`, `telefono`)
VALUES
("863264988","Drake","Theory","P.O. Box 136, 4534 Lacinia St.",14,"(826) 607-2278"),
("617684636","Alexa","Morgan","Ap #732-8087 Dui. Road",14,"(830) 212-2247"),
("474771564","Johanna","Reigns","925-3988 Purus. St.",28,"(801) 370-4041"),
("394022487","Becky","Alford","P.O. Box 341, 7572 Odio Rd.",14,"(559) 398-7689"),
("885583622","Brock","Alford","9063 Aliquam, Road",18,"(732) 218-4844"),
("531254932","Clarke","Wyatt","461-4278 Dignissim Av.",16,"(443) 263-8555"),
("762085429","Cody","Rollins","177-1125 Consequat Ave",32,"(740) 271-3631"),
("363677933","Bianca","Neal","Ap #937-4424 Vestibulum. Street",49,"(792) 406-8858"),
("192758012","Drew","Watson","705-6031 Aliquam Street",44,"(362) 881-5943"),
("110410415","Mercedes","Balor","Ap #720-1833 Curabitur Av.",89,"(688) 944-6619"),
("262132898","Karl","Austin","241-9121 Fames St.",8,"(559) 596-3381"),
("644337170","Sami","Rollins","Ap #308-4700 Mollis Av.",12,"(508) 518-2967"),
("782668115","Charlotte","Riddle","Ap #696-6846 Ullamcorper Avenue",14,"(744) 344-7768"),
("182120056","Matthew","Heyman","Ap #268-1749 Id St.",17,"(185) 738-9267"),
("303265780","Shelton","Owens","Ap #206-5413 Vivamus St.",15,"(821) 880-6661");

-- INSERT LIBROS
INSERT INTO `biblioteca`.`libro` (`id_libro`, `nombre`, `descripcion`, `categoria`, `autor`, `ano`)
VALUES
(1,"La Maria", "viaje a través de los paisajes exuberantes del Valle del Cauca, donde la naturaleza se convierte en un personaje más de la historia", "Novela", "Jorse Isaaks", "1967"),
(2,"Harry Potter y la piedra filosofal", "Libro Harry Potter 1 - Inicios de Harry Potter", "Fantasía, Magia", "J. K. Rowling", "1997"),
(3,"Harry Potter y la cámara secreta", "Libro Harry Potter 2 - Magia", "Fantasía, Magia", "J. K. Rowling", "1998"),
(4,"Harry Potter y el prisionero de Azkaban", "Libro Harry Potter 3 - Familia", "Fantasía, Magia", "J. K. Rowling", "1999"),
(5,"Erase una vez un corazón roto", "História de Evangeline", "Fantasía", "Stephenie Garber", "2022"),
(6,"Las intermitencias de la muerte", "Un día las personas dejan de morir porque la muerte decide tomarse un tiempo.", "Novela", "José Saramago", "2005"),
(7,"Romper el circulo", "Lily Bloom conoce a alguien y se da cuenta de que esta persona no es como pensaba. Debe romper el circulo de maltrato.", "Novela", "Collen Over", "2016"),
(8,"El Principito", "Relato crítico hacía la vida adulta a través del viaje de un niño. Reflexionando sobre amistad, amor, la soledad, la Pérdida y el sentido de la vida.", "Novela Corta", "Antoine de Saint", "1943"),
(9,"Todos estamos hechos de estrellas", "Habla sobre aquellos eventos post traumticos qué vive un matrimonio después de la guerra de Afganistán y como los afecta en sus vidas.", "Ficción", "Román Coleman", "2018"),
(10,"Querido Nadie", "Historia de una joven  que vive un embarazo adolescente. Cuenta con sensibilidad lo que pasa en su vida y los cambios que ocurren.", "Ficción", "Berlie Doherty", "2011");

-- INSERT PRESTAMOS
INSERT INTO `biblioteca`.`prestamo` (`id_prestamo`, `id_cliente`, `id_libro`, `fecha_inicio`, `fecha_fin`)
VALUES
(1,"863264988",1,'2024-01-01','2024-03-01'),
(2,"617684636",2,'2024-06-15','2024-10-15'),
(3,"617684636",3,'2024-06-15','2024-10-15'),
(4,"617684636",4,'2024-06-15','2024-10-15'),
(5,"474771564",5,'2023-12-20','2024-02-15');
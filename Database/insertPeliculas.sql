USE taquilla_cine;

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE peliculas;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO peliculas (idPelicula, tituloPelicula, duracionPelicula, sinopsisPelicula, imgPelicula) VALUES
(null, 'El proyecto Adam', 106, 'Un piloto de combate del futuro viaja en el tiempo y se alía con su yo de 12 años para salvar el mundo.', '/es/studium/main/resources/img/adam.jpg'),

(null, 'Avatar', 162, 'En un exuberante planeta llamado Pandora viven los Na\'vi. Un exmarines se ve dividido entre seguir sus órdenes o proteger su nuevo hogar.', '/es/studium/main/resources/img/avatar.jpg'),

(null, 'Interstellar', 169, 'Un grupo de científicos y exploradores viaja a través de un agujero de gusano para encontrar un nuevo hogar para la humanidad.', '/es/studium/main/resources/img/interstellar.jpg'),

(null, 'Joker', 122, 'La historia del origen de Arthur Fleck, un hombre ignorado por la sociedad que se convierte en el icónico y desquiciado villano de Gotham.', '/es/studium/main/resources/img/joker.jpg'),

(null, 'Reservoir Dogs', 99, 'Seis criminales profesionales son contratados para un atraco, pero cuando la policía aparece, sospechan que hay un infiltrado entre ellos.', '/es/studium/main/resources/img/reservoir.jpg'),

(null, 'Salvar al soldado Ryan', 169, 'Tras el desembarco de Normandía, un grupo de soldados arriesga sus vidas para rescatar a un paracaidista cuyos hermanos han muerto en combate.', '/es/studium/main/resources/img/ryan.jpg');
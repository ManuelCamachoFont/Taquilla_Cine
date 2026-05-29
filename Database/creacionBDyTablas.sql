CREATE DATABASE taquilla_cine
CHARSET utf8mb4 COLLATE utf8mb4_spanish2_ci;

USE taquilla_cine;

CREATE TABLE peliculas(
	idPelicula INT AUTO_INCREMENT,
    tituloPelicula VARCHAR(180) NOT NULL,
    duracionPelicula INT NOT NULL,
    fechaEstrenoPelicula DATE NOT NULL,
    PRIMARY KEY (idPelicula)
);

CREATE TABLE tickets (
    idTicket INT AUTO_INCREMENT,
    tipoTicket VARCHAR(45) NOT NULL,
    precioTicket DECIMAL(4 , 2 ) NOT NULL,
    idPeliculaFK INT NOT NULL,
    PRIMARY KEY (idTicket),
    FOREIGN KEY (idPeliculaFK)
        REFERENCES peliculas (idPelicula)
);

CREATE TABLE ventas (
    idVenta INT AUTO_INCREMENT,
    fechaVenta DATE NOT NULL,
    cantidadVenta INT NOT NULL,
    totalVenta DECIMAL(5,2) NOT NULL,
    idTicketFK INT NOT NULL,
    PRIMARY KEY (idVenta),
    FOREIGN KEY (idTicketFK)
        REFERENCES tickets (idTicket)
);
ALTER TABLE peliculas
	CHANGE fechaEstrenoPelicula 
		sinopsisPelicula VARCHAR(300) NOT NULL;
        
ALTER TABLE tickets 
DROP FOREIGN KEY tickets_ibfk_1;

ALTER TABLE ventas 
ADD COLUMN idPeliculaFK INT NOT NULL,
ADD CONSTRAINT fk_ventas_peliculas
FOREIGN KEY (idPeliculaFK) REFERENCES peliculas (idPelicula);

ALTER TABLE tickets 
DROP COLUMN idPeliculaFK;
select * from tickets;
SELECT * FROM ventas
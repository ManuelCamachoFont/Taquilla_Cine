USE taquilla_cine;

CREATE USER 'clienteCine'@'localhost' IDENTIFIED BY 'studium';
GRANT SELECT ON taquilla_cine.peliculas TO 'clienteCine'@'localhost';
GRANT SELECT ON taquilla_cine.tickets TO 'clienteCine'@'localhost';
GRANT INSERT ON taquilla_cine.ventas TO 'clienteCine'@'localhost';

FLUSH PRIVILEGES;
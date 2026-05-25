USE taquilla_cine;

CREATE USER 'clienteCine'@'192.168.1.%' IDENTIFIED BY 'studium';
GRANT SELECT ON taquilla_cine.peliculas TO 'clienteCine'@'192.168.1.%';
GRANT SELECT ON taquilla_cine.tickets TO 'clienteCine'@'192.168.1.%';
GRANT INSERT ON taquilla_cine.ventas TO 'clienteCine'@'192.168.1.%';
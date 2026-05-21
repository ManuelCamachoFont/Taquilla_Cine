USE taquilla_cine;

CREATE USER 'adminCine'@'192.168.1.%' IDENTIFIED BY 'studium';
GRANT INSERT, DELETE, UPDATE, SELECT ON taquilla_cine.* TO 'adminCine'@'192.168.1.%';
FLUSH PRIVILEGES;

CREATE USER 'clienteCine'@'192.168.1.%' IDENTIFIED BY 'studium';
GRANT SELECT ON taquilla_cine.* TO 'clienteCine'@'192.168.1.%';
GRANT INSERT ON taquilla_cine.ventas TO 'clienteCine'@'192.168.1.%';
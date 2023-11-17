CREATE DATABASE `crud` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

-- crud.producto definition

CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `producto_id_IDX` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
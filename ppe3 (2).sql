-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  mer. 18 nov. 2020 à 09:31
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ppe3`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `Id_categorie` varchar(50) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id_categorie`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `idClients` varchar(100) NOT NULL,
  `MdpClient` varchar(50) DEFAULT NULL,
  `NomClient` varchar(50) DEFAULT NULL,
  `PrenomClient` varchar(50) DEFAULT NULL,
  `EmailClient` varchar(100) DEFAULT NULL,
  `TelephoneClient` varchar(50) DEFAULT NULL,
  `ProfilClient` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idClients`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `comprendre`
--

DROP TABLE IF EXISTS `comprendre`;
CREATE TABLE IF NOT EXISTS `comprendre` (
  `IdProduits` varchar(50) NOT NULL,
  `Id_Ventes` varchar(50) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdProduits`,`Id_Ventes`),
  KEY `Id_Ventes` (`Id_Ventes`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `e_date`
--

DROP TABLE IF EXISTS `e_date`;
CREATE TABLE IF NOT EXISTS `e_date` (
  `la_date` date NOT NULL,
  PRIMARY KEY (`la_date`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
CREATE TABLE IF NOT EXISTS `personnel` (
  `id` varchar(50) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `id_profil` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_profil` (`id_profil`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

DROP TABLE IF EXISTS `produits`;
CREATE TABLE IF NOT EXISTS `produits` (
  `IdProduits` varchar(50) NOT NULL,
  `NomCategorie` varchar(50) DEFAULT NULL,
  `nomProduit` varchar(50) DEFAULT NULL,
  `TarifProduit` varchar(50) DEFAULT NULL,
  `StockProduit` varchar(50) DEFAULT NULL,
  `ImageProduit` varchar(50) DEFAULT NULL,
  `PopulariteProduit` varchar(50) DEFAULT NULL,
  `Id_categorie` varchar(50) NOT NULL,
  PRIMARY KEY (`IdProduits`),
  KEY `Id_categorie` (`Id_categorie`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

DROP TABLE IF EXISTS `profil`;
CREATE TABLE IF NOT EXISTS `profil` (
  `id` varchar(50) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ventes`
--

DROP TABLE IF EXISTS `ventes`;
CREATE TABLE IF NOT EXISTS `ventes` (
  `Id_Ventes` varchar(50) NOT NULL,
  `date_vente` varchar(50) DEFAULT NULL,
  `id` varchar(50) NOT NULL,
  `idClients` varchar(100) NOT NULL,
  `la_date` date NOT NULL,
  PRIMARY KEY (`Id_Ventes`),
  KEY `id` (`id`),
  KEY `idClients` (`idClients`),
  KEY `la_date` (`la_date`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

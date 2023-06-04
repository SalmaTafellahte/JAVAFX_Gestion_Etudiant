-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 04 juin 2023 à 03:23
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `javafx`
--

-- --------------------------------------------------------

--
-- Structure de la table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `anneeScolaire` int(11) DEFAULT NULL,
  `codeMassar` varchar(50) DEFAULT NULL,
  `niveau` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `student`
--

INSERT INTO `student` (`id`, `nom`, `prenom`, `age`, `anneeScolaire`, `codeMassar`, `niveau`) VALUES
(1, 'SALMA', 'TAFELLAHTE', 21, 2023, 'D140028445', 'GI3'),
(2, 'MOHAMED', 'TAFELLAHTE', 20, 2023, 'D140028447', 'GI3'),
(3, 'Smith', 'Jane', 19, 2022, 'DEF456', 'Junior'),
(4, 'Johnson', 'Michael', 21, 2020, 'GHI789', 'Senior'),
(5, 'Garcia', 'Maria', 18, 2023, 'D1234567', 'GI3'),
(6, 'CHAIMAE', 'TAFELLAHTE', 18, 2023, 'D12345688', 'GI3');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2022 at 11:16 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pidev_travel_me`
--

-- --------------------------------------------------------

--
-- Table structure for table `commentaire`
--

CREATE TABLE `commentaire` (
  `id` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `posts_id` int(11) DEFAULT NULL,
  `commentaire` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_c` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `commentaire`
--

INSERT INTO `commentaire` (`id`, `client_id`, `posts_id`, `commentaire`, `date_c`) VALUES
(16, 9, 33, 'bbbbbbbbbb', '2022-05-16 19:27:45'),
(21, 2, 33, 'Ili yesthak ay haja hany mawjouda', '2022-05-16 20:49:34'),
(22, 2, 37, 'excelente', '2022-05-16 20:50:11'),
(23, NULL, 32, ',jjjjjjjjjjjjj', '2022-05-16 21:31:21'),
(24, NULL, 32, 'hhhhhhhhhhhh', '2022-05-16 21:32:36'),
(25, 2, 39, 'kzkzbjhcbzljcbze', '2022-05-17 09:47:45');

-- --------------------------------------------------------

--
-- Table structure for table `doctrine_migration_versions`
--

CREATE TABLE `doctrine_migration_versions` (
  `version` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `executed_at` datetime DEFAULT NULL,
  `execution_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `doctrine_migration_versions`
--

INSERT INTO `doctrine_migration_versions` (`version`, `executed_at`, `execution_time`) VALUES
('DoctrineMigrations\\Version20220406224215', '2022-04-07 00:42:24', 1665),
('DoctrineMigrations\\Version20220510211140', '2022-05-10 23:11:51', 1168),
('DoctrineMigrations\\Version20220510212331', '2022-05-10 23:23:37', 109),
('DoctrineMigrations\\Version20220516085457', '2022-05-16 10:55:04', 747),
('DoctrineMigrations\\Version20220516112919', '2022-05-16 13:30:06', 31);

-- --------------------------------------------------------

--
-- Table structure for table `excursion`
--

CREATE TABLE `excursion` (
  `id` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `nom_excursion` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description_excursion` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` date NOT NULL,
  `type_excursion` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lieu` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `valabilite` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `excursion`
--

INSERT INTO `excursion` (`id`, `client_id`, `nom_excursion`, `description_excursion`, `date`, `type_excursion`, `lieu`, `valabilite`, `image`, `prix`) VALUES
(1, NULL, 'djerba', 'zsdfghj', '2022-09-27', 'Historique', 'djerba', 'Propositon', '119.jpg', 125),
(2, 2, 'Temple d\'eau', 'edtryuio', '2022-05-16', 'Culturelle', 'Ariana', 'Valide', 'Temple_Eaux-622888324f111-6282b87597b17.jpeg', 30),
(3, 2, 'Rondone', 'datzvdkhazbkfabjf', '2022-05-18', 'Culturelle', 'Zaghouan', 'Valide', '956-62835da247aa2.jpeg', 154),
(4, NULL, 'mobile', 'jebdkjzbed', '2022-09-27', 'Culturelle', 'tunis', 'Propositon', '119.jpg', 15);

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `id` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `description_p` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hashtag_p` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `visibilite` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image_p` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date_p` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`id`, `client_id`, `description_p`, `hashtag_p`, `visibilite`, `image_p`, `date_p`) VALUES
(32, 9, ' azertyh', 'Voyage', 'public', 'null', '2022-05-16 18:58:21'),
(33, 2, 'dfghsadzfegrtfhyreqzA', 'Voyage', 'Anonyme', 'null', '2022-05-16 19:59:17'),
(34, 2, 'htyjtrezARHTRZEAzgrezeqgezef', 'Voyage', 'Public', '5EI2NTGD5BF2JHECYM2LT6L54Q-628291f4304ee.jpeg', '2022-05-16 20:03:32'),
(35, 9, ' hhhhhhhhhhhhhhhhhhn', 'Voyage', 'public', 'Badgebackground.png', '2022-05-16 19:10:07'),
(37, 2, 'ERTYHUIKOLMLK', 'Excursion', 'Public', 'null', '2022-05-16 20:48:22'),
(39, 2, 'mobile', 'Voyage', 'Public', '157.jpg', '2022-05-17 10:45:46');

-- --------------------------------------------------------

--
-- Table structure for table `post_like`
--

CREATE TABLE `post_like` (
  `id` int(11) NOT NULL,
  `post_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `post_like`
--

INSERT INTO `post_like` (`id`, `post_id`, `client_id`) VALUES
(44, 32, 2),
(46, 39, 2);

-- --------------------------------------------------------

--
-- Table structure for table `reclamation`
--

CREATE TABLE `reclamation` (
  `id` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `objet` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type_de_reclamation` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description_reclamation` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `etat` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `reclamation`
--

INSERT INTO `reclamation` (`id`, `client_id`, `objet`, `type_de_reclamation`, `description_reclamation`, `date`, `etat`) VALUES
(13, NULL, 'hhhhhhhhhhh', 'ggggggg', 'vgvvvvvvvvv', '2022-05-16', NULL),
(14, 16, ' hhhhhhh', 'Technique', 'hhhhhhhhhhhhh', '2022-05-16', 'traité'),
(15, 2, ' abuse ', 'Dans une Excursion', 'java', '2022-05-17', 'traité');

-- --------------------------------------------------------

--
-- Table structure for table `reservation_excursion`
--

CREATE TABLE `reservation_excursion` (
  `id` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `id_excursion_id` int(11) DEFAULT NULL,
  `date_reservation_excursion` date DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nb` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `reservation_excursion`
--

INSERT INTO `reservation_excursion` (`id`, `client_id`, `id_excursion_id`, `date_reservation_excursion`, `email`, `nb`) VALUES
(3, 2, 1, '2022-05-17', '35', 4),
(4, NULL, 4, '2022-05-17', 'Aziz.esprit.tn', 20);

-- --------------------------------------------------------

--
-- Table structure for table `reservation_restaurant`
--

CREATE TABLE `reservation_restaurant` (
  `id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `restaurant_id` int(11) NOT NULL,
  `date_reservation` date NOT NULL,
  `nbr_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `reservation_restaurant`
--

INSERT INTO `reservation_restaurant` (`id`, `client_id`, `restaurant_id`, `date_reservation`, `nbr_personne`) VALUES
(1, 2, 11, '2022-05-17', 5);

-- --------------------------------------------------------

--
-- Table structure for table `reservation_voyage`
--

CREATE TABLE `reservation_voyage` (
  `id` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `voyage_id` int(11) DEFAULT NULL,
  `date_reservation` date DEFAULT NULL,
  `travel_class` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `reservation_voyage`
--

INSERT INTO `reservation_voyage` (`id`, `client_id`, `voyage_id`, `date_reservation`, `travel_class`, `age`) VALUES
(8, 1, 6, '2022-04-02', 'Economic Class', 15),
(26, 1, 51, '2022-04-18', 'Business class', 32),
(27, 1, 46, '2022-04-07', 'business class', 43),
(28, 1, 46, '2022-04-18', 'First class', 22),
(29, 1, 71, '2022-03-31', 'Business class', 50),
(30, 1, 2, '2022-03-01', 'First class', 20),
(41, 2, 2, '2022-05-16', 'Economi class', 15),
(42, 2, 72, '2022-05-18', 'first class', 85),
(43, 1, 82, '2022-05-12', 'First class', 45);

-- --------------------------------------------------------

--
-- Table structure for table `resrrest`
--

CREATE TABLE `resrrest` (
  `Id` int(11) NOT NULL,
  `Nom_Restaurant` varchar(255) NOT NULL,
  `nom_Client` varchar(255) NOT NULL,
  `Nbr_Personne` int(11) NOT NULL,
  `Date_Reservation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rest`
--

CREATE TABLE `rest` (
  `id` int(11) NOT NULL,
  `Nom_Restaurant` varchar(255) NOT NULL,
  `Adresse_Restaurant` varchar(255) NOT NULL,
  `Num_Tel_Restaurant` int(11) NOT NULL,
  `Description_Restaurant` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rest`
--

INSERT INTO `rest` (`id`, `Nom_Restaurant`, `Adresse_Restaurant`, `Num_Tel_Restaurant`, `Description_Restaurant`) VALUES
(3, 'hafoud', 'tunis', 2813835, 'tres bon '),
(4, 'spafood', '', 12345678, 'excellent ');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

CREATE TABLE `restaurant` (
  `id` int(11) NOT NULL,
  `nom_restaurant` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresse_restaurant` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `num_tel_restaurant` int(11) NOT NULL,
  `description_restaurant` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `restaurant`
--

INSERT INTO `restaurant` (`id`, `nom_restaurant`, `adresse_restaurant`, `num_tel_restaurant`, `description_restaurant`, `image`) VALUES
(11, 'hafood', 'tunis', 28013835, 'tres bon', '123'),
(12, 'spafood', 'Rue manar', 12345678, 'excellent', '213');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `cin` int(11) NOT NULL,
  `user_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `roles` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '(DC2Type:json)',
  `activation_token` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reset_token` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `cin`, `user_name`, `numero`, `email`, `adresse`, `password`, `roles`, `activation_token`, `reset_token`, `image`) VALUES
(1, 99999999, 'Admin', 99999999, 'travel.me.pridev@gmail.com', 'TravelMe', '00000000', '[]', '', NULL, 'Admin-6229b29932dfd-624e18e4bb816.jpeg'),
(2, 13020205, 'Benismail', 21438447, 'aziz.270700@gmail.com', 'Tunisia', '123123123', '[]', 'e77f5cf6ecc374a6de3fee3426b40cea', NULL, '2-6246c29fb27dd-624e1b19c58d0.png'),
(8, 45896587, 'Sk', 14523698, 'Tn', 'Skander@esprit.tn', '123123123', '', NULL, NULL, NULL),
(9, 456123789, 'Oumaima', 21365478, 'oumaima@esprit.tn', 'tunisia', '123123123', NULL, NULL, NULL, NULL),
(11, 21461637, 'ahmeeed', 21461637, 'ahmed@gmail.com', '21461637', '21461637', '[]', '', NULL, 'Correction_Prosit3-6282aa8c8b62c.pdf'),
(12, 123456789, 'Admin', 9999999, 'mohamedaziz.benismail@esprit.tn', 'esprit', 'adminadmin', '[\"ROLE_ADMIN\"]', NULL, NULL, 'Admin-62293cd63c214-6282ac78b0052.jpeg'),
(13, 1234567896, 'mahmoud', 21461637, 'mahmoud@gmail.com', 'supcom', '21461637', NULL, NULL, NULL, NULL),
(16, 14009552, 'oumayma', NULL, 'oumayma.touil@esprit.tn', 'ariana', '55447400', '[]', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `voyage`
--

CREATE TABLE `voyage` (
  `id` int(11) NOT NULL,
  `clien_id` int(11) DEFAULT NULL,
  `destination` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom_voyage` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `duree_voyage` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` date DEFAULT NULL,
  `valabilite` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `voyage`
--

INSERT INTO `voyage` (`id`, `clien_id`, `destination`, `nom_voyage`, `duree_voyage`, `date`, `valabilite`, `image`, `prix`) VALUES
(1, 1, 'DZ', 'Algiria', '3 Jour 4 Nuit', '2026-04-23', 'Oui', 'uploads819-627af668603ab.jpeg', 750),
(2, 1, 'TN', 'Mestir', '7 JOUR 8 nuit', '2022-05-10', 'Oui', 'Randonnees-622898eb386fd-6282230fbca6a-628232d7be156.jpeg', 190),
(3, 1, 'QA', 'Qatar_world_Cup', '6 Jour 7 Nuit', '2022-05-18', 'Oui', 'Qatar Arab Cup-6223c43a266d8-624e1ae1e07f2.jpeg', 123),
(5, 1, 'MC', 'Marocco', '25 Jour 24 nuit', '2022-05-18', 'Bientot Disponible', 'Assystem-au-maroc-scaled.jpeg', 3500),
(6, 1, 'FR', 'France', '15 JOUR', '2022-05-18', 'Disponible', 'France-6223d7c86b103.jpeg', 2999),
(42, 1, 'Uk', 'Ukranie', '12 Jour', '2022-05-12', 'Bientot Disponible', '5EI2NTGD5BF2JHECYM2LT6L54Q.jpeg', 6550),
(45, 1, 'RS', 'Russie', '13 Jour', '2022-05-12', 'Disponible', 'Russie-62239cc5f2aa9.jpeg', 5250),
(46, 1, 'SY', 'Syria', '30 Jour', '2022-05-12', 'Non Disponible', '370-6282239b6867f.jpeg', 853),
(51, 1, 'JP', 'Japon', '9 Jour', '2022-05-12', 'Disponible', 'tokyo-6223a4e0cc8e9.jpeg', 7500),
(53, 1, 'SY', 'Dimask', '19 Jour', '2022-05-12', 'Disponible', '370.jpg', 800),
(64, 1, 'FR', 'Paris', '15 jour', '2022-05-12', 'Disponible', '947.jpg', 235),
(66, 1, 'DZ', 'Qsantina', '30 jour', '2022-05-12', 'Bientot Disponible', '688.jpg', 360),
(67, 1, 'SY', 'lathikiya', '29 Jour', '2022-05-12', 'Bientot Disponible', '370-6282239b6867f.jpeg', 1800),
(68, 1, 'US', 'USA', '20 Jour', '2022-05-12', 'Bientot Disponible', '213.jpg', 3600),
(69, 1, 'US', 'New York', '5 jour', '2022-05-12', 'Non Disponible', '213.jpg', 2000),
(70, 1, 'Ca', 'Cabec', '8 Jour', '2022-05-12', 'Disponible', '119.jpg', 3500),
(71, 1, 'Ca', 'Canada', '130 Jour', '2022-05-12', 'Disponible', '119.jpg', 1800),
(72, 1, 'BR', 'Brasile', '9 Jour', '2022-05-12', 'Bientot Disponible', '428.jpg', 500),
(73, 1, 'US', 'New York', '15 jour', '2022-05-03', 'Non Disponible', '679.jpg', 200),
(75, 1, 'USA', 'Dobai', '15 jour', '2022-05-12', 'Non Disponible', 'Dobai.jpg', 150),
(81, 1, 'Tn', 'Tunisia', '15 jour', '2022-05-17', 'Non Disponible', 'tunisie-6227736d37464.jpeg', 145),
(82, 2, 'SD', 'sudan', '3 Jour 4 Nuit', '2022-05-03', 'Bientot disponible', '213-62835d16e512a.jpeg', 5864);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_67F068BC19EB6921` (`client_id`),
  ADD KEY `IDX_67F068BCD5E258C5` (`posts_id`);

--
-- Indexes for table `doctrine_migration_versions`
--
ALTER TABLE `doctrine_migration_versions`
  ADD PRIMARY KEY (`version`);

--
-- Indexes for table `excursion`
--
ALTER TABLE `excursion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_9B08E72F19EB6921` (`client_id`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_5A8A6C8D19EB6921` (`client_id`);

--
-- Indexes for table `post_like`
--
ALTER TABLE `post_like`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_653627B84B89032C` (`post_id`),
  ADD KEY `IDX_653627B819EB6921` (`client_id`);

--
-- Indexes for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_CE60640419EB6921` (`client_id`);

--
-- Indexes for table `reservation_excursion`
--
ALTER TABLE `reservation_excursion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_814F86B019EB6921` (`client_id`),
  ADD KEY `IDX_814F86B069755C1D` (`id_excursion_id`);

--
-- Indexes for table `reservation_restaurant`
--
ALTER TABLE `reservation_restaurant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_8B3FDB8B19EB6921` (`client_id`),
  ADD KEY `IDX_8B3FDB8BB1E7706E` (`restaurant_id`);

--
-- Indexes for table `reservation_voyage`
--
ALTER TABLE `reservation_voyage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_776CC0CE19EB6921` (`client_id`),
  ADD KEY `IDX_776CC0CE68C9E5AF` (`voyage_id`);

--
-- Indexes for table `resrrest`
--
ALTER TABLE `resrrest`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `rest`
--
ALTER TABLE `rest`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `voyage`
--
ALTER TABLE `voyage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_3F9D89554B80641D` (`clien_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `excursion`
--
ALTER TABLE `excursion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `post_like`
--
ALTER TABLE `post_like`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `reservation_excursion`
--
ALTER TABLE `reservation_excursion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `reservation_restaurant`
--
ALTER TABLE `reservation_restaurant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `reservation_voyage`
--
ALTER TABLE `reservation_voyage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `resrrest`
--
ALTER TABLE `resrrest`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `rest`
--
ALTER TABLE `rest`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `voyage`
--
ALTER TABLE `voyage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `FK_67F068BC19EB6921` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_67F068BCD5E258C5` FOREIGN KEY (`posts_id`) REFERENCES `post` (`id`);

--
-- Constraints for table `excursion`
--
ALTER TABLE `excursion`
  ADD CONSTRAINT `FK_9B08E72F19EB6921` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK_5A8A6C8D19EB6921` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `post_like`
--
ALTER TABLE `post_like`
  ADD CONSTRAINT `FK_653627B819EB6921` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_653627B84B89032C` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

--
-- Constraints for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `FK_CE60640419EB6921` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `reservation_excursion`
--
ALTER TABLE `reservation_excursion`
  ADD CONSTRAINT `FK_814F86B019EB6921` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_814F86B069755C1D` FOREIGN KEY (`id_excursion_id`) REFERENCES `excursion` (`id`);

--
-- Constraints for table `reservation_restaurant`
--
ALTER TABLE `reservation_restaurant`
  ADD CONSTRAINT `FK_8B3FDB8B19EB6921` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_8B3FDB8BB1E7706E` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`);

--
-- Constraints for table `reservation_voyage`
--
ALTER TABLE `reservation_voyage`
  ADD CONSTRAINT `FK_776CC0CE19EB6921` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_776CC0CE68C9E5AF` FOREIGN KEY (`voyage_id`) REFERENCES `voyage` (`id`);

--
-- Constraints for table `voyage`
--
ALTER TABLE `voyage`
  ADD CONSTRAINT `FK_3F9D89554B80641D` FOREIGN KEY (`clien_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

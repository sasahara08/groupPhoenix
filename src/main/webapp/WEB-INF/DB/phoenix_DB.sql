CREATE DATABASE  IF NOT EXISTS `phoenix` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `phoenix`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: phoenix
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT '管理者ID（オートインクルメント）',
  `name` varchar(255) NOT NULL COMMENT '管理者の名前',
  `pass` int NOT NULL COMMENT 'パスワード',
  `admin_status_id` int NOT NULL COMMENT '外部キー(admin_status_id)',
  PRIMARY KEY (`admin_id`),
  KEY `admin_status_id_idx` (`admin_status_id`),
  CONSTRAINT `admin_status_id` FOREIGN KEY (`admin_status_id`) REFERENCES `admin_status` (`admin_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='管理者テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'不死鳥 太郎',1234,1),(2,'不死鳥 花子',4321,2);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_status`
--

DROP TABLE IF EXISTS `admin_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_status` (
  `admin_status_id` int NOT NULL,
  `admin_status` varchar(45) NOT NULL COMMENT '管理者ステータス(1.全権限(追加、削除可)、2.不可)',
  PRIMARY KEY (`admin_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='管理者ステータステーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_status`
--

LOCK TABLES `admin_status` WRITE;
/*!40000 ALTER TABLE `admin_status` DISABLE KEYS */;
INSERT INTO `admin_status` VALUES (1,'全権限追加、削除可)'),(2,'不可');
/*!40000 ALTER TABLE `admin_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `game_id` int NOT NULL AUTO_INCREMENT COMMENT '試合ID（オートインクリメント）',
  `game_date` date NOT NULL COMMENT '試合日',
  `start_time` time NOT NULL COMMENT '試合開始時間',
  `home_team_id` int NOT NULL COMMENT '外部キー(team_id)',
  `away_team_id` int NOT NULL COMMENT '外部キー(team_id)',
  `stadium_id` int NOT NULL COMMENT '外部キー(stadium_id)',
  `game_delete_at` date DEFAULT NULL,
  PRIMARY KEY (`game_id`),
  KEY `team_id_idx1` (`away_team_id`),
  KEY `studium_id_idx` (`stadium_id`),
  KEY `team_id_idx` (`home_team_id`),
  CONSTRAINT `away_team_id` FOREIGN KEY (`away_team_id`) REFERENCES `teams` (`team_id`),
  CONSTRAINT `home_team_id` FOREIGN KEY (`home_team_id`) REFERENCES `teams` (`team_id`),
  CONSTRAINT `studium_id` FOREIGN KEY (`stadium_id`) REFERENCES `games` (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb3 COMMENT='試合情報テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (1,'2025-03-01','18:00:00',1,2,1,'2025-03-01'),(2,'2025-03-05','18:00:00',1,3,1,'2025-03-05'),(3,'2025-03-10','18:00:00',1,4,1,'2025-03-10'),(4,'2025-03-15','14:00:00',1,2,1,NULL),(5,'2025-03-20','18:00:00',1,3,1,NULL),(6,'2025-03-25','14:00:00',1,4,1,NULL),(7,'2025-03-30','18:00:00',1,2,1,NULL),(8,'2025-04-01','18:00:00',1,3,1,NULL),(9,'2025-04-05','18:00:00',1,4,1,NULL),(10,'2025-04-10','18:00:00',1,2,1,NULL),(11,'2025-04-15','14:00:00',1,3,1,NULL),(12,'2025-04-20','18:00:00',1,4,1,NULL),(13,'2025-04-25','14:00:00',1,2,1,NULL),(14,'2025-04-30','18:00:00',1,3,1,NULL),(15,'2025-05-01','18:00:00',1,4,1,NULL),(16,'2025-05-06','18:00:00',1,2,1,NULL),(17,'2025-05-10','14:00:00',1,3,1,NULL),(18,'2025-05-15','18:00:00',1,4,1,NULL),(19,'2025-05-20','18:00:00',1,2,1,NULL),(20,'2025-05-25','14:00:00',1,3,1,NULL),(21,'2025-05-30','18:00:00',1,4,1,NULL),(22,'2025-06-01','18:00:00',1,2,1,NULL),(23,'2025-06-05','18:00:00',1,3,1,NULL),(24,'2025-06-10','18:00:00',1,4,1,NULL),(25,'2025-06-15','14:00:00',1,2,1,NULL),(26,'2025-06-20','18:00:00',1,3,1,NULL),(27,'2025-06-25','14:00:00',1,4,1,NULL),(28,'2025-06-30','18:00:00',1,2,1,NULL),(29,'2025-03-01','18:00:00',1,2,1,'2025-03-01'),(30,'2025-03-05','18:00:00',1,3,1,'2025-03-05'),(31,'2025-03-10','18:00:00',1,4,1,'2025-03-10'),(32,'2025-03-15','14:00:00',1,2,1,NULL),(33,'2025-03-20','18:00:00',1,3,1,NULL),(34,'2025-03-25','14:00:00',1,4,1,NULL),(35,'2025-03-30','18:00:00',1,2,1,NULL),(36,'2025-04-01','18:00:00',1,3,1,NULL),(37,'2025-04-05','18:00:00',1,4,1,NULL),(38,'2025-04-10','18:00:00',1,2,1,NULL),(39,'2025-04-15','14:00:00',1,3,1,NULL),(40,'2025-04-20','18:00:00',1,4,1,NULL),(41,'2025-04-25','14:00:00',1,2,1,NULL),(42,'2025-04-30','18:00:00',1,3,1,NULL),(43,'2025-05-01','18:00:00',1,4,1,NULL),(44,'2025-05-06','18:00:00',1,2,1,NULL),(45,'2025-05-10','14:00:00',1,3,1,NULL),(46,'2025-05-15','18:00:00',1,4,1,NULL),(47,'2025-05-20','18:00:00',1,2,1,NULL),(48,'2025-05-25','14:00:00',1,3,1,NULL),(49,'2025-05-30','18:00:00',1,4,1,NULL),(50,'2025-06-01','18:00:00',1,2,1,NULL),(51,'2025-06-05','18:00:00',1,3,1,NULL),(52,'2025-06-10','18:00:00',1,4,1,NULL),(53,'2025-06-15','14:00:00',1,2,1,NULL),(54,'2025-06-20','18:00:00',1,3,1,NULL),(55,'2025-06-25','14:00:00',1,4,1,NULL),(56,'2025-06-30','18:00:00',1,2,1,NULL);
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquiries`
--

DROP TABLE IF EXISTS `inquiries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inquiries` (
  `inquiry_id` int NOT NULL AUTO_INCREMENT COMMENT 'お問い合わせID（オートインクリメント）',
  `user_id` int NOT NULL COMMENT '外部キー(user_id)',
  `created_at` datetime NOT NULL COMMENT '問い合わせ日、時間',
  `inquiry_text` text NOT NULL COMMENT '問い合わせ内容',
  `response_text` text COMMENT '返信内容',
  `response_at` datetime DEFAULT NULL COMMENT '返信日時',
  PRIMARY KEY (`inquiry_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='お問い合わせテーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquiries`
--

LOCK TABLES `inquiries` WRITE;
/*!40000 ALTER TABLE `inquiries` DISABLE KEYS */;
/*!40000 ALTER TABLE `inquiries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `news_id` int NOT NULL AUTO_INCREMENT COMMENT 'NEWS_ID(オートインクルメント）',
  `title` varchar(255) NOT NULL COMMENT 'ニュースのタイトル',
  `main_text` varchar(255) NOT NULL COMMENT 'ニュース本文',
  `created_at` datetime NOT NULL COMMENT 'データ作成年月日（登録日）',
  `updated_at` datetime DEFAULT NULL COMMENT 'データ更新年月日',
  `start_at` datetime DEFAULT NULL,
  `ending_at` datetime DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='ニューステーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'phoenixニュースサイト開設','phoenixの公式ニュースサイトが開設されたよん。試合や選手の情報、販売情報など発信していきまーす⤴','2025-03-12 00:00:00',NULL,'2025-03-12 00:00:00',NULL),(2,'チケット販売開始','今シーズンのチケット販売が開始されました。\nチケットを購入して、試合を見に行こう！','2025-03-12 00:00:00',NULL,'2025-03-12 00:00:00',NULL);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_products`
--

DROP TABLE IF EXISTS `order_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_products` (
  `order_products_id` int NOT NULL AUTO_INCREMENT COMMENT '注文商品ID（オートインクルメント）',
  `order_id` int NOT NULL COMMENT '外部キー（注文テーブルの主キー）',
  `product_id` int NOT NULL COMMENT '外部キー（商品テーブルの主キー）',
  `num` int NOT NULL COMMENT '注文個数',
  `purchase_price` int NOT NULL COMMENT '価格（注文時）',
  PRIMARY KEY (`order_products_id`),
  KEY `product_id_idx` (`product_id`),
  KEY `order_id_idx` (`order_id`),
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='注文商品ID（オートインクルメント）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_products`
--

LOCK TABLES `order_products` WRITE;
/*!40000 ALTER TABLE `order_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderes`
--

DROP TABLE IF EXISTS `orderes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderes` (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '注文ID(オートインクルメント）',
  `user_id` int NOT NULL COMMENT '外部キー（会員テーブルの主キー）',
  `created_at` datetime NOT NULL COMMENT 'データ作成年月日（注文年月日）',
  `updated_at` datetime DEFAULT NULL COMMENT 'データ更新年月日',
  PRIMARY KEY (`order_id`),
  KEY `orderes_ibfk_1` (`user_id`),
  CONSTRAINT `orderes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='注文テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderes`
--

LOCK TABLES `orderes` WRITE;
/*!40000 ALTER TABLE `orderes` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '注文ID(オートインクルメント）',
  `user_id` int NOT NULL COMMENT '外部キー（会員テーブルの主キー）',
  `created_at` datetime NOT NULL COMMENT 'データ作成年月日（注文年月日）',
  `updated_at` datetime DEFAULT NULL COMMENT 'データ更新年月日',
  PRIMARY KEY (`order_id`),
  KEY `user_id_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='注文テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_statuses`
--

DROP TABLE IF EXISTS `player_statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player_statuses` (
  `player_status_id` int NOT NULL DEFAULT '1' COMMENT 'ステータスID',
  `player_status` varchar(64) NOT NULL COMMENT '在籍状況（1:在籍、2:退団）',
  PRIMARY KEY (`player_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='選手ステータステーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_statuses`
--

LOCK TABLES `player_statuses` WRITE;
/*!40000 ALTER TABLE `player_statuses` DISABLE KEYS */;
INSERT INTO `player_statuses` VALUES (1,'在籍'),(2,'退団');
/*!40000 ALTER TABLE `player_statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `players` (
  `player_id` int NOT NULL AUTO_INCREMENT COMMENT '選手ID(オートインクルメント）',
  `name` varchar(64) NOT NULL COMMENT '選手名',
  `kana` varchar(64) NOT NULL COMMENT '選手名（ふりがな）',
  `image` varchar(255) DEFAULT NULL COMMENT '選手画像(URL)',
  `birthday` date NOT NULL COMMENT '生年月日',
  `height` int NOT NULL COMMENT '身長',
  `weight` int NOT NULL COMMENT '体重',
  `birth_place` varchar(64) NOT NULL COMMENT '出身地',
  `position` varchar(64) NOT NULL COMMENT 'ポジション',
  `comment` varchar(255) NOT NULL COMMENT '選手コメント',
  `created_at` datetime NOT NULL COMMENT 'データ作成年月日（登録日）',
  `updated_at` datetime DEFAULT NULL COMMENT 'データ更新年月日',
  `joined_at` date NOT NULL COMMENT '入団日',
  `ending_at` date DEFAULT NULL,
  `player_status_id` int NOT NULL COMMENT '在籍状況,外部キー（選手ステータステーブルの主キー）',
  PRIMARY KEY (`player_id`),
  KEY `player_status_id_idx` (`player_status_id`),
  CONSTRAINT `player_status_id` FOREIGN KEY (`player_status_id`) REFERENCES `player_statuses` (`player_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COMMENT='選手テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,'田中 一郎','たなか いちろう',NULL,'1990-04-12',180,75,'東京都','投手','勝利は努力の結果。','2025-03-12 00:00:00','2025-03-12 11:32:00','2009-04-01',NULL,1),(2,'山田 太郎','やまだ たろう',NULL,'1992-06-25',185,80,'大阪府','捕手','笑顔で全力投球！','2025-03-12 00:00:00',NULL,'2015-04-01',NULL,1),(3,'鈴木 勇','すずき いさみ',NULL,'1988-09-10',178,73,'福岡県','内野手','打倒相手チーム！','2025-03-12 00:00:00','2025-03-12 12:21:00','2011-04-01',NULL,1),(4,'佐藤 健','さとう けん',NULL,'1995-11-30',175,72,'北海道','内野手','一歩一歩前進！','2025-03-12 00:00:00','2025-03-12 12:21:00','2014-04-01',NULL,1),(5,'高橋 誠','たかはし まこと',NULL,'1991-03-08',180,78,'神奈川県','内野手','チームのために！','2025-03-12 00:00:00',NULL,'2008-04-01',NULL,1),(6,'渡辺 翔','わたなべ しょう',NULL,'1989-12-17',182,85,'愛知県','内野手','勝利の女神！','2025-03-12 00:00:00',NULL,'2012-04-01',NULL,1),(7,'小林 勇','こばやし いさみ',NULL,'1993-05-20',178,68,'京都府','内野手','全力で走れ！','2025-03-12 00:00:00',NULL,'2012-04-01',NULL,1),(8,'中村 亮','なかむら りょう',NULL,'1996-01-15',170,65,'広島県','外野手','皆で笑おう！','2025-03-12 00:00:00',NULL,'2014-04-01',NULL,1),(9,'加藤 健','かとう けん',NULL,'1987-07-04',180,75,'埼玉県','外野手','打って走って守る！','2025-03-12 00:00:00',NULL,'2010-04-01',NULL,1),(10,'伊藤 拓','いとう たく',NULL,'1994-02-23',158,62,'宮城県','投手','チャンスを掴め！','2025-03-12 00:00:00',NULL,'2012-04-01',NULL,1),(11,'石川 ジョン','いしかわ じょん',NULL,'1990-10-05',192,90,'カリフォルニア州','内野手','ホームランを狙え！','2025-03-12 00:00:00',NULL,'2016-04-01',NULL,1),(12,'清水 クリス','しみず くりす',NULL,'1997-08-14',185,88,'テキサス州','外野手','スピード勝負！','2025-03-12 00:00:00',NULL,'2016-03-01',NULL,1),(13,'松本 デイビッド','まつもと でいびっど',NULL,'1992-11-02',175,70,'ニューヨーク州','内野手','守りで勝て！','2025-03-12 00:00:00',NULL,'2017-04-01',NULL,1),(14,'石井 圭一','いしい けいいち',NULL,'1965-05-05',170,70,'東京都','監督','チーム全員で勝つ！','2025-03-12 00:00:00',NULL,'2018-04-01',NULL,1),(15,'上田 剛','うえだ ごう',NULL,'1970-11-11',175,75,'神奈川県','投手コーチ','完璧な投球を目指せ！','2025-03-12 00:00:00',NULL,'2019-04-01',NULL,1),(16,'マイク・スミス','まいく すみす',NULL,'1980-06-20',180,85,'オハイオ州','打撃コーチ','一撃必殺のバッティング！','2025-03-12 00:00:00',NULL,'2019-04-01',NULL,1);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `product_category_id` int NOT NULL AUTO_INCREMENT COMMENT '商品カテゴリID(オートインクルメント）',
  `product_category` varchar(45) NOT NULL COMMENT '商品カテゴリ名',
  PRIMARY KEY (`product_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='商品カテゴリテーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,'グッズ'),(2,'フード');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT COMMENT '商品ID(オートインクルメント）',
  `product_category_id` int NOT NULL COMMENT '商品カテゴリID（1:グッズ、2:フード）',
  `name` varchar(64) NOT NULL COMMENT '商品名',
  `price` int NOT NULL COMMENT '商品価格',
  `image` varchar(255) DEFAULT NULL COMMENT '商品画像',
  `stock` int NOT NULL COMMENT '在庫数',
  PRIMARY KEY (`product_id`),
  KEY `product_category_id_idx` (`product_category_id`),
  CONSTRAINT `product_category_id` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`product_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='商品テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seats` (
  `seat_id` int NOT NULL AUTO_INCREMENT COMMENT '座席ID(オートインクルメント）',
  `seat_type` varchar(64) NOT NULL COMMENT '座席種類',
  `seat_price` int NOT NULL COMMENT '座席料金',
  PRIMARY KEY (`seat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='座席テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats`
--

LOCK TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats` VALUES (1,'外野応援席',3000),(2,'内野指定席',5000),(3,'バックネット側指定席',8000);
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stadiums`
--

DROP TABLE IF EXISTS `stadiums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stadiums` (
  `stadium_id` int NOT NULL COMMENT 'スタジアムID（オートインクリメント）',
  `stadium_name` varchar(255) NOT NULL COMMENT 'チーム名',
  PRIMARY KEY (`stadium_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='スタジアムテーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stadiums`
--

LOCK TABLES `stadiums` WRITE;
/*!40000 ALTER TABLE `stadiums` DISABLE KEYS */;
INSERT INTO `stadiums` VALUES (1,'長浜PoyPoyドーム');
/*!40000 ALTER TABLE `stadiums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teams` (
  `team_id` int NOT NULL AUTO_INCREMENT COMMENT 'チームID（オートインクリメント）',
  `team_name` varchar(255) NOT NULL COMMENT 'チーム名',
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='チーム情報テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'フェニックス'),(2,'フラワーズ'),(3,'ビーズ'),(4,'ドルフィンズ');
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_order_detail`
--

DROP TABLE IF EXISTS `ticket_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_order_detail` (
  `ticket_order_detail_id` int NOT NULL AUTO_INCREMENT,
  `ticket_order_id` int NOT NULL COMMENT '外部キー（チケット注文テーブルの主キー）',
  `tikcet_id` int NOT NULL COMMENT '外部キー（チケットテーブルの主キー）',
  `quantity` int NOT NULL COMMENT '注文枚数',
  PRIMARY KEY (`ticket_order_detail_id`),
  KEY `ticket_order_id_idx` (`ticket_order_id`),
  KEY `ticket_id_idx` (`tikcet_id`),
  CONSTRAINT `ticket_id` FOREIGN KEY (`tikcet_id`) REFERENCES `tickets` (`tikcet_id`),
  CONSTRAINT `ticket_order_id` FOREIGN KEY (`ticket_order_id`) REFERENCES `ticket_orders` (`ticket_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='チケット注文詳細テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_order_detail`
--

LOCK TABLES `ticket_order_detail` WRITE;
/*!40000 ALTER TABLE `ticket_order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_orders`
--

DROP TABLE IF EXISTS `ticket_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_orders` (
  `ticket_order_id` int NOT NULL AUTO_INCREMENT COMMENT 'チケット注文ID(オートインクルメント）',
  `user_id` int NOT NULL COMMENT '外部キー(会員テーブルの主キー)',
  `created_at` datetime NOT NULL COMMENT 'データ作成年月日（注文年月日）',
  PRIMARY KEY (`ticket_order_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='チケット注文テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_orders`
--

LOCK TABLES `ticket_orders` WRITE;
/*!40000 ALTER TABLE `ticket_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_statuses`
--

DROP TABLE IF EXISTS `ticket_statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_statuses` (
  `ticket_status_id` int NOT NULL DEFAULT '1' COMMENT 'チケットステータスID(オートインクルメント）',
  `ticket_status` varchar(10) NOT NULL COMMENT '販売状況（1:未購入、2:購入済、3:リセール出品）',
  PRIMARY KEY (`ticket_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='チケットステータステーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_statuses`
--

LOCK TABLES `ticket_statuses` WRITE;
/*!40000 ALTER TABLE `ticket_statuses` DISABLE KEYS */;
INSERT INTO `ticket_statuses` VALUES (1,'未購入'),(2,'購入済'),(3,'リセール販売');
/*!40000 ALTER TABLE `ticket_statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `tikcet_id` int NOT NULL AUTO_INCREMENT COMMENT 'チケットID（オートインクリメント）',
  `game_id` int NOT NULL COMMENT '外部キー(game_id)',
  `seat_id` int NOT NULL COMMENT '外部キー(seat_id)',
  `seat_number` int NOT NULL COMMENT '座席番号',
  `ticket_status_id` int NOT NULL COMMENT '外部キー(ticket_status_id)',
  PRIMARY KEY (`tikcet_id`),
  KEY `game_id_idx` (`game_id`),
  KEY `seat_id_idx` (`seat_id`),
  KEY `ticket_status_id_idx` (`ticket_status_id`),
  CONSTRAINT `game_id` FOREIGN KEY (`game_id`) REFERENCES `games` (`game_id`),
  CONSTRAINT `seat_id` FOREIGN KEY (`seat_id`) REFERENCES `seats` (`seat_id`),
  CONSTRAINT `ticket_status_id` FOREIGN KEY (`ticket_status_id`) REFERENCES `ticket_statuses` (`ticket_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='チケットテーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '会員ID（オートインクリメント)',
  `name` varchar(255) NOT NULL COMMENT '名前',
  `kana` varchar(255) NOT NULL COMMENT '名前(ふりがな)',
  `birthday` date NOT NULL COMMENT '生年月日',
  `post_code` varchar(7) NOT NULL COMMENT '郵便番号(ハイフンなし７桁)',
  `phone` varchar(20) NOT NULL COMMENT '電話番号',
  `email` varchar(255) NOT NULL,
  `gender` enum('男性','女性','その他') NOT NULL COMMENT '性別(ENUM(1.男性, 2.女性, 3.その他）)',
  `pass` varchar(255) NOT NULL COMMENT 'パスワード',
  `created_at` date NOT NULL COMMENT 'アカウント作成日(登録日)',
  `last_login_at` datetime NOT NULL COMMENT 'カードの有効期限',
  `credit_card_number` varchar(45) DEFAULT NULL COMMENT 'クレジットカード番号',
  `credit_card_expiry_date` varchar(5) DEFAULT NULL,
  `credit_card_security_code` varchar(3) DEFAULT NULL COMMENT 'カードのセキュリティコード',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='会員テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'斎藤 飛鳥','さいとう あすか','1998-08-01','8100072','0924011835','asuka-saitou@@rikarento.com','女性','1234','2025-03-12','2025-03-12 15:10:00',NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-13 10:23:31

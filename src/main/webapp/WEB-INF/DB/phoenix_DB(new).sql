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
INSERT INTO `games` VALUES (1,'2025-03-01','18:00:00',1,2,1,'2025-03-01'),(2,'2025-03-05','18:00:00',1,3,1,'2025-03-05'),(3,'2025-03-10','18:00:00',1,4,1,'2025-03-10'),(4,'2025-03-15','14:00:00',1,2,1,NULL),(5,'2025-03-20','18:00:00',1,3,1,NULL),(6,'2025-03-25','14:00:00',1,4,1,NULL),(7,'2025-03-30','18:00:00',1,2,1,NULL),(8,'2025-04-01','18:00:00',1,3,1,NULL),(9,'2025-04-05','18:00:00',1,4,1,NULL),(10,'2025-04-10','18:00:00',1,2,1,NULL),(11,'2025-04-15','14:00:00',1,3,1,NULL),(12,'2025-04-20','18:00:00',1,4,1,NULL),(13,'2025-04-25','14:00:00',1,2,1,NULL),(14,'2025-04-30','18:00:00',1,3,1,NULL),(15,'2025-05-01','18:00:00',1,4,1,NULL),(16,'2025-05-06','18:00:00',1,2,1,NULL),(17,'2025-05-10','14:00:00',1,3,1,NULL),(18,'2025-05-15','18:00:00',1,4,1,NULL),(19,'2025-05-20','18:00:00',1,2,1,NULL),(20,'2025-05-25','14:00:00',1,3,1,NULL),(21,'2025-05-30','18:00:00',1,4,1,NULL),(22,'2025-06-01','18:00:00',1,2,1,NULL),(23,'2025-06-05','18:00:00',1,3,1,NULL),(24,'2025-06-10','18:00:00',1,4,1,NULL),(25,'2025-06-15','14:00:00',1,2,1,NULL),(26,'2025-06-20','18:00:00',1,3,1,NULL),(27,'2025-06-25','14:00:00',1,4,1,NULL),(28,'2025-06-30','18:00:00',1,2,1,NULL);
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
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
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
  KEY `player_images_idx` (`image`),
  CONSTRAINT `player_status_id` FOREIGN KEY (`player_status_id`) REFERENCES `player_statuses` (`player_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COMMENT='選手テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,'田中 一郎','たなか いちろう','1_tanaka.png','1990-04-12',180,75,'東京都','投手','勝利は努力の結果。','2025-03-12 00:00:00','2025-03-12 11:32:00','2009-04-01',NULL,1),(2,'山田 太郎','やまだ たろう','2_yamada.png','1992-06-25',185,80,'大阪府','捕手','笑顔で全力投球！','2025-03-12 00:00:00',NULL,'2015-04-01',NULL,1),(3,'鈴木 勇','すずき いさみ','3_suzuki.png','1988-09-10',178,73,'福岡県','内野手','打倒相手チーム！','2025-03-12 00:00:00','2025-03-12 12:21:00','2011-04-01',NULL,1),(4,'佐藤 健','さとう けん','4_satou.png','1995-11-30',175,72,'北海道','内野手','一歩一歩前進！','2025-03-12 00:00:00','2025-03-12 12:21:00','2014-04-01',NULL,1),(5,'高橋 誠','たかはし まこと','5_takahashi.png','1991-03-08',180,78,'神奈川県','内野手','チームのために！','2025-03-12 00:00:00',NULL,'2008-04-01',NULL,1),(6,'渡辺 翔','わたなべ しょう','6_watanabe.png','1989-12-17',182,85,'愛知県','内野手','勝利の女神！','2025-03-12 00:00:00',NULL,'2012-04-01',NULL,1),(7,'小林 勇','こばやし いさみ','7_kobayashi.png','1993-05-20',178,68,'京都府','内野手','全力で走れ！','2025-03-12 00:00:00',NULL,'2012-04-01',NULL,1),(8,'中村 亮','なかむら りょう','8_nakamura.png','1996-01-15',170,65,'広島県','外野手','皆で笑おう！','2025-03-12 00:00:00',NULL,'2014-04-01',NULL,1),(9,'加藤 健','かとう けん','9_kato.png','1987-07-04',180,75,'埼玉県','外野手','打って走って守る！','2025-03-12 00:00:00',NULL,'2010-04-01',NULL,1),(10,'伊藤 拓','いとう たく','10_ito.png','1994-02-23',158,62,'宮城県','投手','チャンスを掴め！','2025-03-12 00:00:00',NULL,'2012-04-01',NULL,1),(11,'石川 ジョン','いしかわ じょん','11_ishikawa.png','1990-10-05',192,90,'カリフォルニア州','内野手','ホームランを狙え！','2025-03-12 00:00:00',NULL,'2016-04-01',NULL,1),(12,'清水 クリス','しみず くりす','12_shimizu.png','1997-08-14',185,88,'テキサス州','外野手','スピード勝負！','2025-03-12 00:00:00',NULL,'2016-03-01',NULL,1),(13,'松本 デイビッド','まつもと でいびっど','13_matsumoto.png','1992-11-02',175,70,'ニューヨーク州','内野手','守りで勝て！','2025-03-12 00:00:00',NULL,'2017-04-01',NULL,1),(14,'石井 圭一','いしい けいいち','14_ishii.png','1965-05-05',170,70,'東京都','監督','チーム全員で勝つ！','2025-03-12 00:00:00',NULL,'2018-04-01',NULL,1),(15,'上田 剛','うえだ ごう','15_ueda.png','1970-11-11',175,75,'神奈川県','投手コーチ','完璧な投球を目指せ！','2025-03-12 00:00:00',NULL,'2019-04-01',NULL,1),(16,'マイク・スミス','まいく すみす','16_mike.png','1980-06-20',180,85,'オハイオ州','打撃コーチ','一撃必殺のバッティング！','2025-03-12 00:00:00',NULL,'2019-04-01',NULL,1);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
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
  `ticket_id` int NOT NULL COMMENT '外部キー（チケットテーブルの主キー）',
  `user_id` int NOT NULL COMMENT '外部キー(会員テーブルの主キー)',
  `created_at` date NOT NULL COMMENT 'データ作成年月日（注文年月日）',
  PRIMARY KEY (`ticket_order_detail_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `ticket_id` (`ticket_id`),
  CONSTRAINT `ticket_id` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`ticket_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='チケット注文詳細テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_order_detail`
--

LOCK TABLES `ticket_order_detail` WRITE;
/*!40000 ALTER TABLE `ticket_order_detail` DISABLE KEYS */;
INSERT INTO `ticket_order_detail` VALUES (1,1,1,'2025-03-24'),(2,1,2,'2025-03-25');
/*!40000 ALTER TABLE `ticket_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_statuses`
--

DROP TABLE IF EXISTS `ticket_statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_statuses` (
  `ticket_status_id` int NOT NULL DEFAULT '1' COMMENT 'チケットステータスID(オートインクルメント）',
  `ticket_status` varchar(10) NOT NULL COMMENT '販売状況（1:未購入、2:購入済、3:リセール出品、4:リセール購入済）',
  PRIMARY KEY (`ticket_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='チケットステータステーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_statuses`
--

LOCK TABLES `ticket_statuses` WRITE;
/*!40000 ALTER TABLE `ticket_statuses` DISABLE KEYS */;
INSERT INTO `ticket_statuses` VALUES (1,'未購入'),(2,'購入済'),(3,'リセール販売'),(4,'リセール購入済');
/*!40000 ALTER TABLE `ticket_statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `ticket_id` int NOT NULL AUTO_INCREMENT COMMENT 'チケットID（オートインクリメント）',
  `game_id` int NOT NULL COMMENT '外部キー(game_id)',
  `seat_id` int NOT NULL COMMENT '外部キー(seat_id)',
  `seat_number` varchar(255) NOT NULL COMMENT '座席番号',
  `ticket_status_id` int NOT NULL COMMENT '外部キー(ticket_status_id)',
  PRIMARY KEY (`ticket_id`),
  KEY `game_id_idx` (`game_id`),
  KEY `seat_id_idx` (`seat_id`),
  KEY `ticket_status_id_idx` (`ticket_status_id`),
  CONSTRAINT `game_id` FOREIGN KEY (`game_id`) REFERENCES `games` (`game_id`),
  CONSTRAINT `ticket_status_id` FOREIGN KEY (`ticket_status_id`) REFERENCES `ticket_statuses` (`ticket_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1121 DEFAULT CHARSET=utf8mb3 COMMENT='チケットテーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,1,1,'A001',3),(2,1,1,'A002',1),(3,1,1,'A003',4),(4,1,1,'A004',2),(5,1,1,'A005',3),(6,1,2,'B001',2),(7,1,2,'B002',3),(8,1,2,'B003',1),(9,1,2,'B004',4),(10,1,2,'B005',2),(11,1,3,'C001',4),(12,1,3,'C002',2),(13,1,3,'C003',3),(14,1,3,'C004',1),(15,1,3,'C005',4),(16,1,4,'D001',1),(17,1,4,'D002',4),(18,1,4,'D003',2),(19,1,4,'D004',3),(20,1,4,'D005',1),(21,2,1,'A001',1),(22,2,1,'A002',4),(23,2,1,'A003',2),(24,2,1,'A004',3),(25,2,1,'A005',1),(26,2,2,'B001',3),(27,2,2,'B002',1),(28,2,2,'B003',4),(29,2,2,'B004',2),(30,2,2,'B005',3),(31,2,3,'C001',2),(32,2,3,'C002',3),(33,2,3,'C003',1),(34,2,3,'C004',4),(35,2,3,'C005',2),(36,2,4,'D001',4),(37,2,4,'D002',2),(38,2,4,'D003',3),(39,2,4,'D004',1),(40,2,4,'D005',4),(41,3,1,'A001',2),(42,3,1,'A002',3),(43,3,1,'A003',1),(44,3,1,'A004',4),(45,3,1,'A005',2),(46,3,2,'B001',4),(47,3,2,'B002',2),(48,3,2,'B003',3),(49,3,2,'B004',1),(50,3,2,'B005',4),(51,3,3,'C001',1),(52,3,3,'C002',4),(53,3,3,'C003',2),(54,3,3,'C004',3),(55,3,3,'C005',1),(56,3,4,'D001',3),(57,3,4,'D002',1),(58,3,4,'D003',4),(59,3,4,'D004',2),(60,3,4,'D005',3),(61,4,1,'A001',4),(62,4,1,'A002',2),(63,4,1,'A003',3),(64,4,1,'A004',1),(65,4,1,'A005',4),(66,4,2,'B001',1),(67,4,2,'B002',4),(68,4,2,'B003',2),(69,4,2,'B004',3),(70,4,2,'B005',1),(71,4,3,'C001',3),(72,4,3,'C002',1),(73,4,3,'C003',4),(74,4,3,'C004',2),(75,4,3,'C005',3),(76,4,4,'D001',2),(77,4,4,'D002',3),(78,4,4,'D003',1),(79,4,4,'D004',4),(80,4,4,'D005',2),(81,5,1,'A001',3),(82,5,1,'A002',1),(83,5,1,'A003',4),(84,5,1,'A004',2),(85,5,1,'A005',3),(86,5,2,'B001',2),(87,5,2,'B002',3),(88,5,2,'B003',1),(89,5,2,'B004',4),(90,5,2,'B005',2),(91,5,3,'C001',4),(92,5,3,'C002',2),(93,5,3,'C003',3),(94,5,3,'C004',1),(95,5,3,'C005',4),(96,5,4,'D001',1),(97,5,4,'D002',4),(98,5,4,'D003',2),(99,5,4,'D004',3),(100,5,4,'D005',1),(101,6,1,'A001',1),(102,6,1,'A002',4),(103,6,1,'A003',2),(104,6,1,'A004',3),(105,6,1,'A005',1),(106,6,2,'B001',3),(107,6,2,'B002',1),(108,6,2,'B003',4),(109,6,2,'B004',2),(110,6,2,'B005',3),(111,6,3,'C001',2),(112,6,3,'C002',3),(113,6,3,'C003',1),(114,6,3,'C004',4),(115,6,3,'C005',2),(116,6,4,'D001',4),(117,6,4,'D002',2),(118,6,4,'D003',3),(119,6,4,'D004',1),(120,6,4,'D005',4),(121,7,1,'A001',3),(122,7,1,'A002',1),(123,7,1,'A003',4),(124,7,1,'A004',2),(125,7,1,'A005',3),(126,7,2,'B001',2),(127,7,2,'B002',3),(128,7,2,'B003',1),(129,7,2,'B004',4),(130,7,2,'B005',2),(131,7,3,'C001',4),(132,7,3,'C002',2),(133,7,3,'C003',3),(134,7,3,'C004',1),(135,7,3,'C005',4),(136,7,4,'D001',1),(137,7,4,'D002',4),(138,7,4,'D003',2),(139,7,4,'D004',3),(140,7,4,'D005',1),(141,8,1,'A001',1),(142,8,1,'A002',4),(143,8,1,'A003',2),(144,8,1,'A004',3),(145,8,1,'A005',1),(146,8,2,'B001',3),(147,8,2,'B002',1),(148,8,2,'B003',4),(149,8,2,'B004',2),(150,8,2,'B005',3),(151,8,3,'C001',2),(152,8,3,'C002',3),(153,8,3,'C003',1),(154,8,3,'C004',4),(155,8,3,'C005',2),(156,8,4,'D001',4),(157,8,4,'D002',2),(158,8,4,'D003',3),(159,8,4,'D004',1),(160,8,4,'D005',4),(161,9,1,'A001',2),(162,9,1,'A002',3),(163,9,1,'A003',1),(164,9,1,'A004',4),(165,9,1,'A005',2),(166,9,2,'B001',4),(167,9,2,'B002',2),(168,9,2,'B003',3),(169,9,2,'B004',1),(170,9,2,'B005',4),(171,9,3,'C001',1),(172,9,3,'C002',4),(173,9,3,'C003',2),(174,9,3,'C004',3),(175,9,3,'C005',1),(176,9,4,'D001',3),(177,9,4,'D002',1),(178,9,4,'D003',4),(179,9,4,'D004',2),(180,9,4,'D005',3),(181,10,1,'A001',4),(182,10,1,'A002',2),(183,10,1,'A003',3),(184,10,1,'A004',1),(185,10,1,'A005',4),(186,10,2,'B001',1),(187,10,2,'B002',4),(188,10,2,'B003',2),(189,10,2,'B004',3),(190,10,2,'B005',1),(191,10,3,'C001',3),(192,10,3,'C002',1),(193,10,3,'C003',4),(194,10,3,'C004',2),(195,10,3,'C005',3),(196,10,4,'D001',2),(197,10,4,'D002',3),(198,10,4,'D003',1),(199,10,4,'D004',4),(200,10,4,'D005',2),(201,11,1,'A001',3),(202,11,1,'A002',1),(203,11,1,'A003',4),(204,11,1,'A004',2),(205,11,1,'A005',3),(206,11,2,'B001',2),(207,11,2,'B002',3),(208,11,2,'B003',1),(209,11,2,'B004',4),(210,11,2,'B005',2),(211,11,3,'C001',4),(212,11,3,'C002',2),(213,11,3,'C003',3),(214,11,3,'C004',1),(215,11,3,'C005',4),(216,11,4,'D001',1),(217,11,4,'D002',4),(218,11,4,'D003',2),(219,11,4,'D004',3),(220,11,4,'D005',1),(221,12,1,'A001',1),(222,12,1,'A002',4),(223,12,1,'A003',2),(224,12,1,'A004',3),(225,12,1,'A005',1),(226,12,2,'B001',3),(227,12,2,'B002',1),(228,12,2,'B003',4),(229,12,2,'B004',2),(230,12,2,'B005',3),(231,12,3,'C001',2),(232,12,3,'C002',3),(233,12,3,'C003',1),(234,12,3,'C004',4),(235,12,3,'C005',2),(236,12,4,'D001',4),(237,12,4,'D002',2),(238,12,4,'D003',3),(239,12,4,'D004',1),(240,12,4,'D005',4),(241,13,1,'A001',2),(242,13,1,'A002',3),(243,13,1,'A003',1),(244,13,1,'A004',4),(245,13,1,'A005',2),(246,13,2,'B001',4),(247,13,2,'B002',2),(248,13,2,'B003',3),(249,13,2,'B004',1),(250,13,2,'B005',4),(251,13,3,'C001',1),(252,13,3,'C002',4),(253,13,3,'C003',2),(254,13,3,'C004',3),(255,13,3,'C005',1),(256,13,4,'D001',3),(257,13,4,'D002',1),(258,13,4,'D003',4),(259,13,4,'D004',2),(260,13,4,'D005',3),(261,14,1,'A001',4),(262,14,1,'A002',2),(263,14,1,'A003',3),(264,14,1,'A004',1),(265,14,1,'A005',4),(266,14,2,'B001',1),(267,14,2,'B002',4),(268,14,2,'B003',2),(269,14,2,'B004',3),(270,14,2,'B005',1),(271,14,3,'C001',3),(272,14,3,'C002',1),(273,14,3,'C003',4),(274,14,3,'C004',2),(275,14,3,'C005',3),(276,14,4,'D001',2),(277,14,4,'D002',3),(278,14,4,'D003',1),(279,14,4,'D004',4),(280,14,4,'D005',2),(281,15,1,'A001',3),(282,15,1,'A002',1),(283,15,1,'A003',4),(284,15,1,'A004',2),(285,15,1,'A005',3),(286,15,2,'B001',2),(287,15,2,'B002',3),(288,15,2,'B003',1),(289,15,2,'B004',4),(290,15,2,'B005',2),(291,15,3,'C001',4),(292,15,3,'C002',2),(293,15,3,'C003',3),(294,15,3,'C004',1),(295,15,3,'C005',4),(296,15,4,'D001',1),(297,15,4,'D002',4),(298,15,4,'D003',2),(299,15,4,'D004',3),(300,15,4,'D005',1),(301,16,1,'A001',1),(302,16,1,'A002',4),(303,16,1,'A003',2),(304,16,1,'A004',3),(305,16,1,'A005',1),(306,16,2,'B001',3),(307,16,2,'B002',1),(308,16,2,'B003',4),(309,16,2,'B004',2),(310,16,2,'B005',3),(311,16,3,'C001',2),(312,16,3,'C002',3),(313,16,3,'C003',1),(314,16,3,'C004',4),(315,16,3,'C005',2),(316,16,4,'D001',4),(317,16,4,'D002',2),(318,16,4,'D003',3),(319,16,4,'D004',1),(320,16,4,'D005',4),(321,17,1,'A001',2),(322,17,1,'A002',3),(323,17,1,'A003',1),(324,17,1,'A004',4),(325,17,1,'A005',2),(326,17,2,'B001',4),(327,17,2,'B002',2),(328,17,2,'B003',3),(329,17,2,'B004',1),(330,17,2,'B005',4),(331,17,3,'C001',1),(332,17,3,'C002',4),(333,17,3,'C003',2),(334,17,3,'C004',3),(335,17,3,'C005',1),(336,17,4,'D001',3),(337,17,4,'D002',1),(338,17,4,'D003',4),(339,17,4,'D004',2),(340,17,4,'D005',3),(341,18,1,'A001',4),(342,18,1,'A002',2),(343,18,1,'A003',3),(344,18,1,'A004',1),(345,18,1,'A005',4),(346,18,2,'B001',1),(347,18,2,'B002',4),(348,18,2,'B003',2),(349,18,2,'B004',3),(350,18,2,'B005',1),(351,18,3,'C001',3),(352,18,3,'C002',1),(353,18,3,'C003',4),(354,18,3,'C004',2),(355,18,3,'C005',3),(356,18,4,'D001',2),(357,18,4,'D002',3),(358,18,4,'D003',1),(359,18,4,'D004',4),(360,18,4,'D005',2),(361,19,1,'A001',3),(362,19,1,'A002',1),(363,19,1,'A003',4),(364,19,1,'A004',2),(365,19,1,'A005',3),(366,19,2,'B001',2),(367,19,2,'B002',3),(368,19,2,'B003',1),(369,19,2,'B004',4),(370,19,2,'B005',2),(371,19,3,'C001',4),(372,19,3,'C002',2),(373,19,3,'C003',3),(374,19,3,'C004',1),(375,19,3,'C005',4),(376,19,4,'D001',1),(377,19,4,'D002',4),(378,19,4,'D003',2),(379,19,4,'D004',3),(380,19,4,'D005',1),(381,20,1,'A001',1),(382,20,1,'A002',4),(383,20,1,'A003',2),(384,20,1,'A004',3),(385,20,1,'A005',1),(386,20,2,'B001',3),(387,20,2,'B002',1),(388,20,2,'B003',4),(389,20,2,'B004',2),(390,20,2,'B005',3),(391,20,3,'C001',2),(392,20,3,'C002',3),(393,20,3,'C003',1),(394,20,3,'C004',4),(395,20,3,'C005',2),(396,20,4,'D001',4),(397,20,4,'D002',2),(398,20,4,'D003',3),(399,20,4,'D004',1),(400,20,4,'D005',4),(401,21,1,'A001',2),(402,21,1,'A002',3),(403,21,1,'A003',1),(404,21,1,'A004',4),(405,21,1,'A005',2),(406,21,2,'B001',4),(407,21,2,'B002',2),(408,21,2,'B003',3),(409,21,2,'B004',1),(410,21,2,'B005',4),(411,21,3,'C001',1),(412,21,3,'C002',4),(413,21,3,'C003',2),(414,21,3,'C004',3),(415,21,3,'C005',1),(416,21,4,'D001',3),(417,21,4,'D002',1),(418,21,4,'D003',4),(419,21,4,'D004',2),(420,21,4,'D005',3),(421,22,1,'A001',4),(422,22,1,'A002',2),(423,22,1,'A003',3),(424,22,1,'A004',1),(425,22,1,'A005',4),(426,22,2,'B001',1),(427,22,2,'B002',4),(428,22,2,'B003',2),(429,22,2,'B004',3),(430,22,2,'B005',1),(431,22,3,'C001',3),(432,22,3,'C002',1),(433,22,3,'C003',4),(434,22,3,'C004',2),(435,22,3,'C005',3),(436,22,4,'D001',2),(437,22,4,'D002',3),(438,22,4,'D003',1),(439,22,4,'D004',4),(440,22,4,'D005',2),(441,23,1,'A001',3),(442,23,1,'A002',1),(443,23,1,'A003',4),(444,23,1,'A004',2),(445,23,1,'A005',3),(446,23,2,'B001',2),(447,23,2,'B002',3),(448,23,2,'B003',1),(449,23,2,'B004',4),(450,23,2,'B005',2),(451,23,3,'C001',4),(452,23,3,'C002',2),(453,23,3,'C003',3),(454,23,3,'C004',1),(455,23,3,'C005',4),(456,23,4,'D001',1),(457,23,4,'D002',4),(458,23,4,'D003',2),(459,23,4,'D004',3),(460,23,4,'D005',1),(461,24,1,'A001',1),(462,24,1,'A002',4),(463,24,1,'A003',2),(464,24,1,'A004',3),(465,24,1,'A005',1),(466,24,2,'B001',3),(467,24,2,'B002',1),(468,24,2,'B003',4),(469,24,2,'B004',2),(470,24,2,'B005',3),(471,24,3,'C001',2),(472,24,3,'C002',3),(473,24,3,'C003',1),(474,24,3,'C004',4),(475,24,3,'C005',2),(476,24,4,'D001',4),(477,24,4,'D002',2),(478,24,4,'D003',3),(479,24,4,'D004',1),(480,24,4,'D005',4),(481,25,1,'A001',2),(482,25,1,'A002',3),(483,25,1,'A003',1),(484,25,1,'A004',4),(485,25,1,'A005',2),(486,25,2,'B001',4),(487,25,2,'B002',2),(488,25,2,'B003',3),(489,25,2,'B004',1),(490,25,2,'B005',4),(491,25,3,'C001',1),(492,25,3,'C002',4),(493,25,3,'C003',2),(494,25,3,'C004',3),(495,25,3,'C005',1),(496,25,4,'D001',3),(497,25,4,'D002',1),(498,25,4,'D003',4),(499,25,4,'D004',2),(500,25,4,'D005',3),(501,26,1,'A001',4),(502,26,1,'A002',2),(503,26,1,'A003',3),(504,26,1,'A004',1),(505,26,1,'A005',4),(506,26,2,'B001',1),(507,26,2,'B002',4),(508,26,2,'B003',2),(509,26,2,'B004',3),(510,26,2,'B005',1),(511,26,3,'C001',3),(512,26,3,'C002',1),(513,26,3,'C003',4),(514,26,3,'C004',2),(515,26,3,'C005',3),(516,26,4,'D001',2),(517,26,4,'D002',3),(518,26,4,'D003',1),(519,26,4,'D004',4),(520,26,4,'D005',2),(521,27,1,'A001',3),(522,27,1,'A002',1),(523,27,1,'A003',4),(524,27,1,'A004',2),(525,27,1,'A005',3),(526,27,2,'B001',2),(527,27,2,'B002',3),(528,27,2,'B003',1),(529,27,2,'B004',4),(530,27,2,'B005',2),(531,27,3,'C001',4),(532,27,3,'C002',2),(533,27,3,'C003',3),(534,27,3,'C004',1),(535,27,3,'C005',4),(536,27,4,'D001',1),(537,27,4,'D002',4),(538,27,4,'D003',2),(539,27,4,'D004',3),(540,27,4,'D005',1),(541,28,1,'A001',1),(542,28,1,'A002',4),(543,28,1,'A003',2),(544,28,1,'A004',3),(545,28,1,'A005',1),(546,28,2,'B001',3),(547,28,2,'B002',1),(548,28,2,'B003',4),(549,28,2,'B004',2),(550,28,2,'B005',3),(551,28,3,'C001',2),(552,28,3,'C002',3),(553,28,3,'C003',1),(554,28,3,'C004',4),(555,28,3,'C005',2),(556,28,4,'D001',4),(557,28,4,'D002',2),(558,28,4,'D003',3),(559,28,4,'D004',1),(560,28,4,'D005',4);
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
  `gender` enum('男性','女性','その他') NOT NULL COMMENT '性別(ENUM(1.男性, 2.女性, 3.その他）)',
  `post_code` varchar(7) NOT NULL COMMENT '郵便番号(ハイフンなし７桁)',
  `address` varchar(255) NOT NULL COMMENT '住所',
  `phone` varchar(20) NOT NULL COMMENT '電話番号',
  `email` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL COMMENT 'パスワード',
  `created_at` date NOT NULL COMMENT 'アカウント作成日(登録日)',
  `last_login_at` datetime NOT NULL COMMENT 'カードの有効期限',
  `credit_card_number` varchar(45) DEFAULT NULL COMMENT 'クレジットカード番号',
  `credit_card_expiry_date` varchar(5) DEFAULT NULL,
  `credit_card_security_code` varchar(3) DEFAULT NULL COMMENT 'カードのセキュリティコード',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='会員テーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'斎藤 飛鳥','さいとう あすか','1998-08-01','女性','8100072','福岡県福岡市中央区長浜一丁目4番13号 SF福岡ビル6階','0924011835','asuka-saitou@rikarento.com','1234','2025-03-12','2025-03-12 15:10:00',NULL,NULL,NULL),(2,'田中 太一','たなか たいち','2000-01-01','男性','8100072','福岡県福岡市中央区長浜2-3-18-220','09012345678','iwamuro0604@gmail.com','Iwamuro0604','2025-03-24','2025-03-24 16:30:00',NULL,NULL,NULL);
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

-- Dump completed on 2025-03-26 15:18:13

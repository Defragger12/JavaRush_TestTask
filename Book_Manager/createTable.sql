USE test;

DROP TABLE IF EXISTS book;

CREATE TABLE `test`.`book` (
  `id` INT(8) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(255) NULL,
  `author` VARCHAR(100) NOT NULL,
  `isbn` VARCHAR(20) NULL,
  `printYear` INT NOT NULL,
  `readAlready` VARCHAR(3) NOT NULL DEFAULT 'No',
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

insert into book (title, description, author, isbn, printYear) values
  ('book1', 'coolbook_book_1', 'author1', '5-05-000746-1', 1442),
  ('book2', 'coolbook_book_2', 'author2', '5-05-000746-2', 1455),
  ('book3', 'coolbook_book_3', 'author3', '5-05-000746-3', 1466),
  ('book4', 'coolbook_book_4', 'author4', '5-05-000746-4', 1477),
  ('book5', 'coolbook_book_5', 'author5', '5-05-000746-5', 1833),
  ('book6', 'coolbook_book_6', 'author6', '5-05-000746-6', 1844),
  ('book7', 'coolbook_book_7', 'author7', '5-05-000746-7', 1855),
  ('book8', 'coolbook_book_8', 'author8', '5-05-000746-8', 1866),
  ('book9', 'coolbook_book_9', 'author9', '5-05-000746-9', 1877),
  ('book10', 'coolbook_book_10', 'author10', '5-05-000746-10', 1445),
  ('book11', 'coolbook_book_11', 'author11', '5-05-000746-11', 1645),
  ('book12', 'coolbook_book_12', 'author12', '5-05-000746-12', 1734),
  ('book13', 'coolbook_book_13', 'author13', '5-05-000746-13', 1234),
  ('book14', 'coolbook_book_14', 'author14', '5-05-000746-14', 1756),
  ('book15', 'coolbook_book_15', 'author15', '5-05-000746-15', 1754),
  ('book16', 'coolbook_book_16', 'author16', '5-05-000746-16', 1753),
  ('book17', 'coolbook_book_17', 'author17', '5-05-000746-17', 1998),
  ('book18', 'coolbook_book_18', 'author18', '5-05-000746-18', 1996),
  ('book19', 'coolbook_book_19', 'author19', '5-05-000746-19', 1886),
  ('book20', 'coolbook_book_20', 'author20', '5-05-000746-20', 1884),
  ('book21', 'coolbook_book_21', 'author21', '5-05-000746-21', 1882),
  ('book22', 'coolbook_book_22', 'author22', '5-05-000746-22', 1846)
CREATE SCHEMA IF NOT EXISTS layout_maker;
USE layout_maker;

-- -----------------------------------------------------
-- Table lm_file
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS lm_file (
  id_file INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  extension CHAR(5) NOT NULL,
  file_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_file)
);
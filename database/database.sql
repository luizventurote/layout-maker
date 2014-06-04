CREATE SCHEMA IF NOT EXISTS layout_maker;
USE layout_maker;

-- -----------------------------------------------------
-- Table config
-- -----------------------------------------------------
CREATE TABLE config (
  id_config INT NOT NULL,
  path_files VARCHAR(50) NULL,
  PRIMARY KEY (id_config)
);

INSERT INTO config (id_config, path_files) VALUES ('1', 'files/files/');

-- -----------------------------------------------------
-- Table lm_file
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS arquivo (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  extension CHAR(5) NOT NULL,
  directory VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);
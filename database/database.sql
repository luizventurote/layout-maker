CREATE SCHEMA IF NOT EXISTS layout_maker;
USE layout_maker;


-- -----------------------------------------------------
-- Table config
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS config (
  id_config INT NOT NULL,
  path_files VARCHAR(200) NULL,
  PRIMARY KEY (id_config))
ENGINE = InnoDB;

INSERT INTO config (id_config, path_files) VALUES ('1', 'files/files/');

-- -----------------------------------------------------
-- Table arquivo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS arquivo (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  extension VARCHAR(45) NOT NULL,
  directory VARCHAR(45) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table categoria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS categoria (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table componente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS componente (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  categoria_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_componente_categoria1
    FOREIGN KEY (categoria_id)
    REFERENCES categoria (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table componente_arquivo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS componente_arquivo (
  componente_id INT NOT NULL,
  arquivo_id INT NOT NULL,
  PRIMARY KEY (componente_id, arquivo_id),
  CONSTRAINT fk_componente_has_arquivo_componente
    FOREIGN KEY (componente_id)
    REFERENCES componente (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_componente_has_arquivo_arquivo1
    FOREIGN KEY (arquivo_id)
    REFERENCES arquivo (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table framework
-- -----------------------------------------------------
CREATE TABLE framework (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table biblioteca
-- -----------------------------------------------------
CREATE TABLE biblioteca (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;

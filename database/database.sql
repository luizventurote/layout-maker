CREATE SCHEMA IF NOT EXISTS layout_maker;
USE layout_maker;


-- -----------------------------------------------------
-- Table config
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS config (
  id_config INT NOT NULL,
  path_files VARCHAR(50) NULL,
  PRIMARY KEY (id_config))
ENGINE = InnoDB;


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
-- Table componente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS componente (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (id))
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
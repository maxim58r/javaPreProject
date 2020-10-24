CREATE DATABASE `users_db`;

CREATE TABLE `users_db`.`users`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `age`      INT(3)      NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS roles (
  id   SERIAL PRIMARY KEY,
  role VARCHAR(5) NOT NULL
);

CREATE TABLE IF NOT EXISTS `my_db`.`users_db`
(
    `id`       BIGINT(20)  NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `age`      TINYINT(3)  NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

INSERT INTO roles (id, role)
VALUES (DEFAULT, 'admin');
INSERT INTO roles (id, role)
VALUES (DEFAULT, 'user');

CREATE TABLE IF NOT EXISTS users (
  id       SERIAL PRIMARY KEY,
  login    VARCHAR(10) UNIQUE NOT NULL,
  password VARCHAR(10) UNIQUE NOT NULL,
  role     INTEGER     NOT NULL,
  FOREIGN KEY (role) REFERENCES roles (id)
);


INSERT INTO users (id, login, password, role) VALUES (DEFAULT, 'admin', '123', 1);
INSERT INTO users (id, login, password, role)
VALUES (DEFAULT, 'user', '1234', 2);

SELECT u.id, u.login, u.password, r.id AS rol_id, r.role FROM users AS u LEFT JOIN roles AS r ON u.role = r.id WHERE u.login = (?);

DELETE FROM users;
DROP TABLE IF EXISTS Ingredient;
CREATE TABLE IF NOT EXISTS Ingredient (
    id              VARCHAR(4)  NOT NULL,
    name            VARCHAR(25) NOT NULL,
    type            VARCHAR(10) NOT NULL
);

DROP TABLE IF EXISTS Taco;
CREATE TABLE IF NOT EXISTS Taco (
    id              IDENTITY,
    name            VARCHAR(50) NOT NULL,
    createdAt       TIMESTAMP   NOT NULL
);

DROP TABLE IF EXISTS Taco_Order;
CREATE TABLE IF NOT EXISTS Taco_Order (
    id              IDENTITY,
    deliveryName    VARCHAR(50) NOT NULL,
    deliveryStreet  VARCHAR(50) NOT NULL,
    deliveryCity    VARCHAR(50) NOT NULL,
    deliveryState   VARCHAR(2)  NOT NULL,
    deliveryZip     VARCHAR(10) NOT NULL,
    ccNumber        VARCHAR(16) NOT NULL,
    ccExpiration    VARCHAR(5)  NOT NULL,
    ccCVV           VARCHAR(3)  NOT NULL,
    placedAt        TIMESTAMP   NOT NULL
);

DROP TABLE IF EXISTS Taco_Ingredients;
CREATE TABLE IF NOT EXISTS Taco_Ingredients (
    taco            BIGINT      NOT NULL,
    ingredient      VARCHAR(4)  NOT NULL
);
ALTER TABLE Taco_Ingredients
    ADD FOREIGN KEY (taco) REFERENCES Taco(id);
ALTER TABLE Taco_Ingredients
    ADD FOREIGN KEY (ingredient)  REFERENCES Ingredient(id);

DROP TABLE IF EXISTS Taco_Order_Tacos;
CREATE TABLE IF NOT EXISTS  Taco_Order_Tacos (
    tacoOrder       BIGINT      NOT NULL,
    taco            BIGINT      NOT NULL
);
ALTER TABLE Taco_Order_Tacos
    ADD FOREIGN KEY (tacoOrder) REFERENCES Taco_Order(id);
ALTER TABLE Taco_Order_Tacos
    ADd FOREIGN KEY (taco) REFERENCES Taco(id);

DROP TABLE IF EXISTS Users;
CREATE TABLE IF NOT EXISTS Users (
    username        VARCHAR(50) NOT NULL,
    password        VARCHAR(50) NOT NULL,
    enabled         TINYINT     NOT NULL DEFAULT 1,

    PRIMARY KEY (username)
);

DROP TABLE IF EXISTS Authorities;
CREATE TABLE IF NOT EXISTS Authorities (
    username        VARCHAR(50) NOT NULL,
    authority       VARCHAR(50) NOT NULL,

    FOREIGN KEY (username) REFERENCES Users(username)
);

DROP INDEX IF EXISTS ix_auth_username;
CREATE UNIQUE INDEX IF NOT EXISTS ix_auth_username
    ON Authorities (username, authority);
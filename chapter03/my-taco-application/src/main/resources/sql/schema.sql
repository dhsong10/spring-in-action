DROP TABLE IF EXISTS Ingredient;
CREATE TABLE IF NOT EXISTS Ingredient(
    id              VARCHAR(4)      NOT NULL,
    name            VARCHAR(25)     NOT NULL,
    type            VARCHAR(10)     NOT NULL
);

DROP TABLE IF EXISTS Taco;
CREATE TABLE IF NOT EXISTS Taco(
    id              IDENTITY,
    name            VARCHAR(50)     NOT NULL,
    createdAt       TIMESTAMP       NOT NULL
);

DROP TABLE IF EXISTS Taco_Order;
CREATE TABLE IF NOT EXISTS Taco_Order(
    id              IDENTITY,
    deliveryName    VARCHAR(50)     NOT NULL,
    deliveryStreet  VARCHAR(50)     NOT NULL,
    deliveryCity    VARCHAR(50)     NOT NULL,
    deliveryState   VARCHAR(2)      NOT NULL,
    deliveryZip     VARCHAR(10)     NOT NULL,
    ccNumber        VARCHAR(16)     NOT NULL,
    ccExpiration    VARCHAR(5)      NOT NULL,
    ccCVV           VARCHAR(3)      NOT NULL,
    plactedAt       TIMESTAMP       NOT NULL
);

DROP TABLE IF EXISTS Taco_Ingredients;
CREATE TABLE IF NOT EXISTS Taco_Ingredients(
    tacoId          BIGINT          NOT NULL,
    ingredientId    VARCHAR(4)      NOT NULL
);
ALTER TABLE Taco_Ingredients
    ADD FOREIGN KEY (tacoId) REFERENCES Taco(id);
ALTER TABLE Taco_Ingredients
    ADD FOREIGN Key (ingredientId) REFERENCES Ingredient(id);

DROP TABLE IF EXISTS Taco_Order_Tacos;
CREATE TABLE IF NOT EXISTS Taco_Order_Tacos(
    orderId         BIGINT          NOT NULL,
    tacoId          BIGINT          NOT NULL
);
ALTER TABLE Taco_Order_Tacos
    ADD FOREIGN KEY (orderId) REFERENCES Taco_Order(id);
ALTER TABLE Taco_Order_Tacos
    ADD FOREIGN KEY (tacoId) REFERENCES Taco(id);
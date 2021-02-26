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

DROP TABLE IF EXISTS TacoOrder;
CREATE TABLE IF NOT EXISTS TacoOrder(
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

DROP TABLE IF EXISTS Taco_Ingredient;
CREATE TABLE IF NOT EXISTS Taco_Ingredient(
    tacoId          BIGINT          NOT NULL,
    ingredientId    VARCHAR(4)      NOT NULL
);
ALTER TABLE Taco_Ingredient
    ADD FOREIGN KEY (tacoId) REFERENCES Taco(id);
ALTER TABLE Taco_Ingredient
    ADD FOREIGN Key (ingredientId) REFERENCES Ingredient(id);

DROP TABLE IF EXISTS TacoOrder_Taco;
CREATE TABLE IF NOT EXISTS TacoOrder_Taco(
    orderId         BIGINT          NOT NULL,
    tacoId          BIGINT          NOT NULL
);
ALTER TABLE TacoOrder_Taco
    ADD FOREIGN KEY (orderId) REFERENCES TacoOrder(id);
ALTER TABLE TacoOrder_Taco
    ADD FOREIGN KEY (tacoId) REFERENCES Taco(id);
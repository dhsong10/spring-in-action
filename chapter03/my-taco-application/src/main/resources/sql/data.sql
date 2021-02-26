DELETE FROM Ingredient;
INSERT INTO Ingredient (id, name, type)
VALUES
    ('FLTO',    'Flour Tortilla',   'WRAP'),
    ('COTO',    'Corn Tortilla',    'WRAP'),
    ('GRBF',    'Ground Beef',      'PROTEIN'),
    ('CARN',    'Carnitas',         'PROTEIN'),
    ('TMTO',    'Dices Tomatoes',   'WRAP'),
    ('LETC',    'Lettuce',          'WRAP'),
    ('CHED',    'Cheddar',          'CHEESE'),
    ('JACK',    'Monterrey Jack',   'CHEESE'),
    ('SLSA',    'Salsa',            'SAUCE'),
    ('SRCR',    'Source Cream',     'SAUCE');

DELETE FROM Taco;

DELETE FROM TacoOrder;

DELETE FROM Taco_Ingredient;

DELETE FROM TacoOrder_Taco;
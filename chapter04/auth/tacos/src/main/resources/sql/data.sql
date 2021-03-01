INSERT INTO Users (username, password) VALUES ('user1', 'password1');
INSERT INTO Users (username, password) VALUES ('user2', 'password2');

INSERT INTO Authorities (username, authority) VALUES ('user1', 'ROLE_USER');
INSERT INTO Authorities (username, authority) VALUES ('user2', 'ROLE_USER');

COMMIT;
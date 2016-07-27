INSERT INTO user(id, username, password, enabled) VALUES (1, 'admin', '$2a$04$/vL8r0b2.3Zr9gMqtMvMYOuthmOoUWdOymekOYyydSb3uGOcifZ42', true);
INSERT INTO user(id, username, password, enabled) VALUES (2, 'user', '$2a$04$/vL8r0b2.3Zr9gMqtMvMYOuthmOoUWdOymekOYyydSb3uGOcifZ42', true);

INSERT INTO role(id, role) VALUES (1, 'ROLE_USER');
INSERT INTO role(id, role) VALUES (2, 'ROLE_ADMIN');
INSERT INTO role(id, role) VALUES (3, 'ROLE_API');

INSERT INTO user_role(user_id, role_id) VALUES (1, 1);
INSERT INTO user_role(user_id, role_id) VALUES (1, 2);
INSERT INTO user_role(user_id, role_id) VALUES (1, 3);
INSERT INTO user_role(user_id, role_id) VALUES (2, 1);
INSERT INTO user_role(user_id, role_id) VALUES (2, 3);
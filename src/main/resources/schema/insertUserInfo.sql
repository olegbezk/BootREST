INSERT INTO users(username,password,enabled)
VALUES ('admin','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);
INSERT INTO users(username,password,enabled)
VALUES ('user','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);

INSERT INTO userRoles (username, role)
VALUES ('admin', 'USER');
INSERT INTO userRoles (username, role)
VALUES ('admin', 'ADMIN');
INSERT INTO userRoles (username, role)
VALUES ('user', 'USER');

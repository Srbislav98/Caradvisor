-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
-- Lozinka za oba user-a je 123

INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'admin@example.com', true, '2017-10-01 18:57:58.508-07');

INSERT INTO AUTHORITY (name) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);

INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('BMW X6','BMW','LIMUZINA',5000,1998,'BENZIN',true,80,'BELA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Audi A8','Audi','HECBEK',6000,2008,'BENZIN',false,95,'CRNA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Porsche cayena','Porsche','KUPE',7000,2018,'ELEKTRICNI_POGON',true,120,'ZUTA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Renault megane','Renault','KABRIOLET',4000,2012,'DIZEL',true,60,'CRVENA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Mercedes benz','Mercedes','KARAVAN',3000,2000,'BENZIN_GAS',false,50,'SIVA',0);
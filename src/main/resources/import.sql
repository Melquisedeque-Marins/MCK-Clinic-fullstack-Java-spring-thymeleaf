INSERT INTO tb_user (name, email, cpf, password, phone_Number, birth_Date, gender ) VALUES ('Melquisedeque', 'melck@gmail.com', '03948583366', '$2a$10$.HWKObp7.jOTKxNYXqNrtO110Qib3PN1Tekorh73xTwR3QFPc0jTi', '98988052832', '1989-03-01', 'MALE');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');


INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);


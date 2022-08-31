INSERT INTO tb_user (name, email, cpf, password, phone_Number, birth_Date, gender ) VALUES ('Melquisedeque', 'melck@gmail.com', '03948583366', '$2a$10$.HWKObp7.jOTKxNYXqNrtO110Qib3PN1Tekorh73xTwR3QFPc0jTi', '98988052832', '1989-03-01', 'MALE');
INSERT INTO tb_user (name, email, cpf, password, phone_Number, birth_Date, gender ) VALUES ('Raissa', 'raissa@gmail.com', '73701123063', '$2a$10$.HWKObp7.jOTKxNYXqNrtO110Qib3PN1Tekorh73xTwR3QFPc0jTi', '98988052832', '1989-03-01', 'FEMALE');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');


INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_expertise (name, description) VALUES ('Cardiologia', 'Especialidade médica para tratamento de doenças no coração');
INSERT INTO tb_expertise (name, description) VALUES ('Ortopedia', 'Especialidade destinada ao tratamento de problemas na estrutura ossea');

INSERT INTO tb_doctor (name, cpf, email, phone_number, registry)  VALUES ('House', '29663434007', 'house@gmail.com', '+351935893129', '1234567891011');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry)  VALUES ('Stone', '86338370051', 'house@gmail.com', '+351935893129', '1234567891011');

INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (1, 1);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (2, 2);


INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-10 11:10:00Z', 'SCHEDULED', 'CONSULT', 1L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-08-10 11:20:00Z', 'SCHEDULED', 'CONSULT', 2L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-08-10 11:00:00Z', 'SCHEDULED', 'CONSULT', 1L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-08-10 11:30:00Z', 'SCHEDULED', 'CONSULT', 2L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-01 10:00:00Z', 'SCHEDULED', 'CONSULT', 1L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-10 08:30:00Z', 'SCHEDULED', 'CONSULT', 1L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-10 11:00:00Z', 'SCHEDULED', 'CONSULT', 2L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-05 11:30:00Z', 'SCHEDULED', 'CONSULT', 2L, 2L);
INSERT INTO tb_user (name, email, cpf, password, phone_Number, birth_Date, gender ) VALUES ('Melquisedeque', 'melck@gmail.com', '03948583366', '$2a$10$.HWKObp7.jOTKxNYXqNrtO110Qib3PN1Tekorh73xTwR3QFPc0jTi', '98988052832', '1989-03-01', 'MALE');
INSERT INTO tb_user (name, email, cpf, password, phone_Number, birth_Date, gender ) VALUES ('Raissa', 'raissa@gmail.com', '73701123063', '$2a$10$.HWKObp7.jOTKxNYXqNrtO110Qib3PN1Tekorh73xTwR3QFPc0jTi', '98988052832', '1989-03-01', 'FEMALE');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');


INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_expertise (name, description, img_Url) VALUES ('Cardiologia', 'A cardiologia é uma especialidade da medicina que trata sobre o coração e suas doenças. Com o aumento do sedentarismo e a má alimentação, as doenças cardíacas estão sendo cada vez mais frequentes nas pessoas. Por isso, a importância da cardiologia vem crescendo cada vez mais.', 'https://raw.githubusercontent.com/Melquisedeque-Marins/MCK-Clinic-Thymeleaf/main/utils/Login-screen.png');
INSERT INTO tb_expertise (name, description, img_Url) VALUES ('Ortopedia', 'Ortopedia é a especialidade médica que utiliza métodos clínicos, físicos e cirúrgicos para tratar, corrigir enfermidades, lesões e deformidades ósseas, dos músculos, dos tendões, articulações e ligamentos, e tudo o que relaciona-se ao aparelho locomotor, ao sistema esquelético e estruturas associadas.', 'https://raw.githubusercontent.com/Melquisedeque-Marins/MCK-Clinic-Thymeleaf/main/utils/Login-screen.png');
INSERT INTO tb_expertise (name, description, img_Url) VALUES ('Neurologia', 'Neurologia é a especialidade médica que trata dos distúrbios estruturais do sistema nervoso. Especificamente, ela lida com o diagnóstico e tratamento de todas as categorias de doenças que envolvem os sistemas nervoso central, periférico e autônomo, parassimpático e simpático incluindo os seus revestimentos, vasos sanguíneos, e todos os tecidos efetores, como os músculos.[1] O correspondente cirúrgico da especialidade é a neurocirurgia.', 'https://raw.githubusercontent.com/Melquisedeque-Marins/MCK-Clinic-Thymeleaf/main/utils/Login-screen.png');
INSERT INTO tb_expertise (name, description, img_Url) VALUES ('Pediatria', 'A pediatria é o ramo da medicina que se especializa na saúde e nas doenças das crianças. Trata-se de uma especialidade médica que se centra nos pacientes desde o momento do nascimento até à adolescência, sem que exista um limite preciso que determine o final da sua validez.', 'https://raw.githubusercontent.com/Melquisedeque-Marins/MCK-Clinic-Thymeleaf/main/utils/Login-screen.png');

INSERT INTO tb_doctor (name, cpf, email, phone_number, registry)  VALUES ('House', '29663434007', 'house@gmail.com', '+351935893129', 'CRM 2178-MEDICINA');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry)  VALUES ('José', '20063282046', 'josé@gmail.com', '+351935893129', 'CRM 1175-MEDICINA');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry)  VALUES ('Stone', '86338370051', 'Stone@gmail.com', '+351935893129', 'CRM 2950-MEDICINA');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry)  VALUES ('Carlos', '69007111035', 'carlos@gmail.com', '+351935893129', 'CRM 6824-MEDICINA');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry)  VALUES ('João', '67021770030', 'João@gmail.com', '+351935893129', 'CRM 3475-MEDICINA');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry)  VALUES ('Raissa', '80196224039', 'raissa@gmail.com', '+351935893129', 'CRM 3764-MEDICINA');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry)  VALUES ('Maria', '28693704079', 'Maria@gmail.com', '+351935893129', 'CRM 2321-MEDICINA');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry)  VALUES ('Inacio', '61901087093', 'Inacio@gmail.com', '+351935893129', 'CRM 1987-MEDICINA');

INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (1, 1);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (2, 1);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (3, 2);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (4, 2);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (5, 3);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (6, 3);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (7, 4);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (8, 4);


INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-13 11:00:00Z', 'SCHEDULED', 'CONSULT', 1L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-13 07:10:00Z', 'SCHEDULED', 'CONSULT', 1L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-10 11:20:00Z', 'SCHEDULED', 'CONSULT', 2L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-10 11:30:00Z', 'SCHEDULED', 'CONSULT', 2L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-01 10:00:00Z', 'SCHEDULED', 'CONSULT', 3L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-10 08:30:00Z', 'SCHEDULED', 'CONSULT', 3L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-10 11:00:00Z', 'SCHEDULED', 'CONSULT', 4L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-09-05 11:30:00Z', 'SCHEDULED', 'CONSULT', 5L, 2L);
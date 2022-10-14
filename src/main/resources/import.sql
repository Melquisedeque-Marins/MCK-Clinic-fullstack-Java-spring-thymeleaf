INSERT INTO tb_user (name, email, cpf, password, phone_Number, birth_Date, gender ) VALUES ('Melquisedeque', 'melck@gmail.com', '03948583366', '$2a$10$.HWKObp7.jOTKxNYXqNrtO110Qib3PN1Tekorh73xTwR3QFPc0jTi', '98988052832', '1989-03-01', 'MALE');
INSERT INTO tb_user (name, email, cpf, password, phone_Number, birth_Date, gender ) VALUES ('Raissa', 'raissa@gmail.com', '73701123063', '$2a$10$.HWKObp7.jOTKxNYXqNrtO110Qib3PN1Tekorh73xTwR3QFPc0jTi', '98988052832', '1989-03-01', 'FEMALE');
INSERT INTO tb_user (name, email, cpf, password, phone_Number, birth_Date, gender ) VALUES ('João', 'joão@gmail.com', '08012183064', '$2a$10$.HWKObp7.jOTKxNYXqNrtO110Qib3PN1Tekorh73xTwR3QFPc0jTi', '98988052832', '1989-03-01', 'MALE');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');


INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);

INSERT INTO tb_expertise (name, description, img_Url) VALUES ('Cardiologia', 'A cardiologia é uma especialidade da medicina que trata sobre o coração e suas doenças. Com o aumento do sedentarismo e a má alimentação, as doenças cardíacas estão sendo cada vez mais frequentes nas pessoas. Por isso, a importância da cardiologia vem crescendo cada vez mais.', 'https://portaldasaude.scmp.pt/assets/misc/img/especialidades/Cardiologia/Cora%C3%A7%C3%A3o.jpg');
INSERT INTO tb_expertise (name, description, img_Url) VALUES ('Pediatria', 'A pediatria é o ramo da medicina que se especializa na saúde e nas doenças das crianças. Trata-se de uma especialidade médica que se centra nos pacientes desde o momento do nascimento até à adolescência, sem que exista um limite preciso que determine o final da sua validez.', 'https://www.grupohpa.com/uploads/media/ef782125f7767f925a992ad6e71c8177.jpg');
INSERT INTO tb_expertise (name, description, img_Url) VALUES ('Ortopedia', 'Ortopedia é a especialidade médica que utiliza métodos clínicos, físicos e cirúrgicos para tratar, corrigir enfermidades, lesões e deformidades ósseas, dos músculos, dos tendões, articulações e ligamentos, e tudo o que relaciona-se ao aparelho locomotor, ao sistema esquelético e estruturas associadas.', 'https://centroclinico.cespu.pt/sites/default/files/especialidades/2018-10/ortopedia.jpg');
INSERT INTO tb_expertise (name, description, img_Url) VALUES ('Neurologia', 'Neurologia é a especialidade médica que trata dos distúrbios estruturais do sistema nervoso. Especificamente, ela lida com o diagnóstico e tratamento de todas as categorias de doenças que envolvem os sistemas nervoso central, periférico e autônomo, parassimpático e simpático incluindo os seus revestimentos, vasos sanguíneos, e todos os tecidos efetores, como os músculos.[1] O correspondente cirúrgico da especialidade é a neurocirurgia.', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnOQF7OSO14qk_v6SzwXobqmYMMWjRdBi1ZQ&usqp=CAU');
INSERT INTO tb_expertise (name, description, img_Url) VALUES ('Oftalmologia', 'A oftalmologia (grego: ophthalmós (olho) + logos (estudo): estudo do olho) é uma especialidade da medicina que estuda e trata as doenças relacionadas ao olho, à refração e aos olhos e seus anexos. O médico oftalmologista realiza cirurgias, prescreve tratamentos e correções para os distúrbios de visão. A oftalmologia tem várias sub-especialidades, entre elas a oftalmo-pediatria, a plástica ocular, doenças orbitárias, doenças das vias lacrimais, o estrabismo, o glaucoma, a cirurgia refrativa, retina, córnea, etc.', 'https://d3043uog1ad1l6.cloudfront.net/uploads/2019/06/oftalmologia.jpg');

INSERT INTO tb_doctor (name, cpf, email, phone_number, registry, office_hours, gender)  VALUES ('House', '29663434007', 'house@gmail.com', '+351935893129', 'CRM 2012-MEDICINA', 'MORNING', 'MALE');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry, office_hours, gender) VALUES ('Stone', '86338370051', 'stone@gmail.com', '+351935893129', 'CRM 2950-MEDICINA', 'MORNING', 'MALE');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry, office_hours, gender)  VALUES ('Strange', '20063282046', 'strange@gmail.com', '+351935893129', 'CRM 1175-MEDICINA', 'AFTERNOON', 'MALE');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry, office_hours, gender) VALUES ('Watson', '69007111035', 'watson@gmail.com', '+351935893129', 'CRM 6824-MEDICINA', 'AFTERNOON', 'MALE');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry, office_hours, gender) VALUES ('Dolittle', '67021770030', 'dolittle@gmail.com', '+351935893129', 'CRM 3475-MEDICINA', 'MORNING', 'MALE');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry, office_hours, gender) VALUES ('Raissa', '80196224039', 'raissa@gmail.com', '+351935893129', 'CRM 3764-MEDICINA', 'AFTERNOON', 'FEMALE');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry, office_hours, gender) VALUES ('Maria', '28693704079', 'maria@gmail.com', '+351935893129', 'CRM 2321-MEDICINA', 'MORNING', 'FEMALE');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry, office_hours, gender) VALUES ('Inacio', '61901087093', 'inacio@gmail.com', '+351935893129', 'CRM 1987-MEDICINA', 'AFTERNOON', 'MALE');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry, office_hours, gender) VALUES ('Jack Shephard', '25400122051', 'shephard@gmail.com', '+351935893129', 'CRM 2004-MEDICINA', 'AFTERNOON', 'MALE');
INSERT INTO tb_doctor (name, cpf, email, phone_number, registry, office_hours, gender) VALUES ('Melquisedeque Marins', '66000625090', 'melqui@gmail.com', '+351935893129', 'CRM 1989-MEDICINA', 'AFTERNOON', 'MALE');

INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (1, 1);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (2, 1);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (3, 2);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (4, 2);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (5, 3);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (6, 3);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (7, 4);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (8, 4);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (9, 5);
INSERT INTO tb_doctor_expertise (doctor_id, expertise_id) VALUES (10, 5);



INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 09:30:00Z', 'CONFIRMED', 'CONSULT', 1L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 09:40:00Z', 'CONFIRMED', 'CONSULT', 1L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 09:50:00Z', 'CONFIRMED', 'CONSULT', 1L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 10:40:00Z', 'CONFIRMED', 'CONSULT', 1L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 11:40:00Z', 'CONFIRMED', 'CONSULT', 2L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 10:10:00Z', 'SCHEDULED', 'CONSULT', 1L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 10:20:00Z', 'SCHEDULED', 'CONSULT', 2L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 10:50:00Z', 'SCHEDULED', 'CONSULT', 3L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 10:40:00Z', 'SCHEDULED', 'CONSULT', 4L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 10:30:00Z', 'SCHEDULED', 'CONSULT', 5L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 10:00:00Z', 'SCHEDULED', 'CONSULT', 1L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 10:00:00Z', 'SCHEDULED', 'CONSULT', 1L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 15:20:00Z', 'SCHEDULED', 'CONSULT', 2L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 17:00:00Z', 'SCHEDULED', 'CONSULT', 1L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 16:30:00Z', 'SCHEDULED', 'CONSULT', 2L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 16:50:00Z', 'SCHEDULED', 'CONSULT', 3L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 17:30:00Z', 'CONFIRMED', 'CONSULT', 3L, 2L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 14:00:00Z', 'SCHEDULED', 'CONSULT', 4L, 1L);
INSERT INTO tb_scheduling (created_At, scheduling_time, status, type, doctor_id, user_id) VALUES (NOW(), '2022-10-14 15:30:00Z', 'CONFIRMED', 'CONSULT', 4L, 2L);
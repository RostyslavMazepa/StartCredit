
-- DROP TABLE public.document, public.phone, public.person, public.phone_type, public.document_type, public.relation_type;
------------------------------------------------------
-- document_type
------------------------------------------------------
INSERT INTO public.document_type (id, enable, name)
VALUES (DEFAULT, true, 'Паспорт');
INSERT INTO public.document_type (id, enable, name)
VALUES (DEFAULT, true, 'ІПН');
------------------------------------------------------
-- phone_type
------------------------------------------------------
INSERT INTO public.phone_type (id, enable, name)
VALUES (DEFAULT, true, 'Домашній');
INSERT INTO public.phone_type (id, enable, name)
VALUES (DEFAULT, true, 'Робочий');
INSERT INTO public.phone_type (id, enable, name)
VALUES (DEFAULT, true, 'Мобільний');
------------------------------------------------------
-- person
------------------------------------------------------
INSERT INTO public.person (id, birth_date, first_name, last_name, middle_name, sex)
VALUES (DEFAULT, '1983-05-21', 'Ростислав', 'Мазепа', 'Юрійович', true);
INSERT INTO public.person (id, birth_date, first_name, last_name, middle_name, sex)
VALUES (DEFAULT, '1982-06-15', 'Ольга', 'Батаєва', 'Ігорівна', false);
------------------------------------------------------
-- phone
------------------------------------------------------
INSERT INTO public.phone (id, phone_type_id, number_phone, person_id, priority)
VALUES (DEFAULT, 1, '+380446298507', 1, false);
INSERT INTO public.phone (id, phone_type_id, number_phone, person_id, priority)
VALUES (DEFAULT, 3, '+380977226611', 1, true);
INSERT INTO public.phone (id, phone_type_id, number_phone, person_id, priority)
VALUES (DEFAULT, 1, '+380446298507', 2, false);
INSERT INTO public.phone (id, phone_type_id, number_phone, person_id, priority)
VALUES (DEFAULT, 3, '+380661667339', 2, true);
------------------------------------------------------
-- document
------------------------------------------------------
INSERT INTO public.document (id, document_type_id, issue_by, issue_date, number_document, person_id, series_document)
VALUES (DEFAULT, 1, 'Миколаївським РВ УМВС', '2000-04-13', '256497', 1, 'КВ');
INSERT INTO public.document (id, document_type_id, issue_by, issue_date, number_document, person_id, series_document)
VALUES (DEFAULT, 2, 'Миколаївськолаївською ПІ', '2000-01-01', '8295674907', 1, null);
INSERT INTO public.document (id, document_type_id, issue_by, issue_date, number_document, person_id, series_document)
VALUES (DEFAULT, 1, 'Київським УМВС', '2000-05-01', '526798', 2, 'РК');
INSERT INTO public.document (id, document_type_id, issue_by, issue_date, number_document, person_id, series_document)
VALUES (DEFAULT, 2, 'Київською ПІ', '1999-05-01', '9517536543', 2, null);
------------------------------------------------------
-- relation_type
------------------------------------------------------
INSERT INTO public.relation_type (id, enable, name)
VALUES (DEFAULT, true, 'Чоловік');
INSERT INTO public.relation_type (id, enable, name)
VALUES (DEFAULT, true, 'Дружина');
INSERT INTO public.relation_type (id, enable, name)
VALUES (DEFAULT, true, 'Син');
INSERT INTO public.relation_type (id, enable, name)
VALUES (DEFAULT, true, 'Дочка');
INSERT INTO public.relation_type (id, enable, name)
VALUES (DEFAULT, true, 'Брат');
INSERT INTO public.relation_type (id, enable, name)
VALUES (DEFAULT, true, 'Сестра');
------------------------------------------------------
-- person_relation
------------------------------------------------------
INSERT INTO public.person_relation (id, create_date, person_id, person_relation_id, relation_type_id)
VALUES (DEFAULT, '2018-08-23', 1, 2, 2);
------------------------------------------------------
-- users
------------------------------------------------------
INSERT INTO public.users (id, active, password, username)
VALUES (DEFAULT, true , 'MaRo210583', 'rostyslav.mazepa@gmail.com')
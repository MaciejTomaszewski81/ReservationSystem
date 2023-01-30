INSERT into application_user (first_name,last_name,mail,phone_number, password,nick)VALUES
('Marta','Warta','zzz@wo.pl',458659745,'{noop}321','zuza'),
('Andrzej','Bandrzej','vcjk@wo.pl',123987852,'{noop}321','Słomka'),
('Andrze','Fandrzej','kujk@wo.pl',123948852,'{noop}321','Słonina'),
('Andrzj','Bandrzej','vc5k@wo.pl',129787852,'{noop}321','Niuansik');
    INSERT INTO treatment (treatment, treatment_time)VALUES
    ('Konsultacja fizjoterapeutyczna',150),
    ('Terapia indywidualna',150),
    ('Masaż klasyczny',150),
    ('Masaż głęboki',150),
    ('Terapia uroginekologiczna',150),
    ('Kinesiology Taping',150),
    ('Instruktaż ćwiczeń',150);
INSERT INTO user_role(user_id, role) VALUES
                                         (1,'ROLE_ADMIN'),
                                         (1,'ROLE_USER'),
                                         (2,'ROLE_USER'),
                                         (3,'ROLE_USER'),
                                         (4,'ROLE_ADMIN');

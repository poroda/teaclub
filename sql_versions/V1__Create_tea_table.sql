CREATE TABLE tea (
     id serial PRIMARY KEY,
     name varchar(50),
     variety varchar(50)
);

INSERT INTO tea(name, variety)
VALUES ('Lohikäärmeen perä', 'musta'),
       ('Oolong', 'valkoinen'),
       ('C-battery', 'punainen'),
       ('Lady Grey', 'musta'),
       ('Milky Oolong', 'valkoinen'),
       ('Nippon Green', 'vihreä');


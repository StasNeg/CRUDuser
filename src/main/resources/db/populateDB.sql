DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (first_name, last_name,email)
VALUES  ('UserName', 'UserLastName', 'user@yandex.ru'),
        ('AdminName', 'AdminLastName', 'admin@gmail.com');


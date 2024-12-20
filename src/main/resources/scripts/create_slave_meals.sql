CREATE TABLE meals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    image VARCHAR(255)
);

INSERT INTO meals (date, type, image) VALUES
    ('2024-05-21T00:00:01.000Z', 'morning', '/images/1.png'),
    ('2024-05-21T00:00:02.000Z', 'snack', '/images/2.png'),
    ('2024-05-21T00:00:03.000Z', 'dinner', '/images/3.png'),
    ('2024-05-21T00:00:04.000Z', 'lunch', '/images/4.png'),
    ('2024-05-21T00:00:05.000Z', 'morning', '/images/5.png'),
    ('2024-05-21T00:00:06.000Z', 'snack', '/images/6.png'),
    ('2024-05-21T00:00:07.000Z', 'dinner', '/images/7.png'),
    ('2024-05-21T00:00:08.000Z', 'lunch', '/images/8.png'),
    ('2024-05-21T00:00:09.000Z', 'morning', '/images/9.png'),
    ('2024-05-21T00:00:10.000Z', 'snack', '/images/10.png'),
    ('2024-05-21T00:00:11.000Z', 'dinner', '/images/11.png'),
    ('2024-05-21T00:00:12.000Z', 'lunch', '/images/12.png');
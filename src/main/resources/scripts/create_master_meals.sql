CREATE TABLE IF NOT EXISTS meals (
   id INT AUTO_INCREMENT PRIMARY KEY,
   date VARCHAR(255) NOT NULL,
   type VARCHAR(255) NOT NULL,
   image VARCHAR(255)
);

INSERT INTO meals (date, type, image) VALUES
  ('2024-05-21T00:00:01.000Z', 'master.morning', '/master/images/1.png'),
  ('2024-05-21T00:00:02.000Z', 'master.snack', '/master/images/2.png'),
  ('2024-05-21T00:00:03.000Z', 'master.dinner', '/master/images/3.png'),
  ('2024-05-21T00:00:04.000Z', 'master.lunch', '/master/images/4.png'),
  ('2024-05-21T00:00:05.000Z', 'master.morning', '/master/images/5.png'),
  ('2024-05-21T00:00:06.000Z', 'master.snack', '/master/images/6.png'),
  ('2024-05-21T00:00:07.000Z', 'master.dinner', '/master/images/7.png'),
  ('2024-05-21T00:00:08.000Z', 'master.lunch', '/master/images/8.png'),
  ('2024-05-21T00:00:09.000Z', 'master.morning', '/master/images/9.png'),
  ('2024-05-21T00:00:10.000Z', 'master.snack', '/master/images/10.png'),
  ('2024-05-21T00:00:11.000Z', 'master.dinner', '/master/images/11.png'),
  ('2024-05-21T00:00:12.000Z', 'master.lunch', '/master/images/12.png');
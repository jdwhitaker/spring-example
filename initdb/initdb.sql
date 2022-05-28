CREATE TABLE widgets (
  id INT AUTO_INCREMENT,
  name varchar(128),
  value varchar(128),
  PRIMARY KEY(id)
);

INSERT INTO widgets(name, value) VALUES 
  ('justins-widget', 'PHP is cool!'),
  ('john-widget', 'PHP sucks!');
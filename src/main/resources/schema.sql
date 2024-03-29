-- schema.sql
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  email VARCHAR(50)
);

-- data.sql
INSERT INTO users (username, password, email) VALUES 
  ('test', 'test', 'test@test.com');
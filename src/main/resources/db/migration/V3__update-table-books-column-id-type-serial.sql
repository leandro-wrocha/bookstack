ALTER TABLE books DROP COLUMN id;
CREATE SEQUENCE table_books_seq;
ALTER TABLE books ADD COLUMN id INT NOT NULL DEFAULT nextval('table_books_seq');

ALTER TABLE books DROP COLUMN id;
ALTER TABLE books ADD COLUMN id TEXT PRIMARY KEY NOT NULL;
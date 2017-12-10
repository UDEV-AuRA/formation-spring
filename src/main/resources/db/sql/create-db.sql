CREATE TABLE user (
  id   INTEGER PRIMARY KEY,
  login VARCHAR(30),
  type  VARCHAR(50)
);


CREATE TABLE film (
  id   INTEGER PRIMARY KEY,
  titre VARCHAR(30),
  type  VARCHAR(50)
);

CREATE TABLE user_films_avoir (
  id_user   BIGINT,
  id_film   BIGINT
);
ALTER TABLE user_films_avoir ADD FOREIGN KEY (id_user) REFERENCES user(id);
ALTER TABLE user_films_avoir ADD FOREIGN KEY (id_film) REFERENCES film(id);

CREATE TABLE user_films_vus (
  id_user   BIGINT,
  id_film   BIGINT
);
ALTER TABLE user_films_vus ADD FOREIGN KEY (id_user) REFERENCES user(id);
ALTER TABLE user_films_vus ADD FOREIGN KEY (id_film) REFERENCES film(id);
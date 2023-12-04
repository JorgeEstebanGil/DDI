CREATE TABLE IF NOT EXISTS REGION(
                                     id int auto_increment,
                                     nombre varchar(25)
);

CREATE TABLE IF NOT EXISTS POKEMON(
                                      id int auto_increment PRIMARY KEY,
                                      nombre varchar(50),
                                      region INT,
                                      entrenador INT,
                                      //FOREIGN KEY (region) REFERENCES REGION(id)
                                      FOREIGN KEY (entrenador) REFERENCES ENTRENADOR(id)
);

CREATE TABLE IF NOT EXISTS ENTRENADOR(
                                        id int auto_increment PRIMARY KEY,
                                        nombre varchar(50),
                                        active boolean,
);


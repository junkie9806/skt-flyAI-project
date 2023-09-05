/*
create table person
(
    id   int          not null,
    name varchar(255) not null
);


create table video (
                       video_id INT NOT NULL AUTO_INCREMENT,
                       video_path VARCHAR(100) NOT NULL,
                       video_title VARCHAR(100) NOT NULL,
                       team_code CHAR(2) DEFAULT 'AL',
                       game_date Date DEFAULT (current_date),
                       PRIMARY KEY (video_id)
);

create table image (
                       image_id INT NOT NULL AUTO_INCREMENT,
                       team_code CHAR(2) DEFAULT 'AL',
                       game_date Date DEFAULT (current_date),
                       PRIMARY KEY (image_id)
);

create table original (
                          original_id INT NOT NULL AUTO_INCREMENT,
                          image_id INT NOT NULL,
                          original_path VARCHAR(100) NOT NULL,
                          original_tag VARCHAR(20),
                          PRIMARY KEY (original_id),
                          FOREIGN KEY (image_id)
                              REFERENCES image (image_id)
);

create table converted (
                           converted_id INT NOT NULL AUTO_INCREMENT,
                           image_id INT NOT NULL,
                           converted_path VARCHAR(100) NOT NULL,
                           converted_tag VARCHAR(20),
                           PRIMARY KEY (converted_id),
                           FOREIGN KEY (image_id)
                               REFERENCES image (image_id)
);


 */
CREATE TABLE IF NOT EXISTS java_db_crud.student (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);


CREATE TABLE IF NOT EXISTS java_db_crud.teacher (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    birthday DATE
);

CREATE TABLE IF NOT EXISTS java_db_crud.student_teacher (
    student_id INTEGER NOT NULL,
    teacher_id INTEGER NOT NULL,
    PRIMARY KEY (student_id, teacher_id),
    FOREIGN KEY (student_id) REFERENCES java_db_crud.student(id) ON DELETE CASCADE,
    FOREIGN KEY (teacher_id) REFERENCES java_db_crud.teacher(id) ON DELETE CASCADE
);
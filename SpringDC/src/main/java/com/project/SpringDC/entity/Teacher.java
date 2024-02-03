package com.project.SpringDC.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teacher")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(
            name = "username",
            unique = true
    )
    private String username;

    @Column(
            name = "email",
            unique = true
    )
    private String email;

    @Column(name = "birthday")
    private LocalDate localDate;

    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + localDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) &&
                Objects.equals(username, teacher.username) &&
                Objects.equals(email, teacher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email);
    }


}
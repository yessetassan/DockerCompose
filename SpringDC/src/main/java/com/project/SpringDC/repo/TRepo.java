package com.project.SpringDC.repo;


import com.project.SpringDC.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TRepo extends JpaRepository<Teacher, Integer> {
    @Query("select t from Teacher t where t.id = ?1")
    Optional<Teacher> findById(Integer id);
}

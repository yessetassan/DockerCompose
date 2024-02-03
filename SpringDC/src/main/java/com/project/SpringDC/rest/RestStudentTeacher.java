package com.project.SpringDC.rest;


import com.project.SpringDC.entity.Student;
import com.project.SpringDC.entity.Teacher;
import com.project.SpringDC.service.SService;
import com.project.SpringDC.service.TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/student_teacher")
public class RestStudentTeacher {

    private final SService sService;
    private final TService tService;

    @Autowired
    public RestStudentTeacher(SService sService, TService tService) {
        this.sService = sService;
        this.tService = tService;
    }

    @PostMapping("/{s_id}/{t_id}")
    public ResponseEntity<String> save(@PathVariable(name = "s_id") Integer s_id,
                                       @PathVariable(name = "t_id") Integer t_id) {
        Optional<Student> student = sService.findById(s_id);
        Optional<Teacher> teacher = tService.findById(t_id);

        if (student.isPresent() || teacher.isPresent()) {
            return ResponseEntity.badRequest().body("One of them doesn't exist !");
        }

        Student s = student.get();
        Teacher t = teacher.get();

        Set<Teacher> teacherSet = s.getTeachers();
        teacherSet.add(t);
        s.setTeachers(teacherSet);
        sService.save(s);

        return ResponseEntity.ok().body("Successfully Saved !");
    }
}

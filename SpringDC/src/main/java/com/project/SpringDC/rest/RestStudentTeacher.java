package com.project.SpringDC.rest;

import com.project.SpringDC.entity.Student;
import com.project.SpringDC.entity.Teacher;
import com.project.SpringDC.service.SService;
import com.project.SpringDC.service.TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    public String message() {
        return "GG";
    }

    @PostMapping("/{s_id}/{t_id}")
    public ResponseEntity<String> save(@PathVariable(name = "s_id") Integer s_id,
                                       @PathVariable(name = "t_id") Integer t_id) {
        Optional<Student> studentOpt = sService.findById(s_id);
        Optional<Teacher> teacherOpt = tService.findById(t_id);

        if (!studentOpt.isPresent() || !teacherOpt.isPresent()) {
            return ResponseEntity.badRequest().body("Either student or teacher doesn't exist.");
        }

        Student student = studentOpt.get();
        Teacher teacher = teacherOpt.get();

        Set<Teacher> teachers = student.getTeachers();
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
            student.setTeachers(teachers);
            sService.save(student);
            return ResponseEntity.ok().body("Association successfully created.");
        } else {
            return ResponseEntity.badRequest().body("Association already exists.");
        }
    }
}

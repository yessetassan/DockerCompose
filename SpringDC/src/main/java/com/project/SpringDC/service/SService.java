package com.project.SpringDC.service;


import com.project.SpringDC.entity.Student;
import com.project.SpringDC.repo.SRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SService {

    private final SRepo sRepo;

    @Autowired
    public SService(SRepo sRepo) {
        this.sRepo = sRepo;
    }

    public List<Student> all() {
        return sRepo.findAll();
    }

    public Optional<Student> findById(Integer id) {
        return sRepo.findById(id);
    }

    public void save(Student student) {
        sRepo.save(student);
    }

    public void delete(Integer id) {
        sRepo.deleteById(id);
    }
}

package com.project.SpringDC.service;

import com.project.SpringDC.entity.Student;
import com.project.SpringDC.entity.Teacher;
import com.project.SpringDC.repo.TRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TService {

    private final TRepo tRepo;

    @Autowired
    public TService(TRepo tRepo) {
        this.tRepo = tRepo;
    }

    public List<Teacher> all() {
        return tRepo.findAll();
    }

    public Optional<Teacher> findById(Integer id) {
        return tRepo.findById(id);
    }

    public void save(Teacher teacher) {
        tRepo.save(teacher);
    }

    public void delete(Integer id) {
        tRepo.deleteById(id);
    }
}


package com.example.example_soap.services;

import com.example.example_soap.entities.StudentEntity;
import com.example.example_soap.repositories.StudentRepository;
import com.example.example_soap.soap.students.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public static final Function<StudentEntity, Student> functionEntityToSoap = se -> {
        Student s = new Student();
        s.setId(se.getId());
        s.setName(se.getName());
        s.setAge(se.getAge());
        s.setGroupTitle(se.getGroup().getTitle());
        return s;
    };

    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public Student getByName(String name) {
        return studentRepository.findByName(name).map(functionEntityToSoap).get();
    }
}

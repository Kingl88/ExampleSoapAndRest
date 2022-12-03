package com.example.example_soap.rest.services;

import com.example.example_soap.entities.StudentEntity;
import com.example.example_soap.repositories.StudentRepository;
import com.example.example_soap.rest.dto.StudentEntityDto;
import com.example.example_soap.rest.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceRest {
    private final StudentMapper mapper;
    private final StudentRepository studentRepository;



    public StudentEntityDto findStudentByName(String name){
        return mapper.mapToDto(studentRepository.findByName(name).get());
    }

    public List<StudentEntityDto> findAllStudents(){
        return studentRepository.findAll().stream().map(mapper::mapToDto).collect(Collectors.toList());
    }
}

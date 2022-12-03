package ru.example.example_soap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.example.example_soap.entities.StudentEntity;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query("select s from StudentEntity s where s.name = ?1")
    Optional<StudentEntity> findByName(String name);
}

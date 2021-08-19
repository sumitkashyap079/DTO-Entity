package com.dtotoentity.DTOENTITY.controller;

import com.dtotoentity.DTOENTITY.converter.StudentConverter;
import com.dtotoentity.DTOENTITY.dto.StudentDto;
import com.dtotoentity.DTOENTITY.entity.Student;
import com.dtotoentity.DTOENTITY.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired StudentRepo studentRepo;
    @Autowired StudentConverter converter;

    @GetMapping("/findAll")
   // public List<Student> FindAll(){
    public List<StudentDto> findAll() {
        List<Student> findAll = studentRepo.findAll();
        return converter.entityToDto(findAll);
        //return findAll;
    }
    @GetMapping("/findAll2")
    public List<Student> findsAll(){
        List<Student> findAll= studentRepo.findAll();
        return findsAll();
    }



    @GetMapping("/find/{ID}")
    public StudentDto findById(@PathVariable(value = "ID") int id) {
        Student orElse = studentRepo.findById(id).orElse(null);
        return converter.entityToDto(orElse);

    }

    @PostMapping("/save")
    public StudentDto save(@RequestBody StudentDto dto) {

        Student student = converter.dtoToEntity(dto);
        student=  studentRepo.save(student);
        return converter.entityToDto(student);
    }

}

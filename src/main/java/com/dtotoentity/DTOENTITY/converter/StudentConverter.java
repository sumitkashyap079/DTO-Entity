package com.dtotoentity.DTOENTITY.converter;

import com.dtotoentity.DTOENTITY.dto.StudentDto;
import com.dtotoentity.DTOENTITY.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component  //meaning outside of Spring auto-detection or dependency injection.
public class StudentConverter {

    public StudentDto entityToDto(Student student) {

		StudentDto dto = new StudentDto();
		dto.setId(student.getId());
		dto.setName(student.getName());
		dto.setUsername(student.getUsername());
		dto.setPassword(student.getPassword());
        dto.setLastname("hii sumit");

        return dto;


        }
        public List<StudentDto> entityToDto(List<Student> student) {

            return	student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

        }


        public Student dtoToEntity(StudentDto dto)
        {
		Student st = new Student();
		st.setId(dto.getId());
		st.setName(dto.getName());
		st.setPassword(dto.getPassword());
		st.setUsername(dto.getUsername());
		st.setRollnumber("12345");

		return st;


        }

        public List<Student> dtoToEntity(List<StudentDto> dto)
        {

            return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
        }

    }



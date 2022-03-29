package com.example.SQLInjectionDemo.model;
import java.util.List;

import org.springframework.ui.Model;
import com.example.SQLInjectionDemo.model.*;
public interface IStudentDAO {
    public List < Student > getStudents();

    public List < Student > getStudentById(String id);

    public int updateStudent(Student student);

    public int addStudent(Student student);

    public int deleteStudent(int id);
}

package ru.hogwarts.school.service;


import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import java.util.Collection;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent (Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent (Long studentId) {return studentRepository.findById(studentId).get();
    }

    public Student changeStudent (Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent (Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Collection <Student> showStudentByAge (int age) {
        return studentRepository.findByAge(age);
    }
}

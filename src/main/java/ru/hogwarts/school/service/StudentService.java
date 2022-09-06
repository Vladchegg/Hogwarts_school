package ru.hogwarts.school.service;


import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private final HashMap <Long, Student> students = new HashMap<> ();
    private long generateId = 0;

    public Student createStudent (Student student) {
        student.setId(generateId++);
        students.put(student.getId(), student);
        return student;
    }

    public Student getStudent (Long studentId) {
        return students.get(studentId);
    }

    public Student changeStudent (Long studentId, Student student) {
        if (!students.containsKey(studentId)) {
            return null;
        }
        students.put(studentId, student);
        return student;
    }

    public Student deleteStudent (Long studentId) {
        return students.remove(studentId);
    }

    public Collection <Student> showStudentByAge (int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
}

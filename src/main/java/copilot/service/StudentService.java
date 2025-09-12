package copilot.service;

import copilot.model.Student;
import org.springframework.stereotype.Service;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final Map<Integer, Student> studentRepo = new HashMap<>();

    public Student createStudent(Student student) {
        logger.info("Creating student with id: {}", student.getId());
        studentRepo.put(student.getId(), student);
        return student;
    }

    public Student updateStudent(int id, Student student) {
        logger.info("Updating student with id: {}", id);
        studentRepo.put(id, student);
        return student;
    }

    public void deleteStudent(int id) {
        logger.info("Deleting student with id: {}", id);
        studentRepo.remove(id);
    }

    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return new ArrayList<>(studentRepo.values());
    }

    public Student getStudentById(int id) {
        logger.info("Fetching student with id: {}", id);
        return studentRepo.get(id);
    }

    public double getStudentPercentage(int id) {
        logger.info("Calculating percentage for student with id: {}", id);
        Student student = studentRepo.get(id);
        if (student == null) {
            logger.error("Student not found with id: {}", id);
            throw new NoSuchElementException("Student not found");
        }
        return student.calculatePercentage();
    }
}

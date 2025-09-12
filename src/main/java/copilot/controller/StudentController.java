package copilot.controller;

import copilot.model.Student;
import copilot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        logger.info("Creating student with id: {}", student.getId());
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        logger.info("Updating student with id: {}", id);
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        logger.info("Deleting student with id: {}", id);
        studentService.deleteStudent(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        logger.info("Fetching student with id: {}", id);
        return studentService.getStudentById(id);
    }
}

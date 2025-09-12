package copilot.service;

import copilot.model.Student;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import java.util.*;

class StudentServiceTest {
    private StudentService studentService;
    private Student student;

    @BeforeEach
    void setup() {
        studentService = new StudentService();
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Math", 90);
        marks.put("Science", 80);
        student = new Student(1, "John Doe", marks);
    }

    @Test
    void createStudent_should_add_student_to_repo() {
        Student created = studentService.createStudent(student);
        assertThat(created).isEqualTo(student);
        assertThat(studentService.getStudentById(1)).isEqualTo(student);
    }

    @Test
    void updateStudent_should_update_existing_student() {
        studentService.createStudent(student);
        Student updated = new Student(1, "Jane Doe", Map.of("Math", 95, "Science", 85));
        Student result = studentService.updateStudent(1, updated);
        assertThat(result).isEqualTo(updated);
        assertThat(studentService.getStudentById(1)).isEqualTo(updated);
    }

    @Test
    void deleteStudent_should_remove_student() {
        studentService.createStudent(student);
        studentService.deleteStudent(1);
        assertThat(studentService.getStudentById(1)).isNull();
    }

    @Test
    void getAllStudents_should_return_all_students() {
        studentService.createStudent(student);
        Student student2 = new Student(2, "Jane Doe", Map.of("Math", 70));
        studentService.createStudent(student2);
        List<Student> students = studentService.getAllStudents();
        assertThat(students).containsExactlyInAnyOrder(student, student2);
    }

    @Test
    void getStudentById_should_return_student_if_exists() {
        studentService.createStudent(student);
        assertThat(studentService.getStudentById(1)).isEqualTo(student);
    }

    @Test
    void getStudentById_should_return_null_if_not_exists() {
        assertThat(studentService.getStudentById(99)).isNull();
    }

    @Test
    void getStudentPercentage_should_return_percentage_for_existing_student() {
        studentService.createStudent(student);
        double percentage = studentService.getStudentPercentage(1);
        assertThat(percentage).isEqualTo((90 + 80) * 100.0 / 200);
    }

    @Test
    void getStudentPercentage_should_throw_for_missing_student() {
        assertThatThrownBy(() -> studentService.getStudentPercentage(99))
            .isInstanceOf(NoSuchElementException.class)
            .hasMessageContaining("Student not found");
    }
}


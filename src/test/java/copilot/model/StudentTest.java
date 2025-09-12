package copilot.model;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import java.util.*;

class StudentTest {
    @Test
    void constructor_and_getters_should_return_correct_values() {
        Map<String, Integer> marks = Map.of("Math", 90, "Science", 80);
        Student student = new Student(1, "John Doe", marks);
        assertThat(student.getId()).isEqualTo(1);
        assertThat(student.getName()).isEqualTo("John Doe");
        assertThat(student.getSubjectMarks()).isEqualTo(marks);
    }

    @Test
    void setters_should_update_values() {
        Student student = new Student(0, null, null);
        student.setId(2);
        student.setName("Jane Doe");
        Map<String, Integer> marks = Map.of("English", 75);
        student.setSubjectMarks(marks);
        assertThat(student.getId()).isEqualTo(2);
        assertThat(student.getName()).isEqualTo("Jane Doe");
        assertThat(student.getSubjectMarks()).isEqualTo(marks);
    }

    @Test
    void calculatePercentage_should_return_zero_if_no_subjects() {
        Student student = new Student(1, "John Doe", null);
        assertThat(student.calculatePercentage()).isEqualTo(0.0);
        student.setSubjectMarks(Collections.emptyMap());
        assertThat(student.calculatePercentage()).isEqualTo(0.0);
    }

    @Test
    void calculatePercentage_should_return_correct_percentage() {
        Map<String, Integer> marks = Map.of("Math", 80, "Science", 70);
        Student student = new Student(1, "John Doe", marks);
        double expected = (80 + 70) * 100.0 / 200;
        assertThat(student.calculatePercentage()).isEqualTo(expected);
    }

    @Test
    void calculatePercentage_should_handle_single_subject() {
        Map<String, Integer> marks = Map.of("Math", 100);
        Student student = new Student(1, "John Doe", marks);
        assertThat(student.calculatePercentage()).isEqualTo(100.0);
    }
}


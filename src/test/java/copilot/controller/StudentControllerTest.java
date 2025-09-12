package copilot.controller;

import copilot.model.Student;
import copilot.service.StudentService;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;

class StudentControllerTest {
    @Mock private StudentService studentService;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private Student student;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        StudentController controller = new StudentController(studentService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Math", 90);
        marks.put("Science", 80);
        student = new Student(1, "John Doe", marks);
    }

    @Test
    void createStudent_should_return_created_student() throws Exception {
        when(studentService.createStudent(any())).thenReturn(student);
        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    void updateStudent_should_return_updated_student() throws Exception {
        when(studentService.updateStudent(eq(1), any())).thenReturn(student);
        mockMvc.perform(put("/students/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void deleteStudent_should_return_ok() throws Exception {
        doNothing().when(studentService).deleteStudent(1);
        mockMvc.perform(delete("/students/1"))
            .andExpect(status().isOk());
    }

    @Test
    void getAllStudents_should_return_list_of_students() throws Exception {
        when(studentService.getAllStudents()).thenReturn(List.of(student));
        mockMvc.perform(get("/students"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    void getStudent_should_return_student() throws Exception {
        when(studentService.getStudentById(1)).thenReturn(student);
        mockMvc.perform(get("/students/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void getStudent_should_return_null_for_missing_student() throws Exception {
        when(studentService.getStudentById(99)).thenReturn(null);
        mockMvc.perform(get("/students/99"))
            .andExpect(status().isOk())
            .andExpect(content().string(""));
    }
}


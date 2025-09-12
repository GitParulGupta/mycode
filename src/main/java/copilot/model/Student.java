package copilot.model;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//A well-designed Student class with id, name, subjectMarks, constructor, getters/setters, and a method to calculate percentage marks in different subjects
public class Student{
    private static final Logger logger = LoggerFactory.getLogger(Student.class);
    private int id;
    private String name;
    private Map<String, Integer> subjectMarks;

    public Student(int id, String name, Map<String, Integer> subjectMarks) {
        this.id = id;
        this.name = name;
        this.subjectMarks = subjectMarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(Map<String, Integer> subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    /**
     * Calculates the percentage marks across all subjects.
     * Assumes each subject is out of 100 marks.
     * @return percentage marks (0-100)
     */
    public double calculatePercentage() {
        logger.info("Calculating percentage for student: {}", this.id);
        if (subjectMarks == null || subjectMarks.isEmpty()) {
            logger.warn("No subject marks found for student: {}", this.id);
            return 0.0;
        }
        int totalMarks = 0;
        for (int marks : subjectMarks.values()) {
            totalMarks += marks;
        }
        int numberOfSubjects = subjectMarks.size();
        int maxTotal = numberOfSubjects * 100;
        double percentage = (totalMarks * 100.0) / maxTotal;
        logger.info("Student: {} has percentage: {}", this.id, percentage);
        return percentage;
    }
}

package Question2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentsManager {

    private Map<String, Student> studentsMap = new HashMap<String, Student>();

    public String addStudent(Student student) {
        String id = student.getId();
        Student s = studentsMap.get(id);
        if (s == null) {
            studentsMap.put(student.getId(), student);

            return "Student successfully added!";
        } else {
            return "Student with id -> " + id + " is already present!";
        }
    }

    public int getStudentCount() {
        return studentsMap.size();
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<Student>(studentsMap.values());
    }
}

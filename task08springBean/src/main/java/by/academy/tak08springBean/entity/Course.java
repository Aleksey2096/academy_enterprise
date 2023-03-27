package by.academy.tak08springBean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Course {
    private String title;
    private List<Student> students;

    public void printStudents() {
        students.forEach(
                x -> System.out.println(x.getSurname() + " " + x.getName()));
    }
}

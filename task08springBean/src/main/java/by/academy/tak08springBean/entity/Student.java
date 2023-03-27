package by.academy.tak08springBean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private Course course;
    private Double gradePointAverage;
    private List<String> subjects;

    @Override
    public int compareTo(final Student o) {
        return Double.compare(getGradePointAverage(), o.getGradePointAverage());
    }
}

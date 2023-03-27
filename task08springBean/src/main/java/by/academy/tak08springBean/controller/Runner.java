package by.academy.tak08springBean.controller;

import by.academy.tak08springBean.entity.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class Runner {
    public static final String SPRING_CONFIG_XML = "SpringConfig.xml";
    public static final String GPA_LESS_THAN_5_COURSE = "gpaLessThan5Course";
    public static final String GPA_GREATER_THAN_5_COURSE
            = "gpaGreaterThan5Course";
    public static final String MIN_GPA_COURSE = "minGpaCourse";
    public static final String MAX_GPA_COURSE = "maxGpaCourse";

    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext(SPRING_CONFIG_XML);
        Course gpaLessThan5Course = context.getBean(GPA_LESS_THAN_5_COURSE,
                Course.class);
        gpaLessThan5Course.printStudents();
        Course gpaGreaterThan5Course = context.getBean(
                GPA_GREATER_THAN_5_COURSE,
                Course.class);
        gpaGreaterThan5Course.printStudents();
        Course minGpaCourse = context.getBean(MIN_GPA_COURSE, Course.class);
        minGpaCourse.printStudents();
        Course maxGpaCourse = context.getBean(MAX_GPA_COURSE, Course.class);
        maxGpaCourse.printStudents();
    }
}

package by.academy;

import by.academy.dao.DAO;
import by.academy.dao.impl.*;
import by.academy.entity.*;
import by.academy.util.HibernateUtil;
import jakarta.persistence.EntityManager;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
//        EntityManager entityManager = HibernateUtil.getEntityManager();

        DAO<Administrator> adminDAO = new AdministratorDAOImpl();
        DAO<Assignment> assignmentDAO = new AssignmentDAOImpl();
        DAO<Course> courseDAO = new CourseDAOImpl();
        DAO<Student> studentDAO = new StudentDAOImpl();
        DAO<Teacher> teacherDAO = new TeacherDAOImpl();

        // create entities
        Administrator administrator = Administrator.builder()
                .id(11)
                .courses(null)
                .teachers(null)
                .build();
        Student student = Student.builder()
                .id(11)
                .courses(null)
                .assignments(null)
                .build();
        Teacher teacher = Teacher.builder()
                .id(11)
                .administrator(administrator)
                .build();
        Assignment assignment = Assignment.builder()
                .id(11)
                .mark(10)
                .review("Excellent job")
                .students(null)
                .build();
        Course course = Course.builder()
                .id(11)
                .administrator(administrator)
                .students(null)
                .build();
        Administrator administrator1 = new Administrator(12, null, null);
        Student student1 = new Student(12, null, null);
        Teacher teacher1 = new Teacher(12, administrator1);
        Assignment assignment1 = new Assignment(12, 8, "good", null);
        Course course1 = new Course(12, administrator1, null);

        // fulfil collections
        Set<Course> courses = new HashSet<>();
        Set<Teacher> teachers = new HashSet<>();
        Set<Assignment> assignments = new HashSet<>();
        Set<Student> students = new HashSet<>();
        courses.add(course);
        courses.add(course1);
        administrator.setCourses(courses);
        administrator1.setCourses(courses);
        student.setCourses(courses);
        student1.setCourses(courses);

        teachers.add(teacher);
        teachers.add(teacher1);
        administrator.setTeachers(teachers);
        administrator1.setTeachers(teachers);

        assignments.add(assignment);
        assignments.add(assignment1);
        student.setAssignments(assignments);
        student1.setAssignments(assignments);

        students.add(student);
        students.add(student1);
        assignment.setStudents(students);
        assignment1.setStudents(students);
        course.setStudents(students);
        course1.setStudents(students);

//        // create
        adminDAO.create(administrator);
        adminDAO.create(administrator1);
        assignmentDAO.create(assignment);
        assignmentDAO.create(assignment1);
        courseDAO.create(course);
        courseDAO.create(course1);
        studentDAO.create(student);
        studentDAO.create(student1);
        teacherDAO.create(teacher);
        teacherDAO.create(teacher1);
//
//
//        // read
        System.out.println(adminDAO.read());
        System.out.println(assignmentDAO.read());
        System.out.println(courseDAO.read());
        System.out.println(studentDAO.read());
        System.out.println(teacherDAO.read());
        System.out.println(assignmentDAO.selectById(3));
//
//        // update
        assignmentDAO.update(new Assignment(2, 3, "bad", students));
//
//        // delete
        assignmentDAO.delete(2);

//        entityManager.getTransaction().begin();
//        entityManager.persist(administrator);
//        entityManager.persist(administrator1);
//        entityManager.persist(assignment);
//        entityManager.persist(assignment1);
//        entityManager.persist(course);
//        entityManager.persist(course1);
//        entityManager.persist(student);
//        entityManager.persist(student1);
//        entityManager.persist(teacher);
//        entityManager.persist(teacher1);
//        entityManager.getTransaction().commit();

        HibernateUtil.close();
    }
}

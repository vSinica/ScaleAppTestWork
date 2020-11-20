package ru.vados.ScaleAppsTestwork.model;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer studentCount;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new LinkedList<>();

    public void addComment(Student student) {
        students.add(student);
        student.setGroup(this);
    }
    public void removeComment(Student student) {
        students.remove(student);
        student.setGroup(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

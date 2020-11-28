package ru.vados.ScaleAppTestWork.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupNumber;
//
//    private int studentCount;
//
//   /// private List<Student> students = new ArrayList<>();
//
////    public void addStudent(Student student) {
////        this.students.add(student);
////    }
////
////    public void reomoveStudent(Student student){
////        this.students.remove(student);
//    }

    public Group() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getGroupNumber() {
//        return groupNumber;
//    }
//
//    public void setGroupNumber(String groupNumber) {
//        this.groupNumber = groupNumber;
//    }
//
//    public int getStudentCount() {
//        return studentCount;
//    }
//
//    public void setStudentCount(int studentCount) {
//        this.studentCount = studentCount;
//    }


}

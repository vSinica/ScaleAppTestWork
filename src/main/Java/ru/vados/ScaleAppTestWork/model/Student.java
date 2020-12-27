package ru.vados.ScaleAppTestWork.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "students")
public class Student {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @JsonFormat(pattern="yyyy-MM-dd")
   private Date adoptionDate;

   public Date getAdoptionDate() {
      return adoptionDate;
   }

   public void setAdoptionDate(Date adoptionDate) {
      this.adoptionDate = adoptionDate;
   }

   public Group getGroup() {
      return group;
   }

   public void setGroup(Group group) {
      this.group = group;
   }

   @ManyToOne(fetch = FetchType.EAGER)
   @OnDelete(action = OnDeleteAction.CASCADE)
   @JoinColumn(name = "group_id")
   @JsonBackReference
   private Group group;

   public Student() {
   }


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}

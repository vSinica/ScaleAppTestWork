package ru.vados.ScaleAppsTestwork.model;


import ru.vados.ScaleAppsTestwork.model.Group;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDate dataReceipt;

    @ManyToOne
    private Group group;


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

    public LocalDate getDataReceipt() {
        return dataReceipt;
    }

    public void setDataReceipt(LocalDate dataReceipt) {
        this.dataReceipt = dataReceipt;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

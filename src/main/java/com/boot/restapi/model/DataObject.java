package com.boot.restapi.model;

import javax.persistence.*;

/**
 * Created by Oleg on 20 Jul 2016.
 */

@Entity
@Table(name = "dataObject")
public class DataObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private long number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", number=" + number +
                '}';
    }
}

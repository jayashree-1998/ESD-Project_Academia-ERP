package com.erp.academia_3_4.bean;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

@Entity
@Table(name = "Course_Schedule")
public class Course_Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer schedule_id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private String room;

    @Column
    private String building;

    public Course_Schedule() {
    }

    public Integer getId() {
        return schedule_id;
    }

    public void setId(Integer id) {
        this.schedule_id = id;
    }
    @JsonbTransient
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}

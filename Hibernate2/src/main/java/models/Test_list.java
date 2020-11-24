package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test_list")
public class Test_list {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private User teacher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Test> testQuestions;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules;

    public Test_list(){
    }
    public Test_list(String name){
        this.name = name;
        this.testQuestions = new ArrayList<Test>();
        this.schedules = new ArrayList<Schedule>();
    }

    public int getRow_id() {
        return row_id;
    }

    public String getName() {
        return name;
    }

    public List<Test> getTestQuestions() {
        return testQuestions;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public Subject getSubject() {
        return subject;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTestQuestions(List<Test> testQuestions) {
        this.testQuestions = testQuestions;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Test_list{" +
                "row_id=" + row_id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", subject=" + subject +
                ", testQuestions=" + testQuestions +
                ", schedules=" + schedules +
                '}';
    }
}

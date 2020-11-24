package models;


import services.TestService;

import javax.persistence.*;

@Entity
@Table(name = "student_answer")
public class Student_answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test_list test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    public Student_answer(){}

    public Test_list getTest() {
        return test;
    }

    public int getRow_id() {
        return row_id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public User getUser() {
        return user;
    }

    public void setTest(Test_list test) {
        this.test = test;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Student_answer{" +
                "row_id=" + row_id +
                ", test=" + test +
                ", user=" + user +
                ", answer=" + answer +
                '}';
    }
}

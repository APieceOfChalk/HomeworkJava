import models.*;
import services.*;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        Test_listService testListService = new Test_listService();
        AnswerService answerService = new AnswerService();
        QuestionService questionService = new QuestionService();

        Role student = new Role("Student");
        Role teacher = new Role("Teacher");

        User student1 = new User("Layla", "Mamedova", "Ali-agaevna", "A Piece Of Chalk", "8888");
        student1.setRole(student);

        User teacher1 = new User("Daniil", "Milovanov", "Mihailovich", "DMMilovanov", "0000");
        teacher1.setRole(teacher);

        Test_list test1 = new Test_list("Python");
        Test_list test2 = new Test_list("Java");

        Question question1 = new Question("Q1", 1, true);
        Question question2 = new Question("Q2", 2, true);

        Answer answer1 = new Answer("A1", true);
        Answer answer2 = new Answer("A2", false);
        Answer answer3 = new Answer("A3", false);


        //

        testListService.saveTest_list(test1);
        testListService.saveTest_list(test2);

        questionService.saveQuestion(question1);
        questionService.saveQuestion(question2);

        answerService.saveAnswer(answer1);
        answerService.saveAnswer(answer2);
        answerService.saveAnswer(answer3);

        userService.saveUser(student1);
        userService.saveUser(teacher1);

        System.out.println(userService.getTeachers());
        System.out.println(userService.getStudents());

        // Student_answer studentAnswer = new Student_answer();
        // RoleService roleService = new RoleService();
        // GroupService groupService = new GroupService();
        // TestService testService = new TestService();
    }
}

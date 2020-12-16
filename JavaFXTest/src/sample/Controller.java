package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controller {

    @FXML
    private ToggleGroup answers;

    @FXML
    private Text question_text;

    @FXML
    private RadioButton radio_btn_1;

    @FXML
    private RadioButton radio_btn_2;

    @FXML
    private RadioButton radio_btn_3;

    @FXML
    private RadioButton radio_btn_4;

    @FXML
    private Button answerBtn;


    private Questions[] questions = new Questions[] {
            new Questions("Какое количество позвонков находится в шейном отделе позвоночника человека?", new String[] {"5 позвонков", "6 позвонков", "12 позвонков", "7 позвонков"}),
            new Questions("Большой круг кровообращения:", new String[] {"начинается в правом предсердии", "начинается в правом желудочке", "начинается в левом предсердии", "начинается в левом желудочке"}),
            new Questions("Внутри зуба находится соединительная ткань, пронизанная  нервами и кровеносными сосудами. Эта часть зуба называется:", new String[] {"дентин", "эмаль", "цемент", "пульпа"}),
            new Questions("Как называется задняя часть наружной оболочки глазного яблока?", new String[] {"радужка", "сетчатка", "роговица", "склера"}),
            new Questions("Какая структура глаза отвечает за процесс аккомодации глаза?", new String[] {"зрачок", "стекловидное тело", "роговица", "хрусталик"}),
            new Questions("Какие вещества пищи подвергаются обработке желчью в кишечнике человека благодаря печени?", new String[] {"белки", "аминокислоты", "углеводы", "жиры"})
    };

    private int nowQuestion = 0, correctAnswers;
    private String nowCorrectAnswer;

    @FXML
    public void initialize() {
        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

        answerBtn.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
            if(selectedRadioButton != null) {
                String toogleGroupValue = selectedRadioButton.getText();

                if(toogleGroupValue.equals(nowCorrectAnswer)) {
                    System.out.println("Верный ответ");
                    correctAnswers++;
                } else {
                    System.out.println("Не верный ответ");
                }

                // Это был последний вопрос
                if(nowQuestion + 1 == questions.length) {
                    radio_btn_1.setVisible(false);
                    radio_btn_2.setVisible(false);
                    radio_btn_3.setVisible(false);
                    radio_btn_4.setVisible(false);
                    answerBtn.setVisible(false);

                    question_text.setText("Вы ответили корректно на " + correctAnswers + " из " + questions.length + " вопросов!");
                } else {
                    nowQuestion++;
                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                    question_text.setText(questions[nowQuestion].getQuestion());
                    String[] answers = questions[nowQuestion].getAnswers();


                    List<String> intList = Arrays.asList(answers);

                    Collections.shuffle(intList);

                    radio_btn_1.setText(intList.get(0));
                    radio_btn_2.setText(intList.get(1));
                    radio_btn_3.setText(intList.get(2));
                    radio_btn_4.setText(intList.get(3));

                    selectedRadioButton.setSelected(false);
                }

            }
        });
    }

}

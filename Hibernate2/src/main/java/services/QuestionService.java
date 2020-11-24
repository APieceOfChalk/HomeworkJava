package services;

import dao.QuestionDao;
import models.Question;

public class QuestionService {
    private QuestionDao questionDao = new QuestionDao();

    public QuestionService(){}

    public void saveQuestion(Question Question){
        questionDao.save(Question);
    }

    public Question findQuestion(int id){
        return questionDao.findById(id);
    }
}

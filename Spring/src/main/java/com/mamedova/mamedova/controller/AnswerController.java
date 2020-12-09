package com.mamedova.mamedova.controller;

import com.mamedova.mamedova.model.Answer;
import org.springframework.web.bind.annotation.RestController;
import com.mamedova.mamedova.exception.ResourceNotFoundException;
import com.mamedova.mamedova.repository.AnswerRepository;
import com.mamedova.mamedova.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions/{questionId}/answers")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long questionId){
        return answerRepository.findByQuestionId(questionId);
    }
    @PostMapping("/questions/{questionId}/answers")
    public Answer addAnswer(@PathVariable Long questionId, @Valid @RequestBody Answer answer){
        return questionRepository.findById(questionId)
                .map(question -> {
                    answer.setQuestion(question);
                    return answerRepository.save(answer);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with Id"+questionId));
    }

    @PutMapping("/questions/{questionId}/answers/{answerId}")
    public Answer updateAnswer(@PathVariable Long questionId,@PathVariable Long answerId, @Valid @RequestBody Answer answerRequest) {
        if (!questionRepository.existsById(questionId)) {
            throw new ResourceNotFoundException("Question not found with id " + questionId);
        }
        return answerRepository.findById(answerId)
                .map(answer -> {
                    answer.setText(answerRequest.getText());
                    return answerRepository.save(answer);
                }).orElseThrow(() -> new ResourceNotFoundException("Answer not found with Id"+answerId));

    }
    @DeleteMapping("/questions/{questionId}/answers/{answerId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId, @PathVariable Long answerId){
        if (!questionRepository.existsById(questionId)){
            throw new ResourceNotFoundException("Question not found wigh Id"+questionId);
        }
        return answerRepository.findById(answerId)
                .map(answer ->{
                    answerRepository.delete(answer);
                    return ResponseEntity.ok().build();

                }).orElseThrow(() -> new ResourceNotFoundException("Answer not found with Id" + answerId));
    }
}

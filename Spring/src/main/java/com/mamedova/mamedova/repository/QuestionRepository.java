package com.mamedova.mamedova.repository;

import com.mamedova.mamedova.model.Answer;
import com.mamedova.mamedova.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Answer> findByQuestionId(Long questionId);
}

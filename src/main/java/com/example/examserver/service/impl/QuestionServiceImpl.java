package com.example.examserver.service.impl;

import com.example.examserver.model.exam.BulkQuestionRequest;
import com.example.examserver.model.exam.Category;
import com.example.examserver.model.exam.Question;
import com.example.examserver.model.exam.Quiz;
import com.example.examserver.repository.QuestionRepository;
import com.example.examserver.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Question question = new Question();
        question.setQuesId(questionId);
        this.questionRepository.delete(question);
    }


    // add bulk questions
//    @Override
//    public Set<BulkQuestionRequest> addQuestions(BulkQuestionRequest bulkQuestionRequest) {
//
//        bulkQuestionRequest.getQuestions().forEach(eac
//        });
////
////        List<Category> categoryList = new ArrayList<>();
////
////        bulkCategoryRequest.getCategories().forEach(each ->{
////            Category category = new Category();
////            category.setTitle(each.getTitle());
////            category.setDescription(each.getDescription());
////
////            categoryList.add(category);
////        });
////        return this.categoryRepository.saveAll(categoryList);
//        return null;
//    }
}

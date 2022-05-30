package com.example.examserver.Controller;

import com.example.examserver.model.exam.BulkCategoryRequest;
import com.example.examserver.model.exam.Quiz;
import com.example.examserver.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    //add quiz service
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get Quizzes
    @GetMapping("/")
    public ResponseEntity<?> getQuizzes()
    {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    // get Quiz
    @GetMapping("/{qId}")
    public Quiz quiz(@PathVariable("qId") Long qId) {
        return this.quizService.getQuiz(qId);
    }

    //delete quiz
    @DeleteMapping("/{qId}")
    public void deleteQuiz(@PathVariable("qId") Long qId)
    {
        this.quizService.deleteQuiz(qId);
    }


}

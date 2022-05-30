package com.example.examserver.model.exam;

import java.util.List;
import java.util.Set;

public class BulkQuestionRequest {
    private Set<Question> Questions;

    public Set<Question> getQuestions() {
        return Questions;
    }

    public void setQuestions(Set<Question> questions) {
        Questions = questions;
    }
}

package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;
import com.crio.codingame.services.IQuestionService;

public class CreateQuestionCommand implements ICommand{

    private final IQuestionService questionService;
    
    public CreateQuestionCommand(IQuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public void execute(List<String> tokens) {
        String title = tokens.get(1);
        Level level = Level.valueOf(tokens.get(2));
        Integer score = Integer.valueOf(tokens.get(3));
        Question question = questionService.create(title, level, score);
        System.out.println(question);
    }
    
}

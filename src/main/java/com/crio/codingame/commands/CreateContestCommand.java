package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.services.IContestService;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }


    @Override
    public void execute(List<String> tokens) {
        String contestName = tokens.get(1);
        Level level = Level.valueOf(tokens.get(2));
        String creator = tokens.get(3);
        Integer numQuestion;
        if(tokens.size() == 4) {
            numQuestion = null;
        }
        else {
            numQuestion = Integer.valueOf(tokens.get(4));
        }
        
        Contest contest; 
        try {
            contest = contestService.create(contestName, level, creator, numQuestion);
            System.out.println(contest);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}

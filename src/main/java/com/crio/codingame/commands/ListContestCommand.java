package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.services.IContestService;

public class ListContestCommand implements ICommand{

    private final IContestService contestService;
    
    public ListContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }


    @Override
    public void execute(List<String> tokens) {
        Level level;
        if(tokens.size() == 1) {
            level = null;
        }
        else {
            level = Level.valueOf(tokens.get(1));
        }
        
        List<Contest> contestList = contestService.getAllContestLevelWise(level);
        System.out.println(contestList);
    }
    
}

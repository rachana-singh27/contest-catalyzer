package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.User;
import com.crio.codingame.services.IUserService;

public class CreateUserCommand implements ICommand{

    private final IUserService userService;
    
    public CreateUserCommand(IUserService userService) {
        this.userService = userService;
    }

    
    @Override
    public void execute(List<String> tokens) {
        User user = userService.create(tokens.get(1));
        System.out.println(user);
    }
    
}

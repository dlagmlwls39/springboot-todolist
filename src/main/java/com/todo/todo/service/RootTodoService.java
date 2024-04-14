package com.todo.todo.service;

import com.todo.todo.repository.RootTodoRepository;
import org.springframework.stereotype.Service;

@Service
public class RootTodoService {

    private final RootTodoRepository rootTodoRepository;

    public RootTodoService(RootTodoRepository rootTodoRepository) {
        this.rootTodoRepository = rootTodoRepository;
    }

}

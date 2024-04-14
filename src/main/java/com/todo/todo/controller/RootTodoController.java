package com.todo.todo.controller;

import com.todo.todo.service.RootTodoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/newTodo/*")
public class RootTodoController {

    private final RootTodoService rootTodoService;

    public RootTodoController(RootTodoService rootTodoService) {
        this.rootTodoService = rootTodoService;
    }
}

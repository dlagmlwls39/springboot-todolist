package com.todo.todo.controller;

import com.todo.todo.dto.RootTodoDto;
import com.todo.todo.entity.RootTodo;
import com.todo.todo.service.RootTodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rootTodo/*")
public class RootTodoController {

    private final RootTodoService rootTodoService;

    public RootTodoController(RootTodoService rootTodoService) {
        this.rootTodoService = rootTodoService;
    }

    /**
     * 새로운 RootTodo 생성
     */
    @PostMapping("create")
    public @ResponseBody ResponseEntity createRootTodo(@RequestBody RootTodoDto rootTodoDto) throws Exception {
        RootTodo results = rootTodoService.createRootTodo(rootTodoDto);
        return new ResponseEntity<>(results != null ? "success" : "fail", HttpStatus.OK);
    }

    /**
     * RootTodo 목록 조회
     */
    @GetMapping("get")
    public @ResponseBody ResponseEntity getRootTodo(Long userId) throws Exception {
        List<RootTodoDto> rootTodoList = rootTodoService.getRootTodo(userId);
        return new ResponseEntity<>(rootTodoList, HttpStatus.OK);
    }

    /**
     * RootTodo 수정
     */
    @PutMapping("update")
    public @ResponseBody ResponseEntity updateRootTodo(@RequestBody RootTodoDto rootTodoDto) throws Exception {
        RootTodo results = rootTodoService.updateRootTodo(rootTodoDto);
        return new ResponseEntity<>(results != null ? "success" : "fail", HttpStatus.OK);
    }

    /**
     * RootTodo 삭제
     */
    @DeleteMapping("delete")
    public @ResponseBody ResponseEntity deleteRootTodo(Long rootTodoId) throws Exception {
        rootTodoService.deleteRootTodo(rootTodoId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}

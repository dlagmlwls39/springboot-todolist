package com.todo.todo.repository;

import com.todo.todo.entity.RootTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RootTodoRepository extends JpaRepository<RootTodo, Long> {

    List<RootTodo> findByUserId(Long userId);

}

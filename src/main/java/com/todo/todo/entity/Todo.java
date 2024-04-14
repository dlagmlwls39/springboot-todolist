package com.todo.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@Entity
@Getter
@ToString
@Table(name = "users_todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long todoId;
    @Column(name = "root_todo_id")
    private Long rootTodoId;
    @Column(name = "todo_content")
    private String todoContent;
    @Column(name = "memo")
    private String memo;
    @Column(name = "deadline")
    private LocalDateTime deadline;
    @Column(name = "complete_yn")
    private int completeYn;
    @Column(name = "created_dt")
    private LocalDateTime createdDt;
    @Column(name = "updated_dt")
    private LocalDateTime updatedDt;
    @Column(name = "deleted_dt")
    private LocalDateTime deletedDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "root_todo_id", name = "root_todo_id", insertable = false, updatable = false)
    @JsonIgnore
    private RootTodo rootTodo;

}

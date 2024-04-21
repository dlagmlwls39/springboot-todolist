package com.todo.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.*;

@Entity
@Getter
@ToString
@SQLDelete(sql = "UPDATE users_todo SET deleted_dt = CURRENT_TIMESTAMP WHERE todo_id = ?")
@Where(clause = "deleted_dt is null")
@Table(name = "users_todo")
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    private Long rootTodoId;

    private String todoContent;

    private String memo;

    private LocalDateTime deadline;

    private int completeYn;

    private LocalDateTime deletedDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "rootTodoId", name = "rootTodoId", insertable = false, updatable = false)
    @JsonIgnore
    private RootTodo rootTodo;

}

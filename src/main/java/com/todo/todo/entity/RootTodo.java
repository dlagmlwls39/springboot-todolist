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
@SQLDelete(sql = "UPDATE users_root_todo SET deleted_dt = CURRENT_TIMESTAMP WHERE root_todo_id = ?")
@Where(clause = "deleted_dt is null")
@Table(name = "users_root_todo")
public class RootTodo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rootTodoId;

    private Long userId;

    private String todoContent;

    private int alarmYn;

    private LocalTime alarmTime;

    private int routineYn;

    private LocalDateTime deletedDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "userId", name = "userId", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    public RootTodo() {
    }

    @Builder
    public RootTodo(Long rootTodoId, Long userId, String todoContent, int alarmYn, LocalTime alarmTime, int routineYn) {
        this.rootTodoId = rootTodoId;
        this.userId = userId;
        this.todoContent = todoContent;
        this.alarmYn = alarmYn;
        this.alarmTime = alarmTime;
        this.routineYn = routineYn;
    }

    @Builder
    public RootTodo(Long userId, String todoContent, int alarmYn, LocalTime alarmTime, int routineYn) {
        this.userId = userId;
        this.todoContent = todoContent;
        this.alarmYn = alarmYn;
        this.alarmTime = alarmTime;
        this.routineYn = routineYn;
    }

}

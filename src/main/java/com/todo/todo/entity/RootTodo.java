package com.todo.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@Entity
@Getter
@ToString
@Table(name = "users_root_todo")
public class RootTodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "root_todo_id")
    private Long rootTodoId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "todo_content")
    private String todoContent;
    @Column(name = "alarm_yn")
    private int alarmYn;
    @Column(name = "alarm_time")
    private LocalTime alarmTime;
    @Column(name = "routine_yn")
    private int routineYn;
    @Column(name = "created_dt")
    private LocalDateTime createdDt;
    @Column(name = "updated_dt")
    private LocalDateTime updatedDt;
    @Column(name = "deleted_dt")
    private LocalDateTime deletedDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "user_id", name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

}

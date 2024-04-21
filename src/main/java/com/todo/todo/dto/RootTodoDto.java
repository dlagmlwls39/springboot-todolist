package com.todo.todo.dto;

import com.sun.istack.NotNull;
import com.todo.todo.entity.RootTodo;
import lombok.*;

import java.time.*;

@Setter
@Getter
public class RootTodoDto {

    @NotNull
    private Long rootTodoId;

    @NotNull
    private Long userId;

    @NotNull
    private String todoContent;

    @NotNull
    private int alarmYn;

    private LocalTime alarmTime;

    @NotNull
    private int routineYn;

    private LocalDateTime createdDt;

    private LocalDateTime updatedDt;

    private LocalDateTime deletedDt;

    public RootTodoDto(Long userId, String todoContent, int alarmYn, LocalTime alarmTime, int routineYn) {
        this.userId = userId;
        this.todoContent = todoContent;
        this.alarmYn = alarmYn;
        this.alarmTime = alarmTime;
        this.routineYn = routineYn;
    }

    public RootTodoDto(RootTodo rootTodo) {
        this.rootTodoId = rootTodo.getRootTodoId();
        this.userId = rootTodo.getUserId();
        this.todoContent = rootTodo.getTodoContent();
        this.alarmYn = rootTodo.getAlarmYn();
        this.alarmTime = rootTodo.getAlarmTime();
        this.routineYn = rootTodo.getRoutineYn();
    }

    public RootTodo toEntity() {
        return RootTodo.builder()
                .rootTodoId(rootTodoId)
                .userId(userId)
                .todoContent(todoContent)
                .alarmYn(alarmYn)
                .alarmTime(alarmTime)
                .routineYn(routineYn)
                .build();
    }
}

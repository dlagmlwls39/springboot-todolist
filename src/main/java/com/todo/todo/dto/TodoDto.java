package com.todo.todo.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.time.*;

@Setter
@Getter
public class TodoDto {

    @NotNull
    private Long todoId;

    @NotNull
    private Long rootTodoId;

    @NotNull
    private String todoContent;

    private String memo;

    private LocalDateTime deadline;

    @NotNull
    private int completeYn;

    private LocalDateTime createdDt;

    private LocalDateTime updatedDt;

    private LocalDateTime deletedDt;

}

package com.todo.todo.service;

import com.todo.todo.dto.RootTodoDto;
import com.todo.todo.entity.RootTodo;
import com.todo.todo.repository.RootTodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RootTodoService {

    private final RootTodoRepository rootTodoRepository;

    public RootTodoService(RootTodoRepository rootTodoRepository) {
        this.rootTodoRepository = rootTodoRepository;
    }

    /**
     * 새로운 RootTodo 생성
     */
    @Transactional
    public RootTodo createRootTodo(RootTodoDto rootTodoDto) throws Exception {
        RootTodo newRootTodo = RootTodo.builder()
                .userId(rootTodoDto.getUserId())
                .todoContent(rootTodoDto.getTodoContent())
                .alarmYn(rootTodoDto.getAlarmYn())
                .alarmTime(rootTodoDto.getAlarmTime())
                .routineYn(rootTodoDto.getRoutineYn())
                .build();
        return rootTodoRepository.save(newRootTodo);
    }

    /**
     * RootTodo 목록 조회
     */
    @Transactional
    public List<RootTodoDto> getRootTodo(Long userId) throws Exception {
        List<RootTodo> results = rootTodoRepository.findByUserId(userId);

        // 반복문
//        List<RootTodoDto> RootTodoDtoList = new ArrayList<>();
//        for (RootTodo rootTodo : results) {
//            RootTodoDto dto = new RootTodoDto(rootTodo);
//            RootTodoDtoList.add(dto);
//        }

        // 스트림
        List<RootTodoDto> RootTodoDtoList = results.stream()
                .map(RootTodoDto::new)
                .collect(Collectors.toList());

        return RootTodoDtoList;
    }

    /**
     * RootTodo 수정
     */
    @Transactional
    public RootTodo updateRootTodo(RootTodoDto rootTodoDto) throws Exception {
        RootTodo rootTodoEntity = rootTodoDto.toEntity();
        RootTodo rootTodo = rootTodoRepository.findById(rootTodoEntity.getRootTodoId()).orElse(null);

        // 기존 데이터가 있는 경우 갱신
        if (rootTodo != null) {
            return rootTodoRepository.save(rootTodoEntity);
        } else {
            return null;
        }
    }

    /**
     * RootTodo 삭제
     */
    @Transactional
    public void deleteRootTodo(Long rootTodoId) throws Exception {
        rootTodoRepository.deleteById(rootTodoId);
    }

}

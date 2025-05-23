package com.todoapp.service;

import com.todoapp.entity.Todo;
import com.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
    public Todo save(Todo todo){
        return todoRepository.save(todo);
    }
    public void deleteById(Long id){
        todoRepository.deleteById(id);
    }
    public Optional<Todo> findById(Long id){
        return todoRepository.findById(id);
    }
}

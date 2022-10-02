package com.example.demo.todo;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final ToDoRepository repository;

    @Autowired
    public TodoService(ToDoRepository repository) {
        this.repository = repository;
    }


    public List<Todo> getTodos() {
        return repository.findAll();
    }

    public void addNewTodo(Todo todo) {
        Optional<Todo> todoByDate = repository
                .findTodoByDate(todo.getDate());
        if(todoByDate.isPresent()){
            throw new IllegalStateException("At a time only one todo can be done, please select other date for this todo.");
        }
        /*if(todo.getDate()==null)
            todo.setDate(LocalDateTime.now());*/
        repository.save(todo);
    }
}

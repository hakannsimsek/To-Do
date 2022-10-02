package com.example.demo.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<Todo,Long> {

    //select * from todo where date = ?
    //@Query("Select s from ToDo Where s.date = ?")
    Optional<Todo> findTodoByDate(LocalDateTime date);

}

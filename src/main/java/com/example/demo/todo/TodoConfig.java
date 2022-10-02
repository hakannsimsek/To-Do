package com.example.demo.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class TodoConfig {

    @Bean
    CommandLineRunner commandLineRunner(ToDoRepository repository) {
        return args -> {
            Todo meeting = new Todo(
                    //id,title,content,date,remainintime,place
                "Meeting",
                "Task distribution",
                    "Hall",
                    LocalDateTime.of(2022, Month.NOVEMBER,1,12,00)
            );

            Todo appointment = new Todo(
                    //id,title,content,date,remainintime,place
                    "Appointment",
                    "Appointment with Jessica",
                    "Cafe Kadikoy",
                    LocalDateTime.of(2022, Month.NOVEMBER,1,19,00)
            );

            repository.saveAll(
                List.of(meeting,appointment)
            );
        };
    }
}

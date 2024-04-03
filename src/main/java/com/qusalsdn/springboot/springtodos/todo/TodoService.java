package com.qusalsdn.springboot.springtodos.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "qusalsdn", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "qusalsdn", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3, "qusalsdn", "Learn Full Stack Devlopment", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUserName(String userName) {
        return todos;
    }
}

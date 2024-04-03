package com.qusalsdn.springboot.springtodos.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todoCount = 1;

    static {
        todos.add(new Todo(todoCount++, "qusalsdn", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todoCount++, "qusalsdn", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(todoCount++, "qusalsdn", "Learn Full Stack Devlopment", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUserName(String userName) {
        return todos;
    }

    public void addTodo(String userName, String description, LocalDate targetDate, Boolean done) {
        todos.add(new Todo(todoCount++, userName, description, targetDate, done));
    }
}

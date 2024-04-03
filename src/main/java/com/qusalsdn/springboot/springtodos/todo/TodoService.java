package com.qusalsdn.springboot.springtodos.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {
    private static List<Todo> todos;

    static {
        todos.add(new Todo(1, "qusalsdn", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(1, "qusalsdn", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(1, "qusalsdn", "Learn Full Stack Devlopment", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUserName(String userName) {
        return todos;
    }
}

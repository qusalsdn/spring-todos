package com.qusalsdn.springboot.springtodos.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todoCount = 1;

    static {
        todos.add(new Todo(todoCount++, "qusalsdn", "Get AWS Certified", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todoCount++, "qusalsdn", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(todoCount++, "qusalsdn", "Learn Full Stack Devlopment", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUserName(String userName) {
        return todos;
    }

    public void addTodo(String userName, String description, LocalDate targetDate, Boolean done) {
        todos.add(new Todo(todoCount++, userName, description, targetDate, done));
    }

    public void deleteById(int id) {
        Predicate<Todo> predicate = todo -> todo.getId() == id; // Todo에 매칭되는 id가 있는지 묻는 predicate를 정의
        todos.removeIf(predicate); // removeIf는 위의 조건에 매칭되면 Todo를 삭제
    }

    public Todo findById(int id) {
        Predicate<Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}

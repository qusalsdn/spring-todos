package com.qusalsdn.springboot.springtodos;

import com.qusalsdn.springboot.springtodos.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUserName(String name);
}

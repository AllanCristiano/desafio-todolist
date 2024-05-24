package br.com.allancristiano.To_do.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allancristiano.To_do.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}

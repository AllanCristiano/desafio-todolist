package br.com.allancristiano.To_do.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todos_db")
public class Todo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    
    @NotBlank
    private String description;

    private boolean realizated;

    private int priority;

    

    
    
    public Todo(String name, String description, boolean realizated, int priority) {
        this.name = name;
        this.description = description;
        this.realizated = realizated;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRealizated() {
        return realizated;
    }

    public void setRealizated(boolean realizated) {
        this.realizated = realizated;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    

}

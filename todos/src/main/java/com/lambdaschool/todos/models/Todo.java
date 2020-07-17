package com.lambdaschool.todos.models;


import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo extends Auditable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,
        unique = true)
    private long todoid;

    @Column(nullable = false)
    String description;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;




}

package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "TodosService")
public class ToDosServiceImpl implements TodosService
{
    @Autowired
    TodosRepository todosrepo;

    @Override
    public void markComplete(long todoid)
    {
        Todo t = new Todo();
        t = todosrepo.findById(todoid)
                .orElseThrow(() -> new EntityNotFoundException("To Do Item " + todoid  + "Not Found!"));
        t.setCompleted(true);
    }


}

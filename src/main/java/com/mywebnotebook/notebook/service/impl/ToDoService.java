package com.mywebnotebook.notebook.service.impl;

import com.mywebnotebook.notebook.entity.ToDo;
import com.mywebnotebook.notebook.repository.ToDoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  ToDoService {

    @Autowired
    private ToDoRepository repository;


    public List<ToDo> listAll() {
        return repository.findAll();
    }

    public void save(ToDo toDo) {
        repository.save(toDo);
    }


    public ToDo get(long id) {
        return repository.findById(id).get();
    }


    public void delete(long id) {
        repository.deleteById(id);
    }
}

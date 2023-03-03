package com.mywebnotebook.notebook.controller;

import com.mywebnotebook.notebook.entity.ToDo;

import com.mywebnotebook.notebook.service.impl.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ToDoController {
    @Autowired
    private ToDoService service;

    public ToDoController(ToDoService service) {
    }


    @GetMapping("/admin/todo")
    public String viewHomePage(Model model) {
        List<ToDo> listToDo = service.listAll();
        model.addAttribute("listtodo", listToDo);
        System.out.print("Get / ");
        return "admin/todo";
    }

    @GetMapping("/admin/newtodo")
    public String add(Model model) {
        model.addAttribute("todo", new ToDo());
        return "admin/newtodo";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveToDo(@ModelAttribute("todo") ToDo toDo) {
        service.save(toDo);
        return "redirect:/admin/todo";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditToDo(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/newtodo");
        ToDo toDo= service.get(id);
        mav.addObject("todo", toDo);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteToDo(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/admin/todo";
    }
}


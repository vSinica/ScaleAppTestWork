package ru.vados.ScaleAppsTestwork.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.vados.ScaleAppsTestwork.model.GroupRepository;

@Controller
public class MainController {

    @Autowired
    private GroupRepository groupRepository;

}

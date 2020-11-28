package ru.vados.ScaleAppTestWork.controller;

import ru.vados.ScaleAppTestWork.model.Group;
import ru.vados.ScaleAppTestWork.model.Student;
import ru.vados.ScaleAppTestWork.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("/test")
    public String showAllUsers(Model model){
        ///Group group = new Group();
      /// group.setGroupNumber("55-77");
//        Student student = new Student();
//        student.setName("vadik");
//        student.setDateAdoption(new Date(2005,13,3));
//        group.addStudent(student);
       //// groupRepository.save(group);

        //model.addAttribute("allUsers", allUsers);
        return "index";
    }
//    @GetMapping("/show")
//    public String show(@RequestParam("id") int id, Model model) {
//        model.addAttribute("user", userRepository.findById((long) id));
//        return "show";
//    }
//    @GetMapping("/new")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        return "new";
//    }
//
//    @PostMapping
//    public String create(@ModelAttribute("user") User user) {
//        userRepository.save(user);
//        return "redirect:/";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        userRepository.deleteById(id);
//        return "redirect:/";
//    }
//
//    @PatchMapping("/edit/{id}")
//    public String update(@PathVariable("id") int id, Model model) {
//        Optional<User> user = userRepository.findById((long) id);
//        model.addAttribute("user", user);
//        return "new";
//    }
}

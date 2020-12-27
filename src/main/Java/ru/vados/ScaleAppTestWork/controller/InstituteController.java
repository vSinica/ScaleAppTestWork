package ru.vados.ScaleAppTestWork.controller;

import ru.vados.ScaleAppTestWork.model.Group;
import ru.vados.ScaleAppTestWork.model.Student;
import ru.vados.ScaleAppTestWork.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vados.ScaleAppTestWork.repository.StudentRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
public class InstituteController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/AllGroup")
    public String createNewGroup(@ModelAttribute("group")Group group){
        groupRepository.save(group);

        return "redirect:/AllGroup";
    }

    @PostMapping("/AllGroup/delete/{id}")
    public String deleteGroup(@PathVariable("id") String group_id){
        Group group = groupRepository.findByGroupNumber(group_id);

        List<Student> students = group.getAllStudent();

        for (Student student :students) {
            group.getAllStudent().remove(student);
            student.setGroup(null);
            studentRepository.delete(student);
        }
        groupRepository.delete(group);

        return "redirect:/AllGroup";
    }

    @GetMapping("/AllGroup")
    public String showAllGroup(Model model){
        List<Group> groups = (List<Group>) groupRepository.findAll();

        model.addAttribute("groups", groupRepository.findAll());
        return "showGroup";
    }

    @PostMapping("/showStudentInGroup/delete/{id}")
    private String deleteStudent(@PathVariable("id")Long studId,Model model){

        Optional<Student> student = studentRepository.findById(studId);

        Group group = student.get().getGroup();
        group.getAllStudent().remove(student.get());
        student.get().setGroup(null);

        studentRepository.delete(student.get());



        String group_id = group.getGroupNumber();
        model.addAttribute("groupNumber",group_id);

        return "redirect:/showStudentInGroup/"+group_id;

    }

    @PostMapping("/showStudentInGroup/{group_id}/add")
    private String addStudent(@ModelAttribute("name")Student student,
                              @PathVariable("group_id") String group_id){

        Group group = groupRepository.findByGroupNumber(group_id);

        java.sql.Date sqlDate = new java.sql.Date((new java.util.Date().getTime()));
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY");

        student.setAdoptionDate(sqlDate);

        group.addStudent(student);
        student.setGroup(group);
        groupRepository.save(group);

        return "redirect:/showStudentInGroup/"+group_id;
    }

    @GetMapping("/showStudentInGroup/{group_id}")
    public String showStudentInGroup(Model model,@PathVariable("group_id") String group_id) {

        Group group = groupRepository.findByGroupNumber(group_id);

        List<Student> students =group.getAllStudent();

        model.addAttribute("addUrl","/showStudentInGroup/"+group_id+"/add");

            for (Student stud:students) {
                System.out.println(" stud name "+stud.getName());
                System.out.println(" stud id "+stud.getId());
            }

        if(group.HasStudent()){
            students = group.getAllStudent();

            model.addAttribute("groupNumber",group_id);
            model.addAttribute("allStudents",students);
            return "showStudentInGroup";
        }
        else {
            model.addAttribute("groupNumber",group_id);
            return "showStudentInGroup";
        }

    }


}

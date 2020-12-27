package ru.vados.ScaleAppTestWork.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.vados.ScaleAppTestWork.model.Group;
import ru.vados.ScaleAppTestWork.model.Student;
import ru.vados.ScaleAppTestWork.repository.GroupRepository;
import ru.vados.ScaleAppTestWork.repository.StudentRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InstituteControllerRest {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentRepository studentRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/AllGroup")
    public ModelAndView showAllGroup(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showInstituteRest");
        return modelAndView;
    }

    @GetMapping("/GetAllGroup")
    public String getAllGroup() throws JsonProcessingException {
        return objectMapper.writeValueAsString(groupRepository.findAll());
    }

    @PostMapping("/DeleteGroup")
    @ResponseBody
    public void deleteGroup(@RequestBody Long groupid){
        System.out.println("groupnumber in delete group = "+groupid);
        Optional<Group> group = groupRepository.findById(groupid);


        List<Student> students = group.get().getAllStudent();

        for (Student student :students) {
            group.get().getAllStudent().remove(student);
            student.setGroup(null);
            studentRepository.delete(student);
        }
        groupRepository.delete(group.get());
    }

    @PostMapping("/AddGroup")
    @ResponseBody
    public void addGroup(@RequestBody String groupNumber){
        Group group = new Group();
        group.setGroupNumber(groupNumber);
        groupRepository.save(group);
    }

    @PostMapping("/ShowStudentInGroup")
    @ResponseBody
    public String showStudentInGroup(@RequestBody String groupId) throws JsonProcessingException {

        Group group = groupRepository.findByGroupNumber(groupId);

        List<Student> students =group.getAllStudent();

        return objectMapper.writeValueAsString(group.getAllStudent());
    }

    @PostMapping("/DeleteStudent")
    @ResponseBody
    private void deleteStudent(@RequestBody Long studId){
        Optional<Student> student = studentRepository.findById(studId);

        Group group = student.get().getGroup();
        group.getAllStudent().remove(student.get());
        student.get().setGroup(null);

        studentRepository.delete(student.get());
    }

    @PostMapping("/AddStudent")
    @ResponseBody
    private void addStudent(@RequestParam(value = "studName") String studName,@RequestParam(value = "currentGroupNumber") String currentGroupNumber){

        System.out.println(studName + "   " + currentGroupNumber);
    Group group = groupRepository.findByGroupNumber(currentGroupNumber);

    java.sql.Date sqlDate = new java.sql.Date((new java.util.Date().getTime()));
    DateFormat df = new SimpleDateFormat("dd/MM/YYYY");

    Student student = new Student();
    student.setName(studName);
    student.setAdoptionDate(sqlDate);

    group.addStudent(student);
    student.setGroup(group);
    groupRepository.save(group);

}

}

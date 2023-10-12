package com.example.blogspringapp.controller;

//import jakarta.transaction.Transactional;
import com.example.blogspringapp.entity.InputForm;
import com.example.blogspringapp.repository.InputFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private InputFormRepository inputFormRepo;


    @GetMapping("/")
    public String home(){
        return "HelloSpring";
    }

    @GetMapping("/inputForm")
    public String showForm(Model model) {
        model.addAttribute("inputForm", new InputForm());
        return "HomePage";
    }

    @PostMapping("/processForm")
//    @Transactional
    public String processForm(@ModelAttribute("inputForm") InputForm inputForm, Model model){
            String textInput =  inputForm.getTextInput();
            System.out.println(textInput);
            model.addAttribute("textInput",textInput);

            inputFormRepo.save(inputForm);
            return "SucessForm";
    }

    @GetMapping("/formData")
    public String getFormData(Model model) {
        List<InputForm> inputDataList = inputFormRepo.findAll();
        model.addAttribute("inputDataList", inputDataList);
        return "FormData";
    }

}

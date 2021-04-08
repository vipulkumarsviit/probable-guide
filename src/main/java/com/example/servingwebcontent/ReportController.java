package com.example.servingwebcontent;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
@Slf4j
public class ReportController {
    @GetMapping("/report")
    public String greetingForm(Model model) {
        model.addAttribute("report", new Intervalo());
        return "report";
    }


    @PostMapping("/report")
    public String greetingSubmit(@ModelAttribute("report") Intervalo intervalo, Model model) {
        System.out.println("Start date: " + intervalo.getStartDate());
        System.out.println("End date: " + intervalo.getEndDate());
        model.addAttribute("intervalo", intervalo);
        return "report";
    }
}




@Data
class Intervalo {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.time.LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.time.LocalDate endDate;
}
package com.example.demo.otc;

import com.example.demo.otc.models.CalculationForm;
import com.example.demo.otc.models.OilTonnage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicationController {

    private final  ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/calculate-tonnage")
    public String calculate(@ModelAttribute CalculationForm form, Model model) {
        applicationService.calculateTonnage(form.getVolume(), form.getDensity(), form.getTemperature());
        return "/";
    }

}



package com.example.demo.otc;

import com.example.demo.otc.models.CalculationForm;
import com.example.demo.otc.models.OilTonnage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ApplicationController {

    private final  ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/api/calculate")
    @ResponseBody
    public OilTonnage calculateAjax(@ModelAttribute CalculationForm form) {
        return applicationService.calculateTonnage(
                form.getVolume(),
                form.getDensity(),
                form.getTemperature()
        );
    }

    @PostMapping("/calculate")
    public String calculate_(@ModelAttribute CalculationForm form, Model model) {
        // Perform calculation and save
        OilTonnage result = applicationService.calculateTonnage(
                form.getVolume(),
                form.getDensity(),
                form.getTemperature()
        );

        // Add the result and updated history to model
        model.addAttribute("result", result);
        model.addAttribute("calculationForm", new CalculationForm()); // Reset form
        model.addAttribute("calculations", applicationService.getAllSavedTonnages());
        model.addAttribute("showResult", true);

        return "index";
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("calculationForm", new CalculationForm());
        model.addAttribute("calculations", applicationService.getAllSavedTonnages());
        return "index";
    }

    @GetMapping("/api/calculations")
    @ResponseBody
    public List<OilTonnage> getAllCalculations() {
        return (List<OilTonnage>) applicationService.getAllSavedTonnages();
    }

}



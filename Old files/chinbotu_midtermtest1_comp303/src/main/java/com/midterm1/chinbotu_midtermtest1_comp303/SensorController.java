package com.midterm1.chinbotu_midtermtest1_comp303;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/sensors")
public class SensorController {

    @Autowired
    private SensorRepository sensorRepository;

    @GetMapping
    public String showSensors(Model model) {
        model.addAttribute("sensors", sensorRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddSensorForm(Sensor sensor) {
        return "add-sensor";
    }

    @PostMapping("/add")
    public String addSensor(@Validated @ModelAttribute Sensor sensor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-sensor";
        }
        sensorRepository.save(sensor);
        return "redirect:/sensors";
    }

    @GetMapping("/edit/{id}")
    public String showEditSensorForm(@PathVariable("id") Long id, Model model) {
        Optional<Sensor> sensorOpt = sensorRepository.findById(id);
        if (sensorOpt.isPresent()) {
            model.addAttribute("sensor", sensorOpt.get());
            return "update-sensor";
        } else {
            return "redirect:/sensors"; // or handle not found
        }
    }

    @PostMapping("/update/{id}")
    public String updateSensor(@PathVariable("id") Long id, @Validated @ModelAttribute Sensor sensor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            sensor.setSensorID(id);
            return "update-sensor";
        }
        sensorRepository.save(sensor);
        return "redirect:/sensors";
    }

    @GetMapping("/delete/{id}")
    public String deleteSensor(@PathVariable("id") Long id) {
        sensorRepository.deleteById(id);
        return "redirect:/sensors";
    }
}
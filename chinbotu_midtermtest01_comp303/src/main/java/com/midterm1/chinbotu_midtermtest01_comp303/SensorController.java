package com.midterm1.chinbotu_midtermtest01_comp303;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// declare class as controller
@Controller
public class SensorController {

    // links to repository
    @Autowired
    private SensorRepository sensorRepository;

    // sets up landing page for sensors to the index html
    @GetMapping("/sensors")
    public String showSensors(Model model) {
        // creates a list of all sensors using the repository find all
        List<Sensor> sensors = (List<Sensor>) sensorRepository.findAll();
        model.addAttribute("sensors", sensors);
        // Show the list of sensors
        return "index";
    }

    // maps requests for add-sensor > takes user to the add-sensor html
    @GetMapping("/add-sensor")
    public String showAddSensorForm(Sensor sensor) {
        // Show form html to add a new sensor
        return "add-sensor";
    }

    // maps posts to add-sensor html
    @PostMapping("/add-sensor")
    public String addSensor(@Validated Sensor sensor, BindingResult result) {
        // if inputs fail the validation, then bounce the user back to the add-sensor html page
        if (result.hasErrors()) {
            return "add-sensor";
        }
        // if no failed validations, save the sensors to the database, then take user back to sensor (index)
        sensorRepository.save(sensor);
        return "redirect:/sensors";
    }

    // maps the edit sensor portion
    //get request from a placeholder id
    @GetMapping("/edit-sensor/{id}")
    //declares  update sensor method - use id as the parameter to search
    public String UpdateSensor(@PathVariable("id") int id, Model model) {
        //variable called sensor  to user the repositort to find a sensor with matching id
        Sensor sensor = sensorRepository.findById(id)
                //if there is no found id, throw a error message
                .orElseThrow(() -> new IllegalArgumentException("could not locate:" + id));
        model.addAttribute("sensor", sensor);
        // Show form to edit the sensor
        return "update-sensor";
    }

    @PostMapping("/update-sensor/{id}")
    public String updateSensor(@PathVariable("id") int id, @Validated Sensor sensor, BindingResult result) {
        //error then bounce back to same page
        if (result.hasErrors()) {
            sensor.setSensorID(id);
            return "update-sensor";
        }
        //if no erros , then save and return to the index with updated info
        sensorRepository.save(sensor);
        return "redirect:/sensors";
    }

    //handles the maping for deleing a sensor
    @GetMapping("/delete-sensor/{id}")
    //again, use the placehodler id for the sensor id that needs to be found
    public String deleteSensor(@PathVariable("id") int id) {
        //method to look for a matching id in the repo
        Sensor sensor = sensorRepository.findById(id)
                //if cant locate, then throw error
                .orElseThrow(() -> new IllegalArgumentException("unable to find sensor ID:" + id));
        sensorRepository.delete(sensor);  // Delete the sensor
        return "redirect:/sensors";  // Redirect to sensors list
    }
}

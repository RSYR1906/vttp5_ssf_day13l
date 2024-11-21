package com.SSF_day13lecture.SSF_day13lecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SSF_day13lecture.SSF_day13lecture.model.Person;
import com.SSF_day13lecture.SSF_day13lecture.service.PersonService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/personlist") // shows the list of person
    public String personListing(Model model) {

        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "personlist";
    }

    @GetMapping("/createperson") // Display an empty form for creating a new person
    public String createForm(Model model) {
        Person p = new Person();
        model.addAttribute("person", p); // Bind an empty Person object to the form
        return "personcreate"; // Return the view for the form
    }

    @PostMapping("/createperson") // Handle form submission, validate, and save the input
    public String postCreateForm(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {

        if (result.hasErrors()) { // Check for validation errors
            return "personcreate"; // Re-display the form with validation messages
        }

        // Create a new Person object with validated input fields
        Person p = new Person(person.getFirstName(), person.getLastName(), person.getEmail(), person.getSalary(),
                person.getDateOfBirth(), person.getPhoneNumber(), person.getPostalCode());

        personService.create(p); // Save the person data
        return "redirect:/personlist"; // Redirect to the list of persons
    }

    @GetMapping("/delete/{person-id}")
    public String deletePerson(@PathVariable("person-id") String personId) {
        Person p = personService.findById(personId); // find person by their id
        personService.delete(p); // delete person from person list

        return "redirect:/personlist"; // show updated person list page
    }

    @GetMapping(path = "/update/{person-id}")
    public String updateForm(@PathVariable("person-id") String personId, Model model) {
        // Retrieve the person by their unique ID
        Person p = personService.findById(personId);

        // Add the person object to the model to pre-populate the form fields
        model.addAttribute("person", p);

        // Return the view for the update form
        return "personupdate";
    }

    @PostMapping("/update")
    public String postUpdateForm(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {

        // If validation errors occur, re-display the update form with error messages
        if (result.hasErrors()) {
            return "personupdate";
        }

        // Update the person's details in the service
        personService.update(person);

        // Redirect to the list of persons after a successful update
        return "redirect:/personlist";
    }

}
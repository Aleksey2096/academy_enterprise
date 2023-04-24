package org.example.boot.controller;

import org.example.boot.model.Person;
import org.example.boot.service.PeopleService;
import org.example.boot.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

	private final PeopleService peopleService;
	private final PersonValidator personValidator;

	@Autowired
	public PeopleController(final PeopleService peopleService,
			final PersonValidator personValidator) {
		this.peopleService = peopleService;
		this.personValidator = personValidator;
	}

	@GetMapping()
	public String index(final Model model) {
		model.addAttribute("people", peopleService.findAll());
		return "people/index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") final int id, final Model model) {
		model.addAttribute("person", peopleService.findOne(id));
		model.addAttribute("books", peopleService.getBooksByPersonId(id));

		return "people/show";
	}

	@GetMapping("/new")
	public String newPerson(@ModelAttribute("person") final Person person) {
		return "people/new";
	}

	@PostMapping()
	public String create(@ModelAttribute("person") @Valid final Person person,
			final BindingResult bindingResult) {
		personValidator.validate(person, bindingResult);

		if (bindingResult.hasErrors())
			return "people/new";

		peopleService.save(person);
		return "redirect:/people";
	}

	@GetMapping("/{id}/edit")
	public String edit(final Model model, @PathVariable("id") final int id) {
		model.addAttribute("person", peopleService.findOne(id));
		return "people/edit";
	}

	@PatchMapping("/{id}")
	public String update(@ModelAttribute("person") @Valid final Person person,
			final BindingResult bindingResult, @PathVariable("id") final int id) {
		if (bindingResult.hasErrors())
			return "people/edit";

		peopleService.update(id, person);
		return "redirect:/people";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") final int id) {
		peopleService.delete(id);
		return "redirect:/people";
	}
}

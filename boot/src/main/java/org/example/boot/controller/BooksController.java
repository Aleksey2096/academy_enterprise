package org.example.boot.controller;

import org.example.boot.model.Book;
import org.example.boot.model.Person;
import org.example.boot.service.BooksService;
import org.example.boot.service.PeopleService;
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
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {

	private final BooksService booksService;
	private final PeopleService peopleService;

	@Autowired
	public BooksController(final BooksService booksService, final PeopleService peopleService) {
		this.booksService = booksService;
		this.peopleService = peopleService;
	}

	@GetMapping()
	public String index(final Model model,
			@RequestParam(value = "page", required = false) final Integer page,
			@RequestParam(value = "books_per_page", required = false) final Integer booksPerPage,
			@RequestParam(value = "sort_by_year", required = false) final boolean sortByYear) {

		if (page == null || booksPerPage == null)
			model.addAttribute("books", booksService.findAll(sortByYear)); // выдача всех книг
		else
			model.addAttribute("books",
					booksService.findWithPagination(page, booksPerPage, sortByYear));

		return "books/index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") final int id, final Model model,
			@ModelAttribute("person") final Person person) {
		model.addAttribute("book", booksService.findOne(id));

		Person bookOwner = booksService.getBookOwner(id);

		if (bookOwner != null)
			model.addAttribute("owner", bookOwner);
		else
			model.addAttribute("people", peopleService.findAll());

		return "books/show";
	}

	@GetMapping("/new")
	public String newBook(@ModelAttribute("book") final Book Book) {
		return "books/new";
	}

	@PostMapping()
	public String create(@ModelAttribute("book") @Valid final Book Book,
			final BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "books/new";

		booksService.save(Book);
		return "redirect:/books";
	}

	@GetMapping("/{id}/edit")
	public String edit(final Model model, @PathVariable("id") final int id) {
		model.addAttribute("book", booksService.findOne(id));
		return "books/edit";
	}

	@PatchMapping("/{id}")
	public String update(@ModelAttribute("book") @Valid final Book book,
			final BindingResult bindingResult, @PathVariable("id") final int id) {
		if (bindingResult.hasErrors())
			return "books/edit";

		booksService.update(id, book);
		return "redirect:/books";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") final int id) {
		booksService.delete(id);
		return "redirect:/books";
	}

	@PatchMapping("/{id}/release")
	public String release(@PathVariable("id") final int id) {
		booksService.release(id);
		return "redirect:/books/" + id;
	}

	@PatchMapping("/{id}/assign")
	public String assign(@PathVariable("id") final int id,
			@ModelAttribute("person") final Person selectedPerson) {
		// У selectedPerson назначено только поле id, остальные поля - null
		booksService.assign(id, selectedPerson);
		return "redirect:/books/" + id;
	}

	@GetMapping("/search")
	public String searchPage() {
		return "books/search";
	}

	@PostMapping("/search")
	public String makeSearch(final Model model, @RequestParam("query") final String query) {
		model.addAttribute("books", booksService.searchByTitle(query));
		return "books/search";
	}
}

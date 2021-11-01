package book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import book.beans.Book;
import book.repository.BookRepository;

/**
 * @author Austin Donald - ajdonald
 * CIS175 - Fall 2021
 * Oct 31, 2021
 */
@Controller
public class WebController {
	@Autowired
	BookRepository repo;
	@GetMapping("/")
	public String viewAllBooks(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewBook(model);
		}
		model.addAttribute("books", repo.findAll());
		return "results";
	}
	/**
	 * @param model
	 * @return
	 */
	@GetMapping("inputBook")
	public String addNewBook(Model model) {
		// TODO Auto-generated method stub
		Book b = new Book();
		model.addAttribute("newBook", b);
		return "input";
	}
	@PostMapping("inputBook")
	public String addNewBook(@ModelAttribute Book b, Model model) {
		repo.save(b);
		return viewAllBooks(model);
	}
	@GetMapping("/edit/{id}")
	public String showUpdateBook(@PathVariable("id") long id, Model model) {
		Book b = repo.findById(id).orElse(null);
		model.addAttribute("newBook", b);
		return "input";
	}
	@PostMapping("/update/{id}")
	public String reviseBook(Book b, Model model) {
		repo.save(b);
		return viewAllBooks(model);
	}
	@GetMapping("/delete/{id}")
	public String deleteBook (@PathVariable("id") long id, Model model) {
		Book b = repo.findById(id).orElse(null);
		repo.delete(b);
		return viewAllBooks(model);
	}
}

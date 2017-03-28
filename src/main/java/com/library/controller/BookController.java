package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Book;
import com.library.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping
	public List<Book> getAll() {
		return (List<Book>) bookRepository.findAll();
	}
	
	@PostMapping
	public Book create(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@GetMapping("/{id}")
	public Book findOne(@PathVariable int id) {
		return bookRepository.findOne((long) id);
	}
	
	@PutMapping
	public Book update(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		bookRepository.delete((long) id);
	}
}

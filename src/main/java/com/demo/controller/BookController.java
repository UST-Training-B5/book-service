package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.BookEntity;
import com.demo.repo.BookRepository;

@RestController
@RequestMapping("api/books")
public class BookController {
	@Autowired
	private BookRepository repo;
	
	@GetMapping
	public List<BookEntity> getAllBooks(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public BookEntity getABook(@PathVariable long id){
		Optional<BookEntity> bookEntity= repo.findById(id);
		if(bookEntity.isPresent()) {
			return bookEntity.get();
		}
		return null;
	}
	
	@PostMapping
	public BookEntity addBook(@RequestBody BookEntity bookEntity) {
		return repo.saveAndFlush(bookEntity);
	}
}

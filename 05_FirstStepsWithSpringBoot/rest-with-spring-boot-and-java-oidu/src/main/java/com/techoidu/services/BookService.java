package com.techoidu.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoidu.controllers.BookController;
import com.techoidu.data.vo.v1.BookVO;
import com.techoidu.entities.Book;
import com.techoidu.exceptions.RequiredObjectIsNullException;
import com.techoidu.exceptions.ResourceNotFoundException;
import com.techoidu.mapper.DozerMapper;
import com.techoidu.repositories.BookRepository;

@Service
public class BookService {

	private Logger logger = Logger.getLogger(BookService.class.getName());

	@Autowired
	BookRepository repository;

	public List<BookVO> findAll() {
		logger.info("Finding all people!");
		var books = DozerMapper.parseListObjects(repository.findAll(),BookVO.class);
		books.stream().forEach(p-> {
			try {
				p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return books;
	}

	public BookVO findById(Long id) throws Exception {
		logger.info("Finding one Book!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
		var vo = DozerMapper.parseObject(entity,BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());	
		return vo;
	}

	public BookVO create(BookVO book) throws Exception {
		if(book == null) throw new RequiredObjectIsNullException();
		
		logger.info("Creating one book!");
		var entity = DozerMapper.parseObject(book, Book.class);
		var vo = DozerMapper.parseObject(repository.save(entity),BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());	
		return vo;
		
	}

	public BookVO update(BookVO book) throws Exception {
		
		if(book == null) throw new RequiredObjectIsNullException();
		
		logger.info("Updating one book!");
		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		var vo = DozerMapper.parseObject(repository.save(entity),BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());	
		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting one book!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
		repository.delete(entity); 
	}

}

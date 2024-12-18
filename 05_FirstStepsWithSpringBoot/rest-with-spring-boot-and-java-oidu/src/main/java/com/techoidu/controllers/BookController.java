package com.techoidu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techoidu.data.vo.v1.BookVO;
import com.techoidu.services.BookService;
import com.techoidu.util.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "People", description = "Endpoints for Managing People")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	@Operation(summary = "find all Books", description = "find all Books", tags = { "People" }, responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookVO.class))) }),
			@ApiResponse(description = "Bad Request", responseCode = "200", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public List<BookVO> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML })
	@Operation(summary = "finds a book", description = "finds a book", tags = { "People" }, responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = BookVO.class))),
			@ApiResponse(description = "Not Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public BookVO findById(@PathVariable Long id) throws Exception {
		return service.findById(id);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML })
	@Operation(summary = "Adds a new Book", description = "Adds a new Book by passing in a JSON, XML or YML", tags = {
			"People" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = BookVO.class))),
					@ApiResponse(description = "Bad Request", responseCode = "200", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public BookVO create(@RequestBody BookVO book) throws Exception {
		return service.create(book);
	}

	
	@PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML })
	@Operation(summary = "updates a book", description = "update a Book by passing in a JSON, XML or YML", tags = {
			"People" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = BookVO.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public BookVO update(@RequestBody BookVO book) throws Exception {
		return service.update(book);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "delete a book", description = "delete a book by passing in a JSON, XML or YML", tags = {
			"People" }, responses = {
						@ApiResponse(description = "No content", responseCode = "204", content = @Content),
						@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
						@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
						@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
						@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}

package com.techoidu.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techoidu.converters.NumberConverter;
import com.techoidu.exceptions.UnsupportedMathOperationException;
import com.techoidu.math.SimpleMath;

@RestController
public class MathController {
	
	SimpleMath math = new SimpleMath();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("please set a numeric value!");
		}
		
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
	}
	

	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("please set a numeric value!");
		}
		
		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;	}
	
	
	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public Double mult(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("please set a numeric value!");
		}
		
		return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
	}
	
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("please set a numeric value!");
		}
		
		return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
		
	}
	
	
	@GetMapping("/aver/{numberOne}/{numberTwo}")
	public Double aver(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("please set a numeric value!");
		}
		
		return math.aver(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo))/2D;
	}
	
	@GetMapping("/sqrt/{number}")
	public Double sqrt(@PathVariable String number ) throws Exception {
		
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("please set a numeric value!");
		}
		
		String formatado = String.format("%.2f", Math.sqrt(NumberConverter.convertToDouble(number)));
		
		return math.sqrt(NumberConverter.convertToDouble(formatado));  
	}


	
	

	 
	

}

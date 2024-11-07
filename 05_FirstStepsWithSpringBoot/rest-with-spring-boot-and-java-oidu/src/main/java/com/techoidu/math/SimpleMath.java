package com.techoidu.math;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techoidu.converters.NumberConverter;
import com.techoidu.exceptions.UnsupportedMathOperationException;

public class SimpleMath {
	
		
		public Double sum(Double numberOne, Double numberTwo) 	{
			return numberOne + numberTwo;
		}
		
		public Double sub(Double numberOne, Double numberTwo) {
			
			return numberOne - numberTwo;
		}
		
		public Double mult(Double numberOne, Double numberTwo) { 	
			return numberOne * numberTwo;
		}
		
		public Double div(Double numberOne, Double numberTwo) {	
			return numberOne / numberTwo;
		}
		
		public Double aver(Double numberOne,Double numberTwo) {
			
			return (numberOne + numberTwo)/2D;
		}
		
		public Double sqrt(Double number ) {
			return  Math.sqrt(number); 
		}
}

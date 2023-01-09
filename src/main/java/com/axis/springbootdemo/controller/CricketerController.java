package com.axis.springbootdemo.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.springbootdemo.entity.Cricketer;
@RestController
public class CricketerController {
	
	private static ArrayList<Cricketer>crickList;
	static {
		crickList=new ArrayList<>();
		crickList.add(new Cricketer(1001,"Surykumar yadav",111,51,8,6,217.2));
		crickList.add(new Cricketer(1002,"Virat Kohli",82,60,6,5,130.8));
		crickList.add(new Cricketer(1003,"Mithali Raj",62,62,4,2,100));
		crickList.add(new Cricketer(1004,"rohit Sharma",200,147,16,8,147.5));
		crickList.add(new Cricketer(1005,"Harmanpreet Kaur",120,97,15,4,120.3));
	}
	
	@GetMapping("/message")
	public String getMessage() {
		return "Hello..First SpringBoot project... good morning";
		
	}
	//get all cricketer
	@GetMapping("/cricketers")
	public ArrayList<Cricketer>getCricketer(){
		return crickList;
		
	}
	//get cricketer by id
	@GetMapping("/cricketer/{cricketerId}")
	public Cricketer getCricketerById(@PathVariable int cricketerId) {
		for(Cricketer ck:crickList) {
			if(ck.getCricketerId()==cricketerId) {
				return ck;  //return cricketer if id is found 
			}
		}
		return null;
		}  //return null if cricketer id not found
	
	
	//Add cricketer
	@PostMapping("/cricketer")
	public ResponseEntity<String>addCricketer(@RequestBody Cricketer cricketer){
		crickList.add(cricketer);
		return new ResponseEntity<String>("Cricketer added successfully...",HttpStatus.OK);
	}
	
	
	//Update request
	@PutMapping("/cricketer/update/{cricketerId}")
	public ResponseEntity<String>updateCricketer(@PathVariable int cricketerId,@RequestBody Cricketer updateCricketer){
		if(cricketerId!=updateCricketer.getCricketerId()) {
			return new ResponseEntity<String>("cricketer id's do not match!!!",HttpStatus.BAD_REQUEST);
			}
		int index=crickList.indexOf(updateCricketer);
		if(index==-1) {
			return new ResponseEntity<String>("cricketer with id:"+cricketerId+"is not found...!",HttpStatus.NOT_FOUND);
		}
		else {
			crickList.get(index).setBalls(updateCricketer.getBalls());
			crickList.get(index).setRunsScored(updateCricketer.getRunsScored());
			crickList.get(index).setFours(updateCricketer.getFours());
			crickList.get(index).setSxies(updateCricketer.getSxies());
			crickList.get(index).setStrikeRate(updateCricketer.getStrikeRate());
			return new ResponseEntity<String>("cricketer data update successfully!!!",HttpStatus.OK);
		}
	}
	
	//delete mapping
	@DeleteMapping("/cricketer/delete/{cricketerId}")
	public ResponseEntity<String>deletecricketer(@PathVariable int cricketerId){
		
		Cricketer cricketer=getCricketerById(cricketerId);
		if(cricketer==null) {
			return new ResponseEntity<String>("cricketer with id:"+cricketerId+"is not found..!!",HttpStatus.NOT_FOUND);
			}else {
				crickList.remove(cricketer);
				return new ResponseEntity<String>("Cricketer with id:"+cricketerId+"deleted Successfully!!",HttpStatus.OK);
			}
	}
	
	
	}

	
	
	


package com.jvzalves.BoxOfficeSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvzalves.BoxOfficeSpringBoot.DTO.TicketDTO;
import com.jvzalves.BoxOfficeSpringBoot.DTO.TicketMinDTO;
import com.jvzalves.BoxOfficeSpringBoot.services.TicketService;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "/{id}")
	public TicketDTO findById(@PathVariable Long id){
    	TicketDTO result = ticketService.findById(id);
		return result;
	}
	
    @GetMapping
	public List<TicketMinDTO> findAll(){
		List<TicketMinDTO> result = ticketService.findAll();
		return result;
	}

}
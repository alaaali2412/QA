package com.assessment.QA.controller;

import com.assessment.QA.model.TicketParams;
import com.assessment.QA.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@ResponseStatus(HttpStatus.CREATED)
@RequestMapping(value = "/pay.foodics.dev/public-api/v1/App/SubmitTicket", method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE )
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping()
    public ResponseEntity<?> ticketCreation(@RequestParam String type,@Valid @RequestBody TicketParams ticket) {

        if (ticket == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();

        return ResponseEntity.created(location).build();
    }
}

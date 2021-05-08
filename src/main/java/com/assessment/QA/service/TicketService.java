package com.assessment.QA.service;

import com.assessment.QA.model.TicketParams;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TicketService {

    private List<TicketParams> ticketList = new CopyOnWriteArrayList<>();

    public TicketParams submitTicket(TicketParams ticket){
        ticketList.add(ticket);
        return ticket;
    }
}

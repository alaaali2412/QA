package com.assessment.QA.controller;

import com.assessment.QA.service.TicketService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.test.web.servlet.MvcResult;





@ExtendWith(SpringExtension.class)
@WebMvcTest(TicketController.class)
class TicketControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TicketService ticketService;

    /*
     * Assert on request status, and the created header
     * */
    @Test
    void submitTicket() throws Exception {
        String body = "{\"name\":\"test12\"," +
                "\"phone\":\"01010001010\"," +
                "\"email\":\"testing@email.com\"," +
                "\"terminalID\":" + 6 + "," +
                "\"message\":\"system down\"}";
        MvcResult result = mvc.perform(post("/pay.foodics.dev/public-api/v1/App/SubmitTicket").
                queryParam("type", "terminal").content(body).
                accept(APPLICATION_JSON).
                contentType(APPLICATION_JSON)).
                andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        Assert.assertEquals("http://localhost/pay.foodics.dev/public-api/v1/App/SubmitTicket?type=terminal",
                response.getHeader(HttpHeaders.LOCATION));

    }

    /*
     * Assert that request can not be sent without query param
     * */
    @Test
    void submitTicketWithoutQueryParam() throws Exception {
        String body = "{\"name\":\"test12\"," +
                "\"phone\":\"01010001010\"," +
                "\"email\":\"testing@email.com\"," +
                "\"terminalID\":" + 6 + "," +
                "\"message\":\"system down\"}";
        MvcResult result = mvc.perform(post("/pay.foodics.dev/public-api/v1/App/SubmitTicket").
                content(body).accept(APPLICATION_JSON).
                contentType(APPLICATION_JSON)).
                andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }
}
package za.co.tangentsolutions.employeeportal.controllers;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import za.co.tangentsolutions.employeeportal.payloads.RequestPayload;
import za.co.tangentsolutions.employeeportal.payloads.ResponsePayload;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {



    @PostMapping("/login")
    public ResponsePayload getAuthenticationToken(@RequestBody RequestPayload requestPayload){

        String url = "http://staging.tangent.tngnt.co/api-token-auth/";
        RestTemplate restTemp = new RestTemplate();
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();

        body.add("username", requestPayload.getUsername());
        body.add("password", requestPayload.getPassword());

        ResponsePayload responsePayload = new ResponsePayload(); 
        responsePayload.setToken(restTemp.postForObject(url, body, String.class));
        return responsePayload;
    }

}
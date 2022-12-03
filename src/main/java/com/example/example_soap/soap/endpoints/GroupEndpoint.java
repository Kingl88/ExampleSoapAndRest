package com.example.example_soap.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.example_soap.services.GroupService;
import com.example.example_soap.soap.groups.GetGroupByTitleRequest;
import com.example.example_soap.soap.groups.GetGroupByTitleResponse;

@Endpoint
@RequiredArgsConstructor
public class GroupEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/example_soap/soap/groups";
    private final GroupService groupService;

    /*
        Пример запроса: POST http://localhost:8080/ws

        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
          xmlns:f="http://www.flamexander.com/spring/ws/groups">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getGroupByTitleRequest>
                    <f:title>ABC-123</f:title>
                </f:getGroupByTitleRequest>
            </soapenv:Body>
        </soapenv:Envelope>
     */

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGroupByTitleRequest")
    @ResponsePayload
    @Transactional
    public GetGroupByTitleResponse getGroupByTitle(@RequestPayload GetGroupByTitleRequest request) {
        GetGroupByTitleResponse response = new GetGroupByTitleResponse();
        response.setGroup(groupService.getByTitle(request.getTitle()));
        return response;
    }
}

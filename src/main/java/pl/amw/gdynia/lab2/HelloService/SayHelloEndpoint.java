package pl.amw.gdynia.lab2.HelloService;

import io.spring.guides.gs_producing_web_service.SayHelloRequest;
import io.spring.guides.gs_producing_web_service.SayHelloResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class SayHelloEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SayHelloRequest")
    @ResponsePayload
    public SayHelloResponse getName(@RequestPayload SayHelloRequest request) {
        var response = new SayHelloResponse();
        response.setGreeting("Witaj " + request.getName() + "!");
        return response;
    }
}
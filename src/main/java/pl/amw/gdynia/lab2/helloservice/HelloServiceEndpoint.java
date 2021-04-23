package pl.amw.gdynia.lab2.helloservice;

import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloServiceEndpoint {
    private static final String NAMESPACE_URI = "http://helloservice.lab2.gdynia.amw.pl";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sayHiRequest")
    @ResponsePayload
    public SayHiResponse sayHi(@RequestPayload SayHiRequest sayHiRequest) {
        var res = new SayHiResponse();

        res.setName("Witaj: " + sayHiRequest.getName());

        return res;
    }
}

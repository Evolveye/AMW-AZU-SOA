package pl.amw.gdynia.lab2.helloservice;

import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloServiceEndpoint {
    private static final String NAMESPACE_URI = "http://helloservice.lab2.gdynia.amw.pl";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sayHiReq")
    @ResponsePayload
    public SayHiRes sayHi(@RequestPayload SayHiReq sayHiReq) {
        var res = new SayHiRes();

        res.setName(sayHiReq.getName());

        return res;
    }
}

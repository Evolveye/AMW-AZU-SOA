package pl.amw.gdynia.lab3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import pl.amw.gdynia.lab3.wsdl.SayHelloRequest;
import pl.amw.gdynia.lab3.wsdl.SayHelloResponse;

public class Client extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public SayHelloResponse getName(String firstName) {
        SayHelloRequest request = new SayHelloRequest();

        request.setFirstName(firstName);

        SayHelloResponse response = (SayHelloResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/hello/hello.wsdl", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest%22"
                        )
                );

        return response;
    }

}
package pl.amw.gdynia.lab3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Configurator {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("pl.amw.gdynia.lab3.wsdl");
        return marshaller;
    }

    @Bean
    public Client client(Jaxb2Marshaller marshaller) {
        Client client = new Client();

        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }
}



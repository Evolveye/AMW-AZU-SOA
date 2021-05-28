package pl.gdynia.amw.lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pl.gdynia.amw.lab6.service.EcbCommunicatorService;

@Configuration
@EnableScheduling
public class Config {}

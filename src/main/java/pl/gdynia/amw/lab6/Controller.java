package pl.gdynia.amw.lab6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/test")
    int getTest() {
        return 123;
    }
}

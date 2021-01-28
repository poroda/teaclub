package fi.cinia.recruitmenttaskproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to maintain endpoints for healthchecks
 */
@RestController
public class HealthCheckController {

    @GetMapping(value = "/healthcheck")
    public String getSample() {

        return "your application is running";
    }
}

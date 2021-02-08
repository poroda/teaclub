package fi.cinia.recruitmenttaskproject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.cinia.recruitmenttaskproject.model.Tea;
import fi.cinia.recruitmenttaskproject.repository.TeaRepository;

/**
 * Controller for endpoints regarding teas
 */
@CrossOrigin(exposedHeaders = "X-Total-Count")
@RestController()
@RequestMapping("/tea")
public class TeaController {

    @Autowired
    private TeaRepository teaRepository;

    /**
     * Get all teas
     * @return list of teas
     */
    @GetMapping(value = "/findall")
    public ResponseEntity <List<Tea>> getSample() {
        List<Tea> teas = teaRepository.findAll();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Total-Count",
            String.valueOf(teas.size()));

        return ResponseEntity.ok()
            .headers(responseHeaders)
            .body(teas);
    }
}

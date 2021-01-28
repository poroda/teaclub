package fi.cinia.recruitmenttaskproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.cinia.recruitmenttaskproject.model.Tea;
import fi.cinia.recruitmenttaskproject.repository.TeaRepository;

/**
 * Controller for endpoints regarding teas
 */
@RestController
@RequestMapping("/tea")
public class TeaController {

    @Autowired
    private TeaRepository teaRepository;

    /**
     * Get all teas
     * @return list of teas
     */
    @GetMapping(value = "/findall")
    public List<Tea> getSample() {
        return teaRepository.findAll();
    }
}

package za.co.tangentsolutions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import za.co.tangentsolutions.exceptionHandlers.PositionIdMismatchException;
import za.co.tangentsolutions.exceptionHandlers.PositionNotFoundException;
import za.co.tangentsolutions.model.Position;
import za.co.tangentsolutions.repository.PositionRepository;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/position")
public class PositionController {

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Position findOne(@PathVariable Long id) {
        return positionRepository.findById(id).orElseThrow(PositionNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Position create(@RequestBody Position position) {
        return positionRepository.save(position);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        positionRepository.findById(id).orElseThrow(PositionNotFoundException::new);
        positionRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Position updateTaxTable(@RequestBody Position position, @PathVariable Long id) {
        if (position.getId() == id) {
            throw new PositionIdMismatchException();
        }
        positionRepository.findById(id).orElseThrow(PositionNotFoundException::new);
        return positionRepository.save(position);
    }

}
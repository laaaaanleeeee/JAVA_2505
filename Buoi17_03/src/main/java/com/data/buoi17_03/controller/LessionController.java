package com.data.buoi17_03.controller;

import com.data.buoi17_03.dto.LessionCreateDto;
import com.data.buoi17_03.dto.LessionUpdateDto;
import com.data.buoi17_03.entity.Lession;
import com.data.buoi17_03.repository.LessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("lessions")
public class LessionController {
    @Autowired
    private LessionRepository lessionRepository;

    @GetMapping
    public ResponseEntity<?> getAllLession() {
        List<Lession> lessions = lessionRepository.findAll();

        return ResponseEntity.ok(lessions);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getLessionById(@PathVariable int id) {
        Optional<Lession> opLession = lessionRepository.findById(id);

        if(opLession.isEmpty()) {
            return new ResponseEntity<>("ID not found", HttpStatus.BAD_REQUEST);
        }

        Lession lession = opLession.get();
        return ResponseEntity.ok(lession);
    }


    @PostMapping
    public ResponseEntity<?> createLession(@RequestBody LessionCreateDto lessionCreateDto) {
        Lession lession = new Lession();
        lession.setLessionName(lessionCreateDto.getLessionName());
        lession.setLessionHours(lessionCreateDto.getLessionHours());
        lession.setLessionType(lessionCreateDto.getLessionType());
        lession.setCreatedDate(lessionCreateDto.getCreatedDate());

        lessionRepository.save(lession);
        return new ResponseEntity<>("Created new lession successfully with ID = " + lession.getId(), HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<?> updateLession(@PathVariable int id, @RequestBody LessionUpdateDto lessionUpdateDto) {
        Optional<Lession> opLess =lessionRepository.findById(id);

        if(opLess.isEmpty()) {
            return new ResponseEntity<>("ID not found", HttpStatus.BAD_REQUEST);
        }

        Lession lession = opLess.get();
        lession.setLessionName(lessionUpdateDto.getLessionName());
        lession.setLessionHours(lessionUpdateDto.getLessionHours());
        lession.setLessionType(lessionUpdateDto.getLessionType());
        lession.setCreatedDate(lessionUpdateDto.getCreatedDate());

        lessionRepository.save(lession);

        return new ResponseEntity<>("Updated lession successfully with ID = " + lession.getId(), HttpStatus.OK);
    }





    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteLessionById(@PathVariable int id) {
        Optional<Lession> opLess = lessionRepository.findById(id);
        if(opLess.isEmpty()) {
            return new ResponseEntity<>("ID not found", HttpStatus.BAD_REQUEST);
        }

        Lession lession = opLess.get();
        lessionRepository.delete(lession);

        return ResponseEntity.ok("Delete lession have ID = " + lession.getId() + " successfully");
    }



}

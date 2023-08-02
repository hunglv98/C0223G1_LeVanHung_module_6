package com.example.demo.controller;

import com.example.demo.model.Status;
import com.example.demo.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private IStatusService statusService;

    @GetMapping("")
    private ResponseEntity<?> getList() {
        return new ResponseEntity<>(statusService.getList(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable int id) {
        return new ResponseEntity<>(statusService.getById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/")
    private ResponseEntity<?> createStatus(@RequestBody Status status) {
        statusService.createStatus(status);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

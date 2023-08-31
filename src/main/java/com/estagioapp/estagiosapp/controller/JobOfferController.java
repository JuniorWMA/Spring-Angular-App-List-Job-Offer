package com.estagioapp.estagiosapp.controller;

import com.estagioapp.estagiosapp.dto.JobOfferDto;
import com.estagioapp.estagiosapp.model.JobOffer;
import com.estagioapp.estagiosapp.service.JobOfferService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joboffer")
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "JobOffer", version = "1.0", description = "JobOffer API"))
public class JobOfferController {
    @Autowired
    private JobOfferService service;

    @GetMapping("/list")
    public ResponseEntity<List<JobOfferDto>> getListJobOffer() {
        return service.getListJobOffer();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobOfferDto> getJobOfferById(@PathVariable Long id) {
        return service.getJobOfferById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<JobOfferDto> createJobOffer(@RequestBody JobOfferDto jobOffer) {
        return service.createJobOffer(jobOffer);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JobOfferDto> updateJobOffer(@PathVariable Long id, @RequestBody JobOfferDto jobOffer) {
        return service.updateJobOffer(id, jobOffer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JobOfferDto> deleteJobOffer(@PathVariable Long id) {
        return service.deleteJobOffer(id);
    }

}

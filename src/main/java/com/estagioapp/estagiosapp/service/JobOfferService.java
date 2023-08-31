package com.estagioapp.estagiosapp.service;

import com.estagioapp.estagiosapp.dto.JobOfferDto;
import com.estagioapp.estagiosapp.model.JobOffer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobOfferService {

    ResponseEntity<List<JobOfferDto>> getListJobOffer();

    ResponseEntity<JobOfferDto> getJobOfferById(Long id);

    ResponseEntity<JobOfferDto> createJobOffer(JobOfferDto jobOfferDto);

    ResponseEntity<JobOfferDto> updateJobOffer(Long id, JobOfferDto jobOfferDto);

    ResponseEntity<JobOfferDto> deleteJobOffer(Long id);
}

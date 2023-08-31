package com.estagioapp.estagiosapp.service;

import com.estagioapp.estagiosapp.dto.JobOfferDto;
import com.estagioapp.estagiosapp.model.JobOffer;
import com.estagioapp.estagiosapp.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobOfferServiceImpl implements JobOfferService {
    @Autowired
    private JobOfferRepository jobOfferRepository;
    @Override
    public ResponseEntity<List<JobOfferDto>> getListJobOffer() {
        List<JobOffer> jobOffers = jobOfferRepository.findAll();
        List<JobOfferDto> listDto = jobOffers.stream().map(JobOfferDto::new).toList();
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<JobOfferDto> getJobOfferById(Long id) {
        if (jobOfferRepository.findById(id).isPresent()) {
            JobOfferDto jobOffer = new JobOfferDto(jobOfferRepository.findById(id).get());
            return new ResponseEntity<>(jobOffer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @Override
    public ResponseEntity<JobOfferDto> createJobOffer(JobOfferDto jobOfferDto) {
        JobOffer job = new JobOffer(jobOfferDto);
        return new ResponseEntity<>(new JobOfferDto(jobOfferRepository.save(job)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<JobOfferDto> updateJobOffer(Long id, JobOfferDto jobOffer) {
        if (jobOfferRepository.findById(id).isPresent()) {
            JobOffer job = new JobOffer(jobOffer);
            job.setId(id);
            return new ResponseEntity<>(new JobOfferDto(jobOfferRepository.save(job)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<JobOfferDto> deleteJobOffer(Long id) {
        if (jobOfferRepository.findById(id).isPresent()) {
            jobOfferRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

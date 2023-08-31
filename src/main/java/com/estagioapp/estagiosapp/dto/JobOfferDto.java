package com.estagioapp.estagiosapp.dto;

import com.estagioapp.estagiosapp.model.JobOffer;

import java.util.Date;

public record JobOfferDto(String companyName, String jobTitle, String description, String location, Double salary, String urlJobOffer, Date date) {
    public JobOfferDto (JobOffer jobOffer) {
    this(jobOffer.getCompanyName(), jobOffer.getJobTitle(), jobOffer.getDescription(), jobOffer.getLocation(), jobOffer.getSalary(), jobOffer.getUrlJobOffer(), jobOffer.getDate());

    }
}

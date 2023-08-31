package com.estagioapp.estagiosapp.model;

import com.estagioapp.estagiosapp.dto.JobOfferDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Table(name = "joboffer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String companyName;
    @NotBlank
    private String jobTitle;

    private String description;

    private String location;

    private Double salary;

    @NotBlank
    private String urlJobOffer;

    private Date date;

    public JobOffer(JobOfferDto jobOfferDto){
        this.companyName = jobOfferDto.companyName();
        this.jobTitle = jobOfferDto.jobTitle();
        this.description = jobOfferDto.description();
        this.location = jobOfferDto.location();
        this.salary = jobOfferDto.salary();
        this.urlJobOffer = jobOfferDto.urlJobOffer();
        this.date = new Date();
    }
}

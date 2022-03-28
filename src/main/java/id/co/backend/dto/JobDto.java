package id.co.backend.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class JobDto {
    private String id;
    private String type;
    private String url;
    @JsonProperty(value = "created_at")
    private String createdAt;
    private String company;
    @JsonProperty(value = "company_url")
    private String companyUrl;
    private String location;
    private String title;
    private String description;
    @JsonProperty(value = "how_to_apply")
    private String howToApply;
    @JsonProperty(value = "company_logo")
    private String companyLogo;
}

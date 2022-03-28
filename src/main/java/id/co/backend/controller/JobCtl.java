package id.co.backend.controller;

import id.co.backend.client.JobWsClient;
import id.co.backend.dto.JobDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JobCtl {

    private final JobWsClient jobWsClient;

    @GetMapping("/list/inquiry/{id}")
    JobDto inquiryListJob(@PathVariable("id") String id){
       return  jobWsClient.getPositions(id);
    }

    @GetMapping("/list-all")
    List<JobDto> listAllJobs(){
        return  jobWsClient.getPositions();
    }

}

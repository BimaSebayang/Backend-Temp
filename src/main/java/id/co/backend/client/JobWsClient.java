package id.co.backend.client;

import id.co.backend.dto.JobDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "dansmultipro", url = "http://dev3.dansmultipro.co.id")
public interface JobWsClient {

    @GetMapping(
            value = "/api/recruitment/positions/{id}",
            consumes = {"application/json"},
            headers = {"Accept: application/json", "Content-Type: application/json"}
    )
    JobDto getPositions(@PathVariable("id") String id);

    @GetMapping(
            value = "/api/recruitment/positions.json",
            consumes = {"application/json"},
            headers = {"Accept: application/json", "Content-Type: application/json"}
    )
    List<JobDto> getPositions();
}

package id.co.backend.dto;

import lombok.Builder;
import lombok.Setter;

@Builder
public class ErrorResponseDto {
    private String errorResponse;
    private Integer errorCode;
}

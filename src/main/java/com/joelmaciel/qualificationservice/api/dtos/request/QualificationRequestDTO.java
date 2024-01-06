package com.joelmaciel.qualificationservice.api.dtos.request;

import com.joelmaciel.qualificationservice.domain.entities.Qualification;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@Builder
public class QualificationRequestDTO {

    @NotBlank
    private String userId;
    @NotBlank
    private String hotelId;
    @NotNull
    @PositiveOrZero
    private Integer qualification;
    @NotBlank
    private String comments;

    public static Qualification toEntity(QualificationRequestDTO requestDTO) {
        return Qualification.builder()
                .userId(requestDTO.getUserId())
                .hotelId(requestDTO.getHotelId())
                .qualification(requestDTO.getQualification())
                .comments(requestDTO.getComments())
                .build();
    }
}

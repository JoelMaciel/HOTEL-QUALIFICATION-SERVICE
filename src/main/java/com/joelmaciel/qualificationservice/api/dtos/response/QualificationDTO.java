package com.joelmaciel.qualificationservice.api.dtos.response;

import com.joelmaciel.qualificationservice.domain.entities.Qualification;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class QualificationDTO {
    private String qualificationId;
    private String userId;
    private String hotelId;
    private int qualification;
    private String comments;

    public static QualificationDTO toDTO(Qualification qualification) {
        return QualificationDTO.builder()
                .qualificationId(qualification.getQualificationId())
                .userId(qualification.getUserId())
                .hotelId(qualification.getHotelId())
                .qualification(qualification.getQualification())
                .comments(qualification.getComments())
                .build();
    }
}

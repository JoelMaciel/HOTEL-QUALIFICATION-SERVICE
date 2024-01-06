package com.joelmaciel.qualificationservice.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("qualifications")
public class Qualification {

    @Id
    private String qualificationId;
    private String userId;
    private String hotelId;
    private Integer qualification;
    private String comments;
}

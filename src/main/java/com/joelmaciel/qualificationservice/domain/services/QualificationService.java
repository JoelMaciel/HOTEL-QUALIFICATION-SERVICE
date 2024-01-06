package com.joelmaciel.qualificationservice.domain.services;

import com.joelmaciel.qualificationservice.api.dtos.request.QualificationRequestDTO;
import com.joelmaciel.qualificationservice.api.dtos.response.QualificationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QualificationService {

    QualificationDTO save(QualificationRequestDTO qualificationRequestDTO);

    Page<QualificationDTO> findAll(Pageable pageable);
    Page<QualificationDTO> findByUserId(Pageable pageable, String userId);
    Page<QualificationDTO> findByHotelId(Pageable pageable, String hotelId);
}

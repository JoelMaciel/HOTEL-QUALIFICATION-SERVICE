package com.joelmaciel.qualificationservice.domain.services;

import com.joelmaciel.qualificationservice.api.dtos.request.QualificationRequestDTO;
import com.joelmaciel.qualificationservice.api.dtos.response.QualificationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QualificationService {

    QualificationDTO save(QualificationRequestDTO qualificationRequestDTO);

    Page<QualificationDTO> findAll(Pageable pageable);
    List<QualificationDTO> findByUserId(String userId);
    List<QualificationDTO> findByHotelId(String hotelId);
}

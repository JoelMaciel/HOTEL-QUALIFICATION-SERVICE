package com.joelmaciel.qualificationservice.domain.services.impl;

import com.joelmaciel.qualificationservice.api.dtos.request.QualificationRequestDTO;
import com.joelmaciel.qualificationservice.api.dtos.response.QualificationDTO;
import com.joelmaciel.qualificationservice.domain.entities.Qualification;
import com.joelmaciel.qualificationservice.domain.exceptions.HotelNotFoundException;
import com.joelmaciel.qualificationservice.domain.exceptions.UserNotFoundException;
import com.joelmaciel.qualificationservice.domain.repositories.QualificationRepository;
import com.joelmaciel.qualificationservice.domain.services.QualificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QualificationServiceImpl implements QualificationService {

    public static final String USER_NOT_FOUND = "There is no user saved in the database with this id.";
    public static final String HOTEL_NOT_FOUND = "There is no hotel saved in the database with this id.";
    private final QualificationRepository qualificationRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<QualificationDTO> findAll(Pageable pageable) {
        Page<Qualification> qualifications = qualificationRepository.findAll(pageable);
        return qualifications.map(QualificationDTO::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<QualificationDTO> findByUserId(Pageable pageable, String userId) {
        if (qualificationRepository.existsByHotelId(userId)) {
            Page<Qualification> qualifications = qualificationRepository.findByUserId(pageable, userId);
            return qualifications.map(QualificationDTO::toDTO);
        } else {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<QualificationDTO> findByHotelId(Pageable pageable, String hotelId) {
        if (qualificationRepository.existsByHotelId(hotelId)) {
            Page<Qualification> qualifications = qualificationRepository.findByHotelId(pageable, hotelId);
            return qualifications.map(QualificationDTO::toDTO);
        } else {
            throw new HotelNotFoundException(HOTEL_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public QualificationDTO save(QualificationRequestDTO qualificationRequestDTO) {
        Qualification qualification = QualificationRequestDTO.toEntity(qualificationRequestDTO);
        return QualificationDTO.toDTO(qualificationRepository.save(qualification));
    }
}

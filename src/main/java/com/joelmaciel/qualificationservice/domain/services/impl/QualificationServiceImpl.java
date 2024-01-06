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

import java.nio.file.LinkOption;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<QualificationDTO> findByUserId(String userId) {
        if (qualificationRepository.existsByUserId(userId)) {
            List<Qualification> qualifications = qualificationRepository.findByUserId(userId);
            return qualifications.stream()
                    .map(QualificationDTO::toDTO)
                    .collect(Collectors.toList());
        } else {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<QualificationDTO> findByHotelId(String hotelId) {
        if (qualificationRepository.existsByHotelId(hotelId)) {
            List<Qualification> qualifications = qualificationRepository.findByHotelId(hotelId);
            return qualifications.stream()
                    .map(QualificationDTO::toDTO)
                    .collect(Collectors.toList());
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

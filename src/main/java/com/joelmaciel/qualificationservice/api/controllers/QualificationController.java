package com.joelmaciel.qualificationservice.api.controllers;

import com.joelmaciel.qualificationservice.api.dtos.request.QualificationRequestDTO;
import com.joelmaciel.qualificationservice.api.dtos.response.QualificationDTO;
import com.joelmaciel.qualificationservice.domain.services.QualificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/qualifications")
public class QualificationController {

    private final QualificationService qualificationService;

    @GetMapping
    public Page<QualificationDTO> getAll(
            @PageableDefault(page = 0, size = 10, sort = "qualificationId", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return qualificationService.findAll(pageable);
    }

    @GetMapping("/users/{userId}")
    public Page<QualificationDTO> getQualificationUserId(@PathVariable String userId, Pageable pageable) {
        return qualificationService.findByUserId(pageable, userId);
    }

    @GetMapping("/hotels/{hotelId}")
    public Page<QualificationDTO> getQualificationHotelId(@PathVariable String hotelId, Pageable pageable) {
        return qualificationService.findByHotelId(pageable, hotelId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QualificationDTO save(@RequestBody @Valid QualificationRequestDTO requestDTO) {
        return qualificationService.save(requestDTO);
    }
}

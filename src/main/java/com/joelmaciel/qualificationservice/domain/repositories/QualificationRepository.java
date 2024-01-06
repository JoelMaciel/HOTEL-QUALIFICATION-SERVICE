package com.joelmaciel.qualificationservice.domain.repositories;

import com.joelmaciel.qualificationservice.domain.entities.Qualification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends MongoRepository<Qualification, Long> {
    Page<Qualification> findByUserId(Pageable pageable, String userId);

    Page<Qualification> findByHotelId(Pageable pageable, String hotelId);
    boolean existsByUserId(String userId);

    boolean existsByHotelId(String hotelId);
}

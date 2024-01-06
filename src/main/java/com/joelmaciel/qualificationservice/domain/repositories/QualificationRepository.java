package com.joelmaciel.qualificationservice.domain.repositories;

import com.joelmaciel.qualificationservice.domain.entities.Qualification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QualificationRepository extends MongoRepository<Qualification, Long> {
    List<Qualification> findByUserId(String userId);

    List<Qualification> findByHotelId(String hotelId);

    boolean existsByUserId(String userId);

    boolean existsByHotelId(String hotelId);
}

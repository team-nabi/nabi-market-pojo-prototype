package com.example.sample.cardimage;

import com.example.sample.card.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardImageJpaRepository extends JpaRepository<CardImageEntity, Long> {
    List<CardImageEntity> findAllByCardEntity(CardEntity cardEntity);

    void deleteAllByCardEntity(CardEntity cardEntity);
}

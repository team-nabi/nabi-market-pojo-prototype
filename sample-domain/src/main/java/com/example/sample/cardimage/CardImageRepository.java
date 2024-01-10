package com.example.sample.cardimage;

import com.example.sample.card.Card;

import java.util.List;
import java.util.Optional;

public interface CardImageRepository {
    List<CardImage> saveAll(List<CardImage> images);

    List<CardImage> findAllByCard(Card card);

    void deleteAllByCard(Card card);

    Optional<CardImage> findById(Long cardImageId);
}

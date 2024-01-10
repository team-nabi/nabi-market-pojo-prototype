package com.example.sample.card;

import java.util.Optional;

public interface CardRepository {
    Card save(Card card);

    Optional<Card> findById(Long id);

    void deleteCardById(Long id);
}

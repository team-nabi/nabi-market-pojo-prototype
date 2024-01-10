package com.example.sample.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository {
    private final CardJpaRepository cardJpaRepository;

    @Override
    public Card save(Card card) {
        CardEntity cardEntity = CardEntity.toEntity(card);
        CardEntity savedCardEntity = cardJpaRepository.save(cardEntity);

        return savedCardEntity.toDomain();
    }

    @Override
    public Optional<Card> findById(Long id) {
        Optional<CardEntity> cardEntity = cardJpaRepository.findById(id);

        if (cardEntity.isEmpty()) {
            return Optional.empty();
        }

        Card card = cardEntity.get().toDomain();

        return Optional.of(card);
    }

    @Override
    public void deleteCardById(Long id) {
        cardJpaRepository.deleteById(id);
    }
}

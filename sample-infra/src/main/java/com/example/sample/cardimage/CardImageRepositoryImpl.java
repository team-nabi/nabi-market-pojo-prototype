package com.example.sample.cardimage;


import com.example.sample.card.Card;
import com.example.sample.card.CardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CardImageRepositoryImpl implements CardImageRepository {
    private final CardImageJpaRepository cardImageJpaRepository;

    @Override
    public List<CardImage> saveAll(List<CardImage> images) {
        List<CardImageEntity> cardImageEntities = images.stream()
            .map(
                i -> CardImageEntity.toEntity(
                    i,
                    CardEntity.toEntity(i.getCard())
                )
            )
            .toList();

        List<CardImageEntity> savedCardImageEntities = cardImageJpaRepository.saveAll(cardImageEntities);

        return savedCardImageEntities.stream()
            .map(CardImageEntity::toDomain)
            .toList();
    }

    @Override
    public List<CardImage> findAllByCard(Card card) {
        List<CardImageEntity> cardImageEntities
            = cardImageJpaRepository.findAllByCardEntity(CardEntity.toEntity(card));

        return cardImageEntities.stream()
            .map(CardImageEntity::toDomain)
            .toList();
    }

    @Override
    public void deleteAllByCard(Card card) {
        CardEntity cardEntity = CardEntity.toEntity(card);
        cardImageJpaRepository.deleteAllByCardEntity(cardEntity);
    }

    @Override
    public Optional<CardImage> findById(Long cardImageId) {
        Optional<CardImageEntity> cardImageEntity = cardImageJpaRepository.findById(cardImageId);

        if (cardImageEntity.isEmpty()) {
            return Optional.empty();
        }

        CardImage cardImage = cardImageEntity.get().toDomain();
        return Optional.of(cardImage);
    }
}

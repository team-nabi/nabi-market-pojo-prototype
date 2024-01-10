package com.example.sample.card;

import com.example.sample.card.dto.CardCreateRequestDTO;
import com.example.sample.card.dto.CardResponseDTO;
import com.example.sample.card.dto.CardUpdateRequestDTO;
import com.example.sample.cardimage.CardImageRepository;
import com.example.sample.cardimage.CardImage;
import com.example.sample.cardimage.dto.CardImageInfoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardImageRepository cardImageRepository;

    @Transactional
    public CardResponseDTO createCard(CardCreateRequestDTO cardCreateRequestDTO) {
        Card card = cardCreateRequestDTO.toDomain();
        Card savedCard = cardRepository.save(card);

        List<CardImage> cardImages = cardCreateRequestDTO.getImages()
            .stream()
            .map(cardImageCreateRequestDTO -> cardImageCreateRequestDTO.toDomain(savedCard))
            .toList();
        List<CardImage> savedCardImages = cardImageRepository.saveAll(cardImages);

        return CardResponseDTO.of(savedCard, savedCardImages);
    }

    @Transactional(readOnly = true)
    public CardResponseDTO getCardById(Long id) {
        Card card = cardRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No Card"));

        List<CardImage> cardImages = cardImageRepository.findAllByCard(card);

        return CardResponseDTO.of(card, cardImages);
    }

    @Transactional
    public CardResponseDTO updateCardById(
        Long cardId,
        CardUpdateRequestDTO cardUpdateRequestDTO
    ) {
        Card card = cardRepository.findById(cardId)
            .orElseThrow(() -> new RuntimeException("No Card"));

        card.updateCard(cardUpdateRequestDTO.getTitle());

        Card updatedCard = cardRepository.save(card);   // dirty checking으로 불가능하기 때문에 save 호출

        // 기존 cardImage를 모두 지우고 새로운 row insert(비지니스 특성)
        cardImageRepository.deleteAllByCard(updatedCard);

        List<CardImage> images = cardUpdateRequestDTO.getImages()
            .stream()
            .map(i -> i.toDomain(updatedCard))
            .toList();

        List<CardImage> savedCardImages = cardImageRepository.saveAll(images);

        return CardResponseDTO.of(updatedCard, savedCardImages);
    }

    @Transactional
    public void deleteCardById(Long cardId) {
        Card card = cardRepository.findById(cardId)
            .orElseThrow(() -> new RuntimeException("No Card"));

        cardImageRepository.deleteAllByCard(card);
        cardRepository.deleteCardById(cardId);
    }

    /**
     * cardImage로 card가 객체 탐색이 가능한지 테스트하기 위한 용도의 메소드
     * @param cardImageId
     * @return
     */
    @Transactional(readOnly = true)
    public CardImageInfoResponseDTO getCardImageById(Long cardImageId) {
        CardImage cardImage = cardImageRepository.findById(cardImageId)
            .orElseThrow(() -> new RuntimeException("No Card"));

        return CardImageInfoResponseDTO.from(cardImage);
    }
}

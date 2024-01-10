package com.example.sample.card.dto;

import com.example.sample.card.Card;
import com.example.sample.cardimage.CardImage;
import com.example.sample.cardimage.dto.CardImageResponseDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CardResponseDTO {
    Long id;
    String title;
    List<CardImageResponseDTO> cardImages;

    public static CardResponseDTO of(Card card, List<CardImage> images) {
        List<CardImageResponseDTO> cardImagesResponses = images.stream()
            .map(CardImageResponseDTO::from)
            .toList();

        return CardResponseDTO.builder()
            .id(card.getId())
            .title(card.getTitle())
            .cardImages(cardImagesResponses)
            .build();
    }
}

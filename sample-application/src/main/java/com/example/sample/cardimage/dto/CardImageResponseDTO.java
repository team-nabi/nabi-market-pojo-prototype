package com.example.sample.cardimage.dto;

import com.example.sample.cardimage.CardImage;
import lombok.Getter;

@Getter
public class CardImageResponseDTO {
    Long id;
    String url;

    public CardImageResponseDTO(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public static CardImageResponseDTO from(CardImage cardImage) {
        return new CardImageResponseDTO(cardImage.getId(), cardImage.getUrl());
    }
}

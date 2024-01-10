package com.example.sample.cardimage.dto;

import com.example.sample.card.Card;
import com.example.sample.cardimage.CardImage;
import lombok.Getter;

@Getter
public class CardImageUpdateRequestDTO {
    String url;

    public CardImage toDomain(Card card) {
        return CardImage.builder()
            .url(url)
            .card(card)
            .build();
    }
}

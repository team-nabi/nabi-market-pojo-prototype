package com.example.sample.card.dto;

import com.example.sample.card.Card;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CardInfoResponseDTO {
    Long id;
    String title;

    @Builder
    public CardInfoResponseDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static CardInfoResponseDTO from(Card card) {
        return CardInfoResponseDTO.builder()
            .id(card.getId())
            .title(card.getTitle())
            .build();
    }
}

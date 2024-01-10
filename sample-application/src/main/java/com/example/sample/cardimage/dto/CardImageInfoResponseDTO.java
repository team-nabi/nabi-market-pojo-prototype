package com.example.sample.cardimage.dto;

import com.example.sample.card.dto.CardInfoResponseDTO;
import com.example.sample.cardimage.CardImage;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CardImageInfoResponseDTO {
    Long id;
    String url;
    CardInfoResponseDTO cardInfo;

    @Builder
    public CardImageInfoResponseDTO(Long id, String url, CardInfoResponseDTO cardInfo) {
        this.id = id;
        this.url = url;
        this.cardInfo = cardInfo;
    }

    public static CardImageInfoResponseDTO from(CardImage cardImage) {
        CardInfoResponseDTO cardInfo = CardInfoResponseDTO.from(cardImage.getCard());

        return CardImageInfoResponseDTO.builder()
            .id(cardImage.getId())
            .url(cardImage.getUrl())
            .cardInfo(cardInfo)
            .build();
    }
}

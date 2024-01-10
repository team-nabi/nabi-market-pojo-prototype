package com.example.sample.card.dto;

import com.example.sample.card.Card;
import com.example.sample.cardimage.dto.CardImageCreateRequestDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class CardCreateRequestDTO {
    String title;

    List<CardImageCreateRequestDTO> images;

    public Card toDomain() {
        return Card.builder()
            .title(title)
            .build();
    }
}

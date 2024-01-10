package com.example.sample.card.dto;

import com.example.sample.cardimage.dto.CardImageUpdateRequestDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class CardUpdateRequestDTO {
    String title;

    List<CardImageUpdateRequestDTO> images;
}

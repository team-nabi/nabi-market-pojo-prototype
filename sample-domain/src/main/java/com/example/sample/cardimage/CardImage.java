package com.example.sample.cardimage;

import com.example.sample.card.Card;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CardImage {
    private Long id;
    private String url;
    private Card card;
}

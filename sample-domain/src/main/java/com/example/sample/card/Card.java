package com.example.sample.card;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Card {
    private Long id;
    private String title;

    @Builder
    public Card(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public void updateCard(String title) {
        this.title = title;
    }
}

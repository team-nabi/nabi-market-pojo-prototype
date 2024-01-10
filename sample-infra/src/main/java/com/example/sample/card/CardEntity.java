package com.example.sample.card;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "cardss")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Builder
    public CardEntity(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Card toDomain() {
        return Card.builder()
            .id(id)
            .title(title)
            .build();
    }

    public static CardEntity toEntity(Card card) {
        return CardEntity.builder()
            .id(card.getId())
            .title(card.getTitle())
            .build();
    }
}

package com.example.sample.cardimage;

import com.example.sample.card.Card;
import com.example.sample.card.CardEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Table(name = "card_imagess")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CardImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cardss_id")
    CardEntity cardEntity;

    @Builder
    public CardImageEntity(String url, CardEntity cardEntity) {
        this.url = url;
        this.cardEntity = cardEntity;
    }

    public CardImage toDomain() {
        Card card = cardEntity.toDomain();

        return CardImage.builder()
            .id(id)
            .url(url)
            .card(card)
            .build();
    }

    public static CardImageEntity toEntity(
        CardImage cardImage,
        CardEntity cardEntity
    ) {
        return CardImageEntity.builder()
            .url(cardImage.getUrl())
            .cardEntity(cardEntity)
            .build();
    }
}

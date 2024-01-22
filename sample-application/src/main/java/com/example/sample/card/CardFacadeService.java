package com.example.sample.card;

import org.springframework.stereotype.Service;

import com.example.sample.atomic.Atomic;
import com.example.sample.card.dto.CardCreateRequestDTO;
import com.example.sample.card.dto.CardResponseDTO;
import com.example.sample.card.dto.CardUpdateRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardFacadeService {
    private final Atomic atomic;
    private final CardService cardService;

    public CardResponseDTO createCardFacade(CardCreateRequestDTO cardCreateRequestDTO) {
        return atomic.withTransaction(() -> cardService.createCard(cardCreateRequestDTO));
    }

    public CardResponseDTO getCardByIdFacade(Long id) {
        return atomic.withTransactionReadOnly(() -> cardService.getCardById(id));
    }

    public CardResponseDTO updateCardByIdFacade(
        Long id,
        CardUpdateRequestDTO cardUpdateRequestDTO
    ) {
        return atomic.withTransaction(() -> cardService.updateCardById(id, cardUpdateRequestDTO));
    }

    public void deleteCardByIdFacade(Long id) {
        atomic.withTransaction(() -> cardService.deleteCardById(id));
    }

}

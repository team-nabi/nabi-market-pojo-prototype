package com.example.sample.card;

import com.example.sample.card.dto.CardCreateRequestDTO;
import com.example.sample.card.dto.CardResponseDTO;
import com.example.sample.card.dto.CardUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cards")
public class CardController {
    private final CardFacadeService cardFacadeService;

    /**
     * Create
     * @param cardCreateRequestDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<CardResponseDTO> save(@RequestBody CardCreateRequestDTO cardCreateRequestDTO) {
        return ResponseEntity.ok(cardFacadeService.createCardFacade(cardCreateRequestDTO));
    }

    /**
     * Read
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(cardFacadeService.getCardByIdFacade(id));
    }

    /**
     * Update
     * @param id
     * @param cardUpdateRequestDTO
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<CardResponseDTO> update(
        @PathVariable Long id,
        @RequestBody CardUpdateRequestDTO cardUpdateRequestDTO
    ) {
        return ResponseEntity.ok(cardFacadeService.updateCardByIdFacade(id, cardUpdateRequestDTO));
    }

    /**
     * Delete
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        cardFacadeService.deleteCardByIdFacade(id);

        return ResponseEntity.ok("SUCCESS");
    }
}

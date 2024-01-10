package com.example.sample.cardimage;

import com.example.sample.card.CardService;
import com.example.sample.cardimage.dto.CardImageInfoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/card-images")
@RequiredArgsConstructor
public class CardImageController {

    private final CardService cardService;

    @GetMapping("/{id}")
    public ResponseEntity<CardImageInfoResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.getCardImageById(id));
    }
}

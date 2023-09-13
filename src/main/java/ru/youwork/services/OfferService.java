package ru.youwork.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.youwork.models.Offer;
import ru.youwork.repositories.OfferRepository;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;

    public List<Offer> offerList() {
        return offerRepository.findAll();
    }

    public Offer getFromId(Long id) {
        return offerRepository.findById(id).orElse(null);
    }

    public void save(Offer offer) throws IOException {
        log.info("Saving new {}", offer);
        offerRepository.save(offer);
    }

    public void deleteFromId(long id) {
        log.info("Deleting offer with id {}", id);
        offerRepository.deleteById(id);
    }
}

package ru.youwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.youwork.models.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}

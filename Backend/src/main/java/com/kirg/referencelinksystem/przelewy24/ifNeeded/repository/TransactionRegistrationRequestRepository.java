package com.kirg.referencelinksystem.przelewy24.ifNeeded.repository;

import com.kirg.referencelinksystem.przelewy24.TransactionRegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRegistrationRequestRepository extends JpaRepository<TransactionRegistrationRequest, Long> {
}

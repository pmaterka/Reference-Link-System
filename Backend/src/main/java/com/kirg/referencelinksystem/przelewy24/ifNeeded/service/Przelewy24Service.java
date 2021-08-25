package com.kirg.referencelinksystem.przelewy24.ifNeeded.service;


import com.kirg.referencelinksystem.przelewy24.ifNeeded.repository.TransactionRegistrationRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class Przelewy24Service {

        private final TransactionRegistrationRequestRepository transactionRegistrationRequestRepository;

    public Przelewy24Service(TransactionRegistrationRequestRepository transactionRegistrationRequestRepository) {
                this.transactionRegistrationRequestRepository = transactionRegistrationRequestRepository;
    }

    //nie bieżąco wprowadzać, wg potrzeb frontendu
}

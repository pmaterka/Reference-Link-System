package com.kirg.referencelinksystem.przelewy24.ifNeeded.controller;

import com.kirg.referencelinksystem.przelewy24.ifNeeded.service.Przelewy24Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Przelewy24Controller {

    private final Przelewy24Service przelewy24Service;


    public Przelewy24Controller(Przelewy24Service przelewy24Service) {
        this.przelewy24Service = przelewy24Service;
    }

    // dodać mapowanie i protokuł http, jeśli frontend nie fetchuje od razu od przelewy24 API
}

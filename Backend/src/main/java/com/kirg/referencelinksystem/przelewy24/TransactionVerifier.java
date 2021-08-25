package com.kirg.referencelinksystem.przelewy24;

import org.springframework.stereotype.Component;

@Component
public class TransactionVerifier {

    // czy jest to potrzebne skoro frontend fetchuje z REST API przelewy24?

    /*
    TODO
    ps
    Po poprawnie zakończonym procesie płatności status danego
    zamówienia w sklepie powinien automatycznie zmienić się na zapłacone/przyjęte do realizacji.
    W tym momencie obsługa sklepu może przystąpić do realizowania zamówienia.

    Może coś takiego zaimplementować?
     */
}

package com.kirg.referencelinksystem.przelewy24;

/*
Przed wysłaniem żądania transakcji należy zapisać jej dane do lokalnej bazy danych sprzedawcy.
 W szczególności należy zachować informacje o identyfikatorze sesji i kwocie transakcji
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class TransactionRegistrationRequest {

    //Może się okazać, że api przelewy 24 nie przyjmie tego id. Wtedy trzeba inaczej to do bazy wprowadzić i zmienić repozytoria oraz klasy które ich używają
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int merchantId = 11111; // ID Sklepu

    private int posId = 11111; //ID Sklepu (domyślnie ID Sprzedawcy)

    @Size(max = 100)
    private String sessionId = "test7"; // Unikalny identyfikator z systemu sprzedawcy. Nie może przekraczać 100 znaków

    private int amount = 1; // Kwota transakcji wyrażona w groszach, np. 1.23 PLN = 123

    @Size (max=3)
    private String currency = "PLN"; // Wartość zgodna z ISO np. PLN

    @Size (max=1024)
    private String description = "test order"; //Opis transakcji

    @Size (max=50)
    private String email = "john.doe@example.com"; // Email Klienta

    @Size (max=2)
    private String country = "PL"; //Kody krajów zgodnie ISO, np. PL, DE itp

    @Size(max=2)
    private String language = "pl"; // Jeden z następujących kodów krajów zgodnie z normą ISO 639-1: bg, cs, de, en, es, fr, hr, hu, it, nl, pl, pt, se, sk

    @Size (max=250)
    private String urlReturn; //Adres powrotny po zakończeniu transakcji

    /*
    Suma kontrolna parametrów:
{"sessionId":"str","merchantId":int,"amount":int,"currency":"str","crc":"str"}

liczona z użyciem sha384

WAŻNE!:
przy wykorzystaniu funkcji json_encode należy dodać następujące atrybuty
"JSON_UNESCAPED_UNICODE | JSON_UNESCAPED_SLASHES"
     */
    @Size(max=100)
    private String sign= "596af9bc39271b4cfdab45937";




    /*
    Poniższe atrybuty są zakomentowane, ponieważ można je wprowadzić, aczkolwiek nie są wymagane.
    Na obecny wygląd naszej aplikacji, nie wydają mi się potrzebne.
     */

    /*
    @Size (max=40)
    private String client; //Imię i nazwisko Klienta

    @Size(max=80)
    private String address; // Adres Klienta

    @Size (max=10)
    private String zip; //Kod pocztowy Klienta

    @Size(max=50)
    private String city; //Miasto Klienta

    @Size(max=12)
    private String phone; //Telefon klienta w formacie 481321132123

    private int method; //Identyfikator metody płatności. Lista metod płatności widoczna w panelu lub dostępna przez API

    @Size(max=250)
    private String urlStatus; //Adres do przekazania statusu transakcji

    private int timeLimit; //Limit czasu na wykonanie transakcji, 0 - brak limitu, maks. 99 (w minutach)

    /
    Enum: 1 2 4 8 16 32 64 128 256
1 - karty, 2 - przelewy, 4 - przelew tradycyjny, 8 - N/A, 16 - wszystkie 24/7 –
udostępnia wszystkie metody płatności, 32 - użyj przedpłatę, 64 – tylko metody pay-by-link, 128 –
formy ratalne, 256 – wallety Aby uruchomić poszczególne kanały, nalezy zsumowac ich wartości.

Przykład: karty i przelew tradycyjny: channel=5
     /
    private int channel;

    private boolean waitForResult; //Parametr determinuje, czy użytkownik zostanie przekierowany z powrotem do sklepu od razu po wykonaniu płatności, czy dopiero, gdy dotrze wynik transakcji (z potwierdzeniem płatności)

    /
    Akceptacja regulaminu Przelewy24:
false – wyświetl zgodę na stronie p24 (domyślna),
true – akceptacja dokonana, nie wyświetlaj.
W przypadku wysyłania parametru „true”, na stronie Partnera musi
znaleźć się zgoda o treści: „Oświadczam, że zapoznałem się z regulaminem i
obowiązkiem informacyjnym serwisu Przelewy24”.
Pod słowami regulamin i obowiązek informacyjny musi być link do stron z tymi dokumentami.
Checkbox nie może być odgórnie zaznaczony.
     /
    private boolean regulationAccept=false;

    private int shipping; //Koszt dostawy/wysyłki

    @Size(max=20)
    private String transferLabel; // Opis przekazywany do tytułu przelewu

    /
    Value: 1
Przesłanie tego parametru jest niezbędne przy wykorzystaniu bibliotek SDK.
W mobileLib należy przesłać wartość 1, natomiast w parametrze sdkVersion należy wskazać wersję biblioteki,
z której chcemy skorzystać.
     /
    private int mobileLib;

    @Size(max=10)
    private String sdkVersion; //Wersja bibliotek mobilnych. Określa czy transakcja jest mobilna

    @Size (max=15)
    private String encoding; //System kodowania przesyłanych znaków: ISO-8859-2, UTF-8, Windows-1250

    @Size(max=250)
    private String methodRefId; // Specjalny parametr wymagany dla niektórych procesów płatności, np. BLIK i Karty one-click.

    //Jeszcze jest obiekt cart oraz additional. Zajrzeć bezpośrednio do API przelewy24 po szczegóły.

    */

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUrlReturn() {
        return urlReturn;
    }

    public void setUrlReturn(String urlReturn) {
        this.urlReturn = urlReturn;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getId() {
        return id;
    }
}

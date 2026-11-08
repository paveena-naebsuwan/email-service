package se.iths.paveena.emailservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller som hanterar förfrågningar till startsidan
 * i Email-service.
 *
 * Klassen tar emot HTTP-anrop och skickar tillbaka
 * ett meddelande när en beställning har skickats.
 */
@RestController
public class HomeController {

    /**
     * Hanterar GET-anrop till startsidan.
     *
     * @return ett meddelande om att beställningen har skickats
     */
    @GetMapping
    public String home() {
        return "Order är skickad";
    }
}

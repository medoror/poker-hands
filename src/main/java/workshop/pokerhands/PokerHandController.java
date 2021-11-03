package workshop.pokerhands;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokerHandController {

    @GetMapping("/playHands")
    public ResponseEntity<String> playHands() {
        return ResponseEntity.ok().body("Draw");
    }
}

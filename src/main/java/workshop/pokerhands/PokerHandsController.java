package workshop.pokerhands;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokerHandsController {

    @GetMapping("/pokerHandResult")
    public ResponseEntity<String> getPokerHandResult() {
        return ResponseEntity.ok().body("Draw");
    }
}

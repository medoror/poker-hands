package workshop.pokerhands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PokerHandsController {
    private final PokerHandService pokerHandService;

    public PokerHandsController(PokerHandService pokerHandService){
        this.pokerHandService = pokerHandService;
    }

    @GetMapping("/pokerHandResult")
    public ResponseEntity<String> getPokerHandResult(@RequestBody List<Integer[]> request) {
        Integer[] hand1 = request.get(0);
        Integer[] hand2 = request.get(1);
        String result = pokerHandService.compareHands(hand1, hand2);
        return ResponseEntity.ok().body(result);
    }

}

package workshop.pokerhands;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PokerHandService {

    public PokerHandService(){}

    public String compareHands(Integer[] hand1, Integer[] hand2) {
        String result = "Draw";
        if(!Arrays.deepEquals(hand1, hand2)){
            result = "First Hand Wins";
        }
        return result;
    }
}

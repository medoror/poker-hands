package workshop.pokerhands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerHandServiceTest {

    private PokerHandService pokerHandService;

    @BeforeEach
    void setup(){
        pokerHandService = new PokerHandService();
    }

    @Test
    public void shouldResultInADrawWhenNeitherHandWins(){
        Integer[] firstHand = new Integer[]{7,5,4,3,2};
        Integer[] secondHand = new Integer[]{7,5,4,3,2};

        String pokerHandResult = pokerHandService.compareHands(firstHand, secondHand);

        assertEquals("Draw", pokerHandResult);
    }

    @Test
    public void shouldDeclareTheHandWithTheHigherCardTheWinner() {

        Integer[] firstHand = new Integer[]{2,5,4,3,8};
        Integer[] secondHand = new Integer[]{7,5,4,3,2};

        String pokerHandResult = pokerHandService.compareHands(firstHand, secondHand);
        assertEquals("First Hand Wins", pokerHandResult);
    }
}
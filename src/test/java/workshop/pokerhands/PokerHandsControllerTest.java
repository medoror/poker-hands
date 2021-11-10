package workshop.pokerhands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PokerHandsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PokerHandService pokerHandService;

    @Test
    public void shouldResultInADrawWhenNeitherHandWins() throws Exception {

        Integer[] firstHand = new Integer[]{7,5,4,3,2};
        Integer[] secondHand = new Integer[]{7,5,4,3,2};

        List roundHands = List.of(firstHand, secondHand);

        MockHttpServletRequestBuilder request = get("/pokerHandResult")
                        .content( new ObjectMapper().writeValueAsString(roundHands))
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Draw"));
    }

    @Test
    public void shouldDeclareTheHandWithTheHigherCardTheWinner() throws Exception {

        Integer[] firstHand = new Integer[]{2,5,4,3,8};
        Integer[] secondHand = new Integer[]{7,5,4,3,2};

        List roundHands = List.of(firstHand, secondHand);
        MockHttpServletRequestBuilder request = get("/pokerHandResult")
                .content( new ObjectMapper().writeValueAsString(roundHands))
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("First Hand Wins"));
    }
}

package workshop.pokerhands;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PokerHandsController.class)
public class PokerHandsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldResultInADrawWhenNeitherHandWins() throws Exception {

        MockHttpServletRequestBuilder request = get("/pokerHandResult");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Draw")));
    }
}

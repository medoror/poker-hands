package workshop.pokerhands;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PokerHandController.class)
public class PokerHandControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnDrawWhenPlayersHaveTheSameHand() throws Exception {
        MockHttpServletRequestBuilder request = get("/playHands");
        mockMvc.perform(request
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[{\"cards\":[7,5,4,3,2]},{\"cards\":[7,5,4,3,2]}]"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Draw")));
    }
}

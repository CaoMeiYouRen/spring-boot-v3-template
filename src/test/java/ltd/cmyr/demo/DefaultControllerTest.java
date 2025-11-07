package ltd.cmyr.demo;

import ltd.cmyr.demo.controller.DefaultController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jayway.jsonpath.JsonPath;
import org.assertj.core.api.Assertions;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

@WebMvcTest(DefaultController.class)
class DefaultControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetTime() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isString())
                .andExpect(result -> {
                    String timestamp = JsonPath.read(result.getResponse().getContentAsString(), "$.data");
                    Instant parsed = DateTimeFormatter.ISO_INSTANT.parse(timestamp, Instant::from);
                    Instant now = Instant.now();
                    // ensure the timestamp produced by the controller is recent to guard against
                    // stale responses
                    Assertions.assertThat(parsed).isBetween(now.minusSeconds(5), now.plusSeconds(5));
                });
    }
}
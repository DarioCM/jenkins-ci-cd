package dev.dario.food.ordering.system.jenkinscicd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class JenkinsCiCdApplicationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGreetingsEndpoint() throws Exception {
    String name = "Dario Dario!";

    mockMvc.perform(
        MockMvcRequestBuilders.get("/greetings/{name}", name))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Hello " + name + " CI/CD demo"));
  }


}
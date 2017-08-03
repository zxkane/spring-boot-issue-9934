package com.github.zxkane.handler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Created by kane on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integTest")
//@AutoConfigureMockMvc
public class NoteHandlerTest {

    @Autowired
    private WebTestClient webClient;

//    @Autowired
//    private MockMvc mvc;


    @Test
    public void testGetNoteNotFound() throws Exception {
        this.webClient.get().uri("/note/request/{id}", "nosuchid").accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange().expectStatus().isNotFound();
//        mvc.perform(get("/internal/note/request/{id}", "nosuchid").accept(
//                MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isNotFound());
    }

}

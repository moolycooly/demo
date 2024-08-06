package com.example.demo.controllers;


import com.example.demo.models.TranslationRequest;
import com.example.demo.services.TranslationService;
import com.example.demo.сontollers.MainController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.stream.Stream;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MainControllerTest {
    @Mock
    private TranslationService translationService;

    @InjectMocks
    private MainController mainController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){

        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
        objectMapper = new ObjectMapper();
    }
    @ParameterizedTest
    @MethodSource("textAndLanguages")
    public void translateTest(String text, String source, String target, String translated) throws Exception {
        TranslationRequest translationRequest = new TranslationRequest(text,source,target,"127.0.0.1");
        when(translationService.translate(any())).thenReturn(translated);
        String translationRequestJson = objectMapper.writeValueAsString(translationRequest);
        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(translationRequestJson))
                .andExpect(status().isOk());
    }
    static Stream<Arguments> textAndLanguages() {
        return Stream.of(
                Arguments.of("Hello world!", "ru", "en", "Привет мир!"),
                Arguments.of("Привет мир!", "ru", "en", "Hello world!")
        );
    }


}

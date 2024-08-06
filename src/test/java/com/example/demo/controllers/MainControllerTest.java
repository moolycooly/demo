package com.example.demo.controllers;


import com.example.demo.models.TranslationRequest;
import com.example.demo.services.TranslationService;
import com.example.demo.сontollers.MainController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import java.util.List;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MainControllerTest {
//    @Mock
//    private TranslationService translationService;
//
//    @InjectMocks
//    private MainController mainController;
//
//    private MockMvc mockMvc;
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp(){
//
//        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
//        objectMapper = new ObjectMapper();
//    }
//    @ParameterizedTest
//    @MethodSource("textAndLanguages")
//    public void translateTest(String text, String source, String target) throws Exception {
//        when(translationService.translateText(anyString(),anyString(),anyString(),anyString())).thenReturn("some string");
//        TranslationRequest translationRequest = new TranslationRequest(text,source,target);
//        String translationRequestJson = objectMapper.writeValueAsString(translationRequest);
//        mockMvc.perform(post("/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(translationRequestJson))
//                .andExpect(status().isOk());
//    }
//    static Stream<Arguments> textAndLanguages() {
//        return Stream.of(
//                Arguments.of("У лукоморья дуб зеленый, Златая цепь на дубе том", "ru", "en"),
//                Arguments.of("Près du Lukomorye il y a un chêne vert, Une chaîne dorée sur le chêne", "fr", "ru"),
//                Arguments.of("ルコモリエのそばには緑の樫の木があり、樫の木には金色の鎖がかかっている", "ja", "fr"),
//                Arguments.of("Junto a Lukomorye hay un roble verde, una cadena de oro en el roble", "es", "ja"),
//                Arguments.of("Presso il Lukomorye c'è una quercia verde, Una catena d'oro sulla quercia", "it", "en")
//        );
//    }


}

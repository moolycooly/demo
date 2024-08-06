package com.example.demo.services;

import com.example.demo.models.TranslationRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)

public class TranslationServiceTest {

//    @Mock
//    private TranslationRequest translationRequestRepository;
//    @InjectMocks
//    private TranslationService translationService;
//    @Test
//    public void nonExistLangTest()  {
//        translationService.setRestTemplate(new RestTemplate());
//        Exception exception = assertThrows(Exception.class, () -> translationService.translateText(anyString(), "rr", "ru", "asdsad"));
//        String expectedMessage = "Не найден язык исходного сообщения";
//        String actualMessage = exception.getMessage();
//        assertTrue(actualMessage.contains(expectedMessage));
//    }


}

package com.example.demo.сontollers;

import com.example.demo.models.TranslationRequest;
import com.example.demo.services.TranslationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MainController {
    @Autowired
    private TranslationService translationService;
    @PostMapping
    public ResponseEntity<String> translate(@RequestBody TranslationRequest request,
                                            HttpServletRequest httpServletRequest) {

        request.setIpAddress(httpServletRequest.getRemoteAddr());

        try {
            String translatedText = translationService.translate(request);
            return ResponseEntity.ok(translatedText);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }

    }

}

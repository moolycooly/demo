package com.example.demo.services;

import com.example.demo.models.TranslationRequest;
import com.example.demo.repositories.TranslationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



@Service
public class TranslationService {
    @Autowired
    private TranslationRepository translationRepository;
    @Autowired
    private TranslationText translationText;

    public String translate(TranslationRequest request)  {

        String result;
        try {
            result = translationText.translateText(request.getText(),request.getSource(),request.getTarget());
        }
        catch (ResponseStatusException e) {
            throw e;
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        translationRepository.save(request.getIpAddress(),request.getText(),result);
        return result;

    }
}

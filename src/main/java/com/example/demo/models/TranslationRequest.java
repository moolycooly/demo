package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranslationRequest {
    private String text;
    private String source;
    private String target;

    private String ipAddress;

    public TranslationRequest(String text, String source, String target) {
        this.text = text;
        this.source = source;
        this.target = target;
    }

}


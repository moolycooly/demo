package com.example.demo.services;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class TranslationText {
    private final int MAX_THREADS = 10;
    private final ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);
    private final String TranslationURL = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=%s&tl=%s&hl=en&dt=t&q=%s";
    private final HashSet<String> languages = new HashSet<>(Arrays.asList(
            "aa", "ab", "af", "am", "an", "ar", "as", "ay", "az",
            "ba", "be", "bg", "bh", "bi", "bn", "bo", "br", "ca",
            "co", "cs", "cy", "da", "de", "dz", "el", "en", "eo",
            "es", "et", "eu", "fa", "fi", "fj", "fo", "fr", "fy",
            "ga", "gd", "gl", "gn", "gu", "gv", "ha", "he", "iw",
            "hi", "hr", "ht", "hu", "hy", "ia", "id", "in", "ie",
            "ii", "ik", "io", "is", "it", "iu", "ja", "jv", "ka",
            "kk", "kl", "km", "kn", "ko", "ks", "ku", "ky", "la",
            "li", "ln", "lo", "lt", "lv", "mg", "mi", "mk", "ml",
            "mn", "mo", "mr", "ms", "mt", "my", "na", "ne", "nl",
            "no", "oc", "om", "or", "pa", "pl", "ps", "pt", "qu",
            "rm", "rn", "ro", "ru", "rw", "sa", "sd", "sg", "sh",
            "si", "sk", "sl", "sm", "sn", "so", "sq", "sr", "ss",
            "st", "su", "sv", "sw", "ta", "te", "tg", "th", "ti",
            "tk", "tl", "tn", "to", "tr", "ts", "tt", "tw", "ug",
            "uk", "ur", "uz", "vi", "vo", "wa", "wo", "xh", "yi",
            "ji", "yo", "zh", "zu"));
    @Autowired
    private RestTemplate restTemplate;

    public String translateText(String text, String source, String target) throws Exception {
        if(text == null || source == null || target == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Одно из введеных полей пустое");
        }
        if (!languages.contains(source.toLowerCase())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Не найден язык: " + source);
        }
        if (!languages.contains(target.toLowerCase())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Не найден язык: " + target);
        }
        String[] words = text.split(" ");
        StringBuilder translatedText = new StringBuilder();
        List<Future<String>> futures = new ArrayList<>();
        for(String word : words) {
            Future<String> future = executorService.submit(() -> translateWord(word,source,target));
            futures.add(future);
        }
        for(Future<String> future : futures) {
            translatedText.append(future.get()).append(" ");
        }
        return translatedText.toString().trim();

    }
    private String translateWord(String word, String sourse, String target) throws Exception {
        String url = String.format(TranslationURL,sourse,target ,word);
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            String translated_word = new JSONArray(response.getBody()) .getJSONArray(0).getJSONArray(0).getString(0);
            return translated_word;
        }
        catch (Exception e) {
            throw new Exception("Ошибка доступа к ресурсу перевода");
        }
    }

}

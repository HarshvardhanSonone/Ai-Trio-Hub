package com.ai.SpringAi;


import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MovieService {

    public MovieService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    private final ChatModel chatModel;

    public String recommendMovie(String actor, String genre, String theme ,String country) {

        var template = """
                Recommend me 3-4  movies based on following aspect;
                the movie type i prefer{genre}.
                 Actor: {actor}
                 Theme: {theme      }
                kindly provide a basic plot of the movie in 2-3 line without spoilers , including title; 
                """;

        PromptTemplate promptTemplate = new PromptTemplate(template);

        Map<String, Object> params = Map.of(
                "actor", actor,
                "genre", genre,
                "theme", theme,
                "country", country
        );


        Prompt prompt = promptTemplate.create(params);

        System.out.println(chatModel.call(prompt).getResult().getOutput().getText());
        return chatModel.call(prompt).getResult().getOutput().getText();
    }
}

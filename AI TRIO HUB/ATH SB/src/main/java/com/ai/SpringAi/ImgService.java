package com.ai.SpringAi;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImgService {

private final OpenAiImageModel openAiImageModel;

    public ImgService(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }

    public ImageResponse generateImage(String prompt, String quality, int n, int width, int height ){


        ImageResponse imageResponse= openAiImageModel.call(

                        //new ImagePrompt("A light cream colored mini golden doodle",

//        ImageResponse imageResponse= openAiImageModel.call( // default mode dall e 3
                new ImagePrompt(prompt,
                        //new ImagePrompt("A light cream colored mini golden doodle",
                        OpenAiImageOptions.builder()
                                .model("dall-e-2")
                            //    .quality("high  ")
                                .N(3)
                                .height(1024)
                                .width(1024).build())
                );
        return imageResponse;
    }
}

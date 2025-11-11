package com.ai.SpringAi;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class AIController {


private final ChatService chatService;
private final ImgService imgService;
    private final MovieService movieService;
public AIController(ChatService chatService, ImgService imgService, MovieService movieService) {
        this.chatService = chatService;
        this.imgService = imgService;
    this.movieService = movieService;
}

    @GetMapping("ai")
    public String getResponse(@RequestParam String prompt){
        System.out.println(chatService.getResponse(prompt));
        return chatService.getResponse(prompt);
    }

    @GetMapping("ai-options")
    public String getResponseOptions(@RequestParam String prompt){
        System.out.println(chatService.getResponse(prompt));
        return chatService.getResponse(prompt);
    }

    @GetMapping("ai-img")
    public List<String> generateImages(HttpServletResponse response,
                                       @RequestParam String prompt,
                                       @RequestParam (value="quality",defaultValue = "hd") String quality,
                                       @RequestParam (value="3",defaultValue = "1") int n,
                                       @RequestParam (value="",defaultValue = "1024") int width,
                                       @RequestParam (value="",defaultValue = "1024") int height
    )
            throws IOException {
        System.out.println(chatService.getResponse(prompt));
   ImageResponse imgRes= imgService.generateImage(prompt,quality,width,height,n);

//  String ImgUrl= imgRes.getResult().getOutput().getUrl();
//      response.sendRedirect(ImgUrl);

        // Streams try krte h


        List<String> imgUrl= imgRes.getResults().stream()
                .map(result->result.getOutput().getUrl())
                .toList();

            return imgUrl;

    }

    @GetMapping("movie")
    public String movieRecommend(@RequestParam (defaultValue = "any") String actor,
                                       @RequestParam (defaultValue = "")String genre,
                                       @RequestParam  (defaultValue = "any")                  String theme,
                                 @RequestParam (defaultValue = "any") String country
                                       )
    {
        return movieService.recommendMovie(actor,genre,theme, country);

    }

}

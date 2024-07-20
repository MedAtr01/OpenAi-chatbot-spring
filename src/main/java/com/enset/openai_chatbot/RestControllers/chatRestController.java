package com.enset.openai_chatbot.RestControllers;

import com.enset.openai_chatbot.services.OpenAiService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class chatRestController {
    private final OpenAiService openAiService;
@PostMapping("/ask")
    public Mono<String> chat(@RequestBody ChatRequest request){
        return openAiService.getChatBotResponse(request.getMessage());

    }
  @Getter @Setter
    private static class ChatRequest{
        private String message;
  }
}

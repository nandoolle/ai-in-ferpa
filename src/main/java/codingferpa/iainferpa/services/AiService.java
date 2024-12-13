package codingferpa.iainferpa.services;

import codingferpa.iainferpa.providers.LangChainProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class AiService {

  private final LangChainProvider langChainProvider;

  public String respond(int id, String userMessage) {
    return langChainProvider.assistantWithMemory.chat(id, userMessage);
  }

  public String respond(String userMessage) {
    return langChainProvider.assistant.chat(userMessage);
  }

  public String respondWithDb(String userMessage) {
    return langChainProvider.assistantWithDb.chat(userMessage);
  }

  public String respondWithHttpApi(String userMessage) {
    return langChainProvider.assistantWithHttpApi.chat(userMessage);
  }

  public URI respondWithImage(String userMessage) {
    return langChainProvider.imageModel.generate(userMessage).content().url();
  }
}
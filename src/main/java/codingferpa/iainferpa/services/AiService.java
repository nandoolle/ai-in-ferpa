package codingferpa.iainferpa.services;

import codingferpa.iainferpa.providers.LangChainProvider;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.output.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

  public Response<Image> respondWithImage(String userMessage) {
    return langChainProvider.imageModel.generate(userMessage);
  }
}
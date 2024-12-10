package codingferpa.iainferpa.services;

import codingferpa.iainferpa.providers.AssistantProvider.*;
import codingferpa.iainferpa.providers.LangChainProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiService {

  private final Assistant assistant = LangChainProvider.assistant;
  private final AssistantWithMemory assistantWithMemory = LangChainProvider.assistantWithMemory;


  public String respond(int id, String userMessage) {
    return assistantWithMemory.chat(id, userMessage);
  }

  public String respond(String userMessage) {
    return assistant.chat(userMessage);
  }
}
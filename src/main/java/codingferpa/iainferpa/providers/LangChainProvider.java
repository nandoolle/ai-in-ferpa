package codingferpa.iainferpa.providers;

import codingferpa.iainferpa.repositories.ConversationRepository;
import codingferpa.iainferpa.tools.DbTool;
import codingferpa.iainferpa.tools.MailTool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import codingferpa.iainferpa.providers.AssistantProvider.*;
import org.springframework.stereotype.Component;

import static codingferpa.iainferpa.config.OpenAiConfig.gtp4o;

@Component
public class LangChainProvider {

  public final Assistant assistant = AiServices.builder(Assistant .class)
          .chatLanguageModel(gtp4o)
          .tools(new MailTool())
          .build();

  public final AssistantWithMemory assistantWithMemory = AiServices.builder(AssistantWithMemory.class)
          .chatLanguageModel(gtp4o)
          .tools(new MailTool())
          .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
          .build();

  public final AssistantWithDbAccess assistantWithDb;

  public LangChainProvider(ConversationRepository conversationRepository) {
    this.assistantWithDb = AiServices.builder(AssistantWithDbAccess.class)
            .chatLanguageModel(gtp4o)
            .tools(new DbTool(conversationRepository))
            .build();
  }
}

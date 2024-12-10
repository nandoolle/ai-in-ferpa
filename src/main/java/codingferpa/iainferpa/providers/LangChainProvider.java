package codingferpa.iainferpa.providers;

import codingferpa.iainferpa.tools.MailTool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import lombok.NoArgsConstructor;
import codingferpa.iainferpa.providers.AssistantProvider.*;

import static codingferpa.iainferpa.config.OpenAiConfig.openAiModel;

@NoArgsConstructor
public class LangChainProvider {
  public static final Assistant assistant = AiServices.builder(Assistant .class)
          .chatLanguageModel(openAiModel)
          .tools(new MailTool())
          .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
          .build();

  public static final AssistantWithMemory assistantWithMemory = AiServices.builder(AssistantWithMemory.class)
          .chatLanguageModel(openAiModel)
          .tools(new MailTool())
          .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
          .build();
}

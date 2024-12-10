package codingferpa.iainferpa.providers;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AssistantProvider {

  private static final String systemMessage = """
						Você é com um senso de humor ácido, debochado, e faz muito uso de sarcasmo para bolar piadas com emoji!
						Fã de Java e curte debochar de linguagens interpretadas como JavaScript e Python.
						Seu novo hobby é reclamar do sistema de tipos do TypeScript.
						""";

  public interface Assistant {
    @SystemMessage(systemMessage)
    String chat(@UserMessage String userMessage);
  }

  public interface AssistantWithMemory {
    @SystemMessage(systemMessage)
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
  }

  public interface AssistantWithDbAccess {
    @SystemMessage({
            systemMessage,
            "você deve salvar no banco de dados a sua `conversation` com um (long id, String name)"
    })
    String chat(@UserMessage String userMessage);
  }

}

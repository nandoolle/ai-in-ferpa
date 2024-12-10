package codingferpa.iainferpa.config;

import dev.langchain4j.model.openai.OpenAiChatModel;
import lombok.NoArgsConstructor;

import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_4_O_MINI;

@NoArgsConstructor
public class OpenAiConfig {
  public static final OpenAiChatModel gtp4o = OpenAiChatModel.builder()
          .apiKey(System.getenv("OPENAI_API_KEY"))
          .modelName(GPT_4_O_MINI)
          .strictTools(true)
          .build();
}

package codingferpa.iainferpa.config;

import dev.langchain4j.model.image.ImageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiImageModel;
import lombok.NoArgsConstructor;

import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_4_O_MINI;
import static dev.langchain4j.model.openai.OpenAiImageModelName.DALL_E_3;

@NoArgsConstructor
public class OpenAiConfig {
  private static final String OPENAI_API_KEY = System.getenv("OPENAI_API_KEY");

  public static final OpenAiChatModel gtp4o = OpenAiChatModel.builder()
          .apiKey(OPENAI_API_KEY)
          .modelName(GPT_4_O_MINI)
          .strictTools(true)
          .build();

  public static final ImageModel dallE3 = OpenAiImageModel.builder()
          .apiKey(OPENAI_API_KEY)
          .modelName(DALL_E_3)
          .build();
}

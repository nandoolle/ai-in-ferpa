package codingferpa.iainferpa.controllers;

import dev.langchain4j.model.output.structured.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Description("Query para salvar dados")
public class ConversationDto {

  @Description("Campo `id`")
  public long id;

  @Description("Campo `name`")
  public String name;
}
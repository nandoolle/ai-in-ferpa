package codingferpa.iainferpa.controllers;

import dev.langchain4j.model.output.structured.Description;


@Description("Query para salvar dados")
public record ConversationDto(
  @Description("Campo `id`") long id,
  @Description("Campo `name`") String name
) {}
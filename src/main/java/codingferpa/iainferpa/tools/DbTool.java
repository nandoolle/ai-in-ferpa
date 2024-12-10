package codingferpa.iainferpa.tools;

import codingferpa.iainferpa.controllers.ConversationDto;
import codingferpa.iainferpa.repositories.ConversationRepository;
import codingferpa.iainferpa.repositories.entities.Conversation;
import dev.langchain4j.agent.tool.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DbTool {

  private final ConversationRepository repository;

  @Tool("salve mensagem no banco")
  void save(ConversationDto dto) {
    System.out.println("salvando no banco . . . ");

    repository.save(new Conversation(dto.id(), dto.name()));
  }

  @Tool("busca mensagens no banco")
  List<ConversationDto> get(ConversationDto dto) {
    System.out.println("buscando no banco . . . ");

    var conversations = repository.findAll();

    return conversations.stream().map(entity -> new ConversationDto(entity.id, entity.name)).toList();
  }

}

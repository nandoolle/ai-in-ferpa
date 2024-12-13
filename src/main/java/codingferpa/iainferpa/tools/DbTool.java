package codingferpa.iainferpa.tools;

import codingferpa.iainferpa.repositories.ConversationRepository;
import codingferpa.iainferpa.repositories.entities.Conversation;
import dev.langchain4j.agent.tool.Tool;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DbTool {

  private final ConversationRepository repository;

  @Tool("salve mensagem no banco")
  void save(Conversation entity) {
    System.out.println("salvando no banco . . . ");

    repository.save(entity);
  }

  @Tool("busca mensagens no banco")
  List<Conversation> get() {
    System.out.println("buscando no banco . . . ");

    return repository.findAll();
  }

}

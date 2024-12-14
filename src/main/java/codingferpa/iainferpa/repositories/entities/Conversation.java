package codingferpa.iainferpa.repositories.entities;

import dev.langchain4j.model.output.structured.Description;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Description("Query para salvar dados")
@Table(name = "conversations")
public class Conversation {
  @Id @Description("Campo `id`") long id;
  @Description("Campo `name`") String name;
}

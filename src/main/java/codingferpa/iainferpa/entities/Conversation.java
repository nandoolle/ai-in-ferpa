package codingferpa.iainferpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conversations")
public class Conversation {
  @Id
  public long id;
  public String name;
}

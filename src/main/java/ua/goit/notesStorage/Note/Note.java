package ua.goit.notesStorage.Note;

import ua.goit.notesStorage.BaseEntity;
import ua.goit.notesStorage.authorization.User;
import ua.goit.notesStorage.enums.AccessTypes;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Data
@ToString(exclude = "author")
@EqualsAndHashCode(exclude = "author")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "notes")
public class Note implements BaseEntity<UUID> {

    private static final long serialVersionUID = 4044714827569083806L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotBlank(message = "The note's name cannot be empty")
    @Size(min = 5, max = 100, message = "The note's name must be between {min} and {max} characters long")
    private String name;

    @NotBlank(message = "The note's text cannot be empty")
    @Size(min = 5, max = 10_000, message = "The note's text must be between {min} and {max} characters long")
    private String message;

    @Enumerated(EnumType.STRING)
    private AccessTypes accessType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public String getAuthorName(){
        return author != null ? author.getUsername() : "";
    }

    public Note(String id,String name, String message, AccessTypes accessType) {
        this.name = name;
        this.message = message;
        this.accessType = accessType;
        this.id = UUID.fromString(id);
    }

}

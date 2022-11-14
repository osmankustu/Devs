package kodlama.io.Devs.entites;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id ;
    @Column(name="name")
    private String name;
    @OneToMany
    @JoinColumn(name="lanugageId")
    private List<Framework> frameworks;
}

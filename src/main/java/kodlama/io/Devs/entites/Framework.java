package kodlama.io.Devs.entites;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Framework")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Framework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id ;
    @Column(name="name")
    private String name;
    @Column(name="languageId")
    private int languageId;

}

package organice.lembrete;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "lembrete")
@EqualsAndHashCode(of="id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class LembreteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_lembrete")
    private String id;

    @Column(name = "lembrete_title")
    private String title;

    @Column(name = "lembrete_description")
    private String description;

    @Column(name = "lembrete_id_user")
    private String idUser;

    @Column(name = "lembrete_inicio")
    private Date inicio;

    @Column(name = "lembrete_fim")
    private Date fim;


    public LembreteModel(Lembrete in){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            
            this.id = in.id();
            this.title = in.title();
            this.description = in.description();
            this.idUser = in.idUser();
            this.inicio = formatter.parse(in.inicio());
            this.fim = formatter.parse(in.fim());
        } catch (Exception e) {
            System.out.println("Não funfou: Lembrete virando Model");
        }
    } 

    public  Lembrete to(){
        return Lembrete.builder()
            .id(id)
            .title(title)
            .description(description)
            .idUser(idUser)
            .inicio(inicio.toString())
            .fim(fim.toString())
            .build();
    }
}

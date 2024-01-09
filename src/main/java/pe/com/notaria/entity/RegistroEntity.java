
package pe.com.notaria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.com.notaria.entity.base.BaseEntity;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "RegistroEntity")
@Table(name = "t_registro")

public class RegistroEntity extends BaseEntity implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codreg")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "fecreg")
    @NotEmpty
    @Size(min =10, max=25, message = "la fecha del registro tiene que estar entre {min} y {max}")
    private String fecharegistro;
    @Column(name = "codser")
    @NotEmpty
    @Size(min =10, max=25, message = "la fecha del registro tiene que estar entre {min} y {max}")
    private int codser;
    @Column(name = "codemp")
    @NotEmpty
    @Size(min =10, max=25, message = "la fecha del registro tiene que estar entre {min} y {max}")
    private int codemp;
    @Column(name = "codcli")
    @NotEmpty
    @Size(min =10, max=25, message = "la fecha del registro tiene que estar entre {min} y {max}")
    private int codcli;
}

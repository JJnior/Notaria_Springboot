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
@Entity(name = "ServicioEntity")
@Table(name = "t_servicios")
public class ServicioEntity extends BaseEntity implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nomser")
    @NotEmpty
    @Size (min=8, max=20, message = "El nombre del servicio tiene que estar entre {min} y {max}")
    private String nombreServ;
    @NotEmpty
    @Size (min=8, max=20, message = "El precio del servicio tiene que estar entre {min} y {max}")
    @Column(name = "preser")
    private int precioServ;
}

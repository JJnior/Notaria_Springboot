package pe.com.notaria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.notaria.entity.RegistroEntity;

public interface RegistroRepository extends JpaRepository<RegistroEntity, Long>{
    @Query("select f from RegistroEntity f where f.estado=true")
    List<RegistroEntity> findAllCustom();
}

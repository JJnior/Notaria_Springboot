package pe.com.notaria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.notaria.entity.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Long>{
    @Query("select r from RolEntity r where r.estado=true")
    List<RolEntity> findAllCustom();
}

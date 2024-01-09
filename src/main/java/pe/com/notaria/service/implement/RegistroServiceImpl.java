package pe.com.notaria.service.implement;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.notaria.entity.RegistroEntity;
import pe.com.notaria.entity.RolEntity;
import pe.com.notaria.repository.RegistroRepository;
import pe.com.notaria.service.gestion.RegistroService;

@Service
public class RegistroServiceImpl implements RegistroService{

    @Autowired
    private RegistroRepository repositorio;
    
    @Override
    public List<RegistroEntity> findAll() {
      return repositorio.findAll();
    }

    @Override
    public List<RegistroEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<RegistroEntity> findById(Long id) {
         return repositorio.findById(id);
    }

    @Override
    public RegistroEntity add(RegistroEntity t) {
       return repositorio.save(t);
    }

    @Override
    public RegistroEntity update(RegistroEntity t) {
        RegistroEntity objregistro = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objregistro);
        return repositorio.save(objregistro);
    }

    @Override
    public RegistroEntity delete(RegistroEntity t) {
         RegistroEntity objregistro = repositorio.getById(t.getCodigo());
        objregistro.setEstado(false);
        return repositorio.save(objregistro);
    }

    @Override
    public RegistroEntity enable(RegistroEntity t) {
        RegistroEntity objregistro = repositorio.getById(t.getCodigo());
        objregistro.setEstado(true);
        return repositorio.save(objregistro);
   
    }

    
}

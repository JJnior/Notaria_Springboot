package pe.com.notaria.service.implement;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.notaria.entity.ServicioEntity;
import pe.com.notaria.repository.ServicioRepository;
import pe.com.notaria.service.gestion.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService{

    @Autowired
    private ServicioRepository repositorio;

    @Override
    public List<ServicioEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ServicioEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<ServicioEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public ServicioEntity add(ServicioEntity t) {
        return repositorio.save(t);
    }

    @Override
    public ServicioEntity update(ServicioEntity t) {
        ServicioEntity objservicio = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objservicio);
        return repositorio.save(objservicio);
    }

    @Override
    public ServicioEntity delete(ServicioEntity t) {
        ServicioEntity objservicio = repositorio.getById(t.getCodigo());
        objservicio.setEstado(false);
        return repositorio.save(objservicio);
    }

    @Override
    public ServicioEntity enable(ServicioEntity t) {
        ServicioEntity objservicio = repositorio.getById(t.getCodigo());
        objservicio.setEstado(true);
        return repositorio.save(objservicio);
    }
    
}

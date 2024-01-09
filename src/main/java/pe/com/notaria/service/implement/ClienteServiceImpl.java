package pe.com.notaria.service.implement;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.notaria.entity.ClienteEntity;
import pe.com.notaria.repository.ClienteRepository;
import pe.com.notaria.service.seguridad.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository repositorio;
    
    @Override
    public List<ClienteEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ClienteEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

        @Override
    public Optional<ClienteEntity> findById(Long id) {
        return repositorio.findById(id);
    }    

    @Override
    public ClienteEntity add(ClienteEntity t) {
        return repositorio.save(t);
    }

    @Override
    public ClienteEntity update(ClienteEntity t) {
        ClienteEntity objcli = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcli);
        return repositorio.save(objcli);
    }

    @Override
    public ClienteEntity delete(ClienteEntity t) {
        ClienteEntity objcli = repositorio.getById(t.getCodigo());
        objcli.setEstado(false);
        return repositorio.save(objcli);
    }

    @Override
    public ClienteEntity enable(ClienteEntity t) {
        ClienteEntity objcli = repositorio.getById(t.getCodigo());
        objcli.setEstado(true);
        return repositorio.save(objcli);
    }
    
}

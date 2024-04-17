package organice.lembrete;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class LembreteService {
    
    @Autowired
    private LembreteRepository lembreteRepository;

    public Lembrete create(Lembrete in) {
        
        return lembreteRepository.save(new LembreteModel(in)).to();
    }

    public Lembrete read(@NonNull String id) {
        return lembreteRepository.findById(id).map(LembreteModel::to).orElse(null);
    }

    public Lembrete update(String idUser, String id) {
        return lembreteRepository.findByIdUserAndId(idUser, id).map(LembreteModel::to).orElse(null);
    }

    public List<Lembrete> getByData(String idUser, String data){
        return lembreteRepository.findByIdUserAndInicio(idUser, data).stream().map(LembreteModel::to).collect(Collectors.toList());
    }
}

package organice.lembrete;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<Lembrete> getByData(String idUser, Date data){
        List<LembreteModel> lembretes = lembreteRepository.findByIdUserAndInicio(idUser, data);

        List<Lembrete> saida = new ArrayList<Lembrete>();

        for(LembreteModel i : lembretes){
            Lembrete l = i.to();
            saida.add(l);
        }

        return saida;
    }
}

package organice.lembrete;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LembreteRepository extends CrudRepository<LembreteModel, String> {
    
    Optional<LembreteModel> findByIdUserAndId(String idUser, String id);

    
}

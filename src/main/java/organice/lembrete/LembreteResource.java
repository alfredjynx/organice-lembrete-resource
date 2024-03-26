package organice.lembrete;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class LembreteResource implements LembreteController {

    @Autowired
    private LembreteService lembreteService;

    @Override
    public ResponseEntity<LembreteOut> create(LembreteIn in) {
        // parser
        Lembrete lembrete = LembreteParser.to(in);
        // insert using service
        lembrete = lembreteService.create(lembrete);
        // return
        return ResponseEntity.created(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(lembrete.id())
                .toUri())
            .body(LembreteParser.to(lembrete));
    }

    @Override
    public ResponseEntity<LembreteOut> update(String id, LembreteIn in) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    @Override
    public ResponseEntity<LembreteOut> read(String id) {
        final LembreteOut lembrete = LembreteParser.to(lembreteService.read(id));
        return ResponseEntity.ok(lembrete);
    }
    
}

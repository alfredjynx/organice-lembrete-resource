package organice.lembrete;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Lembrete", description = "API de Lembretes")
public class LembreteResource implements LembreteController {

    @Autowired
    private LembreteService lembreteService;

    @Override
    @Operation(summary = "Criar um novo lembrete", description = "Cria um novo lembrete e retorna o objeto criado com seu ID.")
    public ResponseEntity<LembreteOut> create(String UserId, LembreteIn in) {
        // parser
        Lembrete lembrete = LembreteParser.to(in, UserId);
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
    @Operation(summary = "Acessa um lembrete", description = "Acessa um lembrete e retorna o objeto criado com seu ID.")
    public ResponseEntity<LembreteOut> read(String id) {
        final LembreteOut lembrete = LembreteParser.to(lembreteService.read(id));
        return ResponseEntity.ok(lembrete);
    }

    @Override
    @Operation(summary = "Rota de Teste", description = "Rota de Teste, retorna 'situação complicada' sempre")
    public ResponseEntity<String> read_teste() {
        return ResponseEntity.ok("Situação Complicada");
    }

    @Override
    @Operation(summary = "Retorna todos os lembretes de um usuário em certa data", description = "Retorna todos os lembretes de um usuário em certa data")
    public ResponseEntity<List<LembreteOut>> getByDate(String UserId, LembreteDateIn data) {

        List<Lembrete> lembretes = lembreteService.getByData(UserId, data.data());

        if(lembretes == null){
            return ResponseEntity.notFound().build();
        }

        List<LembreteOut> saida = new ArrayList<>();

        for(Lembrete i : lembretes){
            saida.add(LembreteParser.to(i));
        }
        
        return ResponseEntity.ok(saida);
    }
    
}

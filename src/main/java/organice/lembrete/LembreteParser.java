package organice.lembrete;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class LembreteParser {

    public static Lembrete to(LembreteIn in, String UserId) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            return Lembrete.builder()
                .title(in.title())
                .description(in.description())
                .idUser(UserId)
                .inicio(formatter.parse(in.inicio()))
                .fim(formatter.parse(in.fim()))
                .build();
        } catch (Exception e) {
            return null;
        }
        
    }

    public static LembreteOut to(Lembrete lembrete) {
        return LembreteOut.builder()
        .title(lembrete.title())
        .description(lembrete.description())
        .inicio(lembrete.inicio())
        .fim(lembrete.fim())
        .id(lembrete.id())
        .build();
    }
}

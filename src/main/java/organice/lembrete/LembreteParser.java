package organice.lembrete;

public class LembreteParser {

    public static Lembrete to(LembreteIn in, String UserId) {
        return Lembrete.builder()
            .title(in.title())
            .description(in.description())
            .idUser(UserId)
            .inicio(in.inicio())
            .fim(in.fim())
            .build();
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

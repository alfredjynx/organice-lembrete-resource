CREATE TABLE lembrete
(
    id_lembrete character varying(36) NOT NULL,
    lembrete_title character varying(256) NOT NULL,
    lembrete_description character varying(256) NOT NULL,
    lembrete_id_user character varying(256) NOT NULL,
    lembrete_inicio character varying(256) NOT NULL,
    lembrete_fim character varying(256) NOT NULL,
    CONSTRAINT lembretes_pkey PRIMARY KEY (id_lembrete)
);
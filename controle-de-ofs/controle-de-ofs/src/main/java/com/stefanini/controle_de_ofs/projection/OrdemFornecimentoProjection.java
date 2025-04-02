package com.stefanini.controle_de_ofs.projection;

import java.time.LocalDate;

public interface OrdemFornecimentoProjection {
    Integer getCodigo();
    String getDescription();
    String getStatus();
    LocalDate getCreated_at();
    LocalDate getUdated_at();
    String getCollaborator();
}

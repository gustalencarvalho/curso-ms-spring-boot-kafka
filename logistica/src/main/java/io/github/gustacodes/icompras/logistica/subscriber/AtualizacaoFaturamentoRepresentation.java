package io.github.gustacodes.icompras.logistica.subscriber;

import io.github.gustacodes.icompras.logistica.model.StatusPedido;

public record AtualizacaoFaturamentoRepresentation(
        Long codigo,
        StatusPedido status,
        String urlNotaFiscal
) {
}

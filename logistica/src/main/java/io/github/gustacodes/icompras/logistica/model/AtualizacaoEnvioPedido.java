package io.github.gustacodes.icompras.logistica.model;

public record AtualizacaoEnvioPedido(
        Long codigo,
        StatusPedido status,
        String codigoRastreio
) {
}

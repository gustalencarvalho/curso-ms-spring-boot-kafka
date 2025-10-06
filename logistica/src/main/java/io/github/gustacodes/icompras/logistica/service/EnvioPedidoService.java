package io.github.gustacodes.icompras.logistica.service;

import io.github.gustacodes.icompras.logistica.model.AtualizacaoEnvioPedido;
import io.github.gustacodes.icompras.logistica.model.StatusPedido;
import io.github.gustacodes.icompras.logistica.publisher.EnvioPedidoPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class EnvioPedidoService {

    private final EnvioPedidoPublisher publisher;

    public void enviar(Long codigoPedido, String urlNotaFiscal) {
        var codigoRastreio = gerarCodigoRastreio();
        var atualizacaoRepresentation = new AtualizacaoEnvioPedido(codigoPedido, StatusPedido.ENVIADO, codigoRastreio);
        publisher.enviar(atualizacaoRepresentation);
    }

    private String gerarCodigoRastreio() {
        var random = new Random();
        char letraUm = (char) ('A' + random.nextInt(26));
        char letraDois = (char) ('A' + random.nextInt(26));
        int numeros = 100000000 + random.nextInt(900000000);
        return "" + letraUm + letraDois + numeros + "BR";
    }
}

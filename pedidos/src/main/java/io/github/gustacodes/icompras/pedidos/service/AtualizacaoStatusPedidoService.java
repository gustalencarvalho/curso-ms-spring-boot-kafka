package io.github.gustacodes.icompras.pedidos.service;

import io.github.gustacodes.icompras.pedidos.model.enums.StatusPedido;
import io.github.gustacodes.icompras.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoService {

    private final PedidoRepository pedidoRepository;

    @Transactional
    public void atualizarStatus(Long codigo, StatusPedido status, String urlNotaFiscal, String rastreio) {
        pedidoRepository.findById(codigo).ifPresent(pedido -> {
            pedido.setStatus(status);
            pedido.setUrlNotaFiscal(urlNotaFiscal);
            pedido.setCodigoRastreio(rastreio);
        });
    }

}

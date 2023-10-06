package br.tec.db.servicoguincho.simulador;

import br.tec.db.servicoguincho.simulador.cargas.EstadoConservacao;
import br.tec.db.servicoguincho.simulador.cargas.TipoVeiculo;

public interface Veiculo {
    TipoVeiculo getTipo();
    EstadoConservacao getEstado();
}

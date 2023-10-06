package br.tec.db.servicoguincho.simulador.cargas;

import br.tec.db.servicoguincho.simulador.Guincho;
import br.tec.db.servicoguincho.simulador.SimuladorDeOrcamento;
import br.tec.db.servicoguincho.simulador.Trajeto;
import br.tec.db.servicoguincho.simulador.Veiculo;

public class SimuladorDeOrcamentoImpl implements SimuladorDeOrcamento {
    private Guincho guincho;

    public SimuladorDeOrcamentoImpl (Guincho guincho) {
        this.guincho = guincho;
    }

    public SimuladorDeOrcamentoImpl() {

    }

    @Override
    public double calcularCustoTotal(Veiculo veiculo, Trajeto trajeto) {
        double custoDeslocamento = guincho.calcularCustoDeslocamento(trajeto);
        double custoTotal = custoDeslocamento;

        // Aplicar descontos ou taxas adicionais com base no tipo de veículo e estado de conservação, se necessário
        if (veiculo.getTipo() == TipoVeiculo.CAMINHAO) {
            // Veículo pesado
            custoTotal += 100.0; // Taxa fixa adicional para caminhões
        }

        if (veiculo.getEstado() == EstadoConservacao.QUEBRADO) {
            // Veículo quebrado
            custoTotal += 50.0; // Taxa fixa adicional para veículos quebrados
        }

        return custoTotal;

    }
}

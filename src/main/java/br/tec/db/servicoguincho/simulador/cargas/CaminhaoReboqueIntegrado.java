package br.tec.db.servicoguincho.simulador.cargas;

import br.tec.db.servicoguincho.simulador.Guincho;
import br.tec.db.servicoguincho.simulador.Trajeto;

public class CaminhaoReboqueIntegrado implements Guincho {
    private static final double TaxaDeDeslocamento = 10.0; // Taxa deslocamento 10 reais por km

    @Override
    public double calcularCustoDeslocamento(Trajeto trajeto) {
        return TaxaDeDeslocamento * trajeto.getDistanciaEmKM();
    }
}

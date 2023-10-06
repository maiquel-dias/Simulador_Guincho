package br.tec.db.servicoguincho.simulador.cargas;

import br.tec.db.servicoguincho.simulador.Guincho;
import br.tec.db.servicoguincho.simulador.Trajeto;

public class CaminhaoCorrenteGancho implements Guincho {
    private static final double TaxaDeDeslocamento = 2.0;

    @Override
    public double calcularCustoDeslocamento(Trajeto trajeto) {
        return TaxaDeDeslocamento * trajeto.getDistanciaEmKM();
    }
}


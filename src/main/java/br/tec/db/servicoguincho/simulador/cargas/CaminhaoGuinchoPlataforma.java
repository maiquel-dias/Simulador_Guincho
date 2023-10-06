package br.tec.db.servicoguincho.simulador.cargas;

import br.tec.db.servicoguincho.simulador.Guincho;
import br.tec.db.servicoguincho.simulador.Trajeto;

public class CaminhaoGuinchoPlataforma implements Guincho {
    private static final double TaxaDeDeslocamento = 5.0; //Taxa deslocamento 5 reais por km

    @Override
    public double calcularCustoDeslocamento(Trajeto trajeto) {
        return TaxaDeDeslocamento * trajeto.getDistanciaEmKM();
    }
}

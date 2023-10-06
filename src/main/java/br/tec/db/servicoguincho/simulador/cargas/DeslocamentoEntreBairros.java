package br.tec.db.servicoguincho.simulador.cargas;

import br.tec.db.servicoguincho.simulador.Trajeto;

public class DeslocamentoEntreBairros implements Trajeto {
    private int distanciaEmKM;

    public DeslocamentoEntreBairros (int distanciaEmKM){

        this.distanciaEmKM = distanciaEmKM;
    }

    @Override
    public Integer getDistanciaEmKM() {
        return distanciaEmKM;
    }
}

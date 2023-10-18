package br.tec.db.servicoguincho.simulador.cargas;

import br.tec.db.servicoguincho.simulador.cargas.EstadoConservacao;
import br.tec.db.servicoguincho.simulador.cargas.SimuladorDeOrcamentoImpl;
import br.tec.db.servicoguincho.simulador.cargas.TipoVeiculo;
import br.tec.db.servicoguincho.simulador.cargas.VeiculoImpl;
import br.tec.db.servicoguincho.simulador.cargas.CaminhaoCorrenteGancho;
import br.tec.db.servicoguincho.simulador.cargas.CaminhaoGuinchoPlataforma;
import br.tec.db.servicoguincho.simulador.cargas.CaminhaoReboqueIntegrado;
import br.tec.db.servicoguincho.simulador.cargas.DeslocamentoEntreBairros;
import br.tec.db.servicoguincho.simulador.SimuladorDeOrcamento;
import br.tec.db.servicoguincho.simulador.Trajeto;
import br.tec.db.servicoguincho.simulador.Veiculo;
import br.tec.db.servicoguincho.simulador.Guincho;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("************** Simulador de Serviço de Guincho **************");
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Calcular custo de serviço de guincho");
                System.out.println("0 - Sair");

                int escolha = scanner.nextInt();

                if (escolha == 0) {
                    System.out.println("Saindo do programa.");
                    break;
                } else if (escolha == 1) {
                    calcularCustoServicoGuincho(scanner);
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada Inválida. Por favor, digite um número.");
                scanner.next(); // Limpar o buffer de entrada.
            }
        }

        scanner.close();
    }

    private void calcularCustoServicoGuincho(Scanner scanner) {
        try {
            System.out.println("Escolha o tipo de veículo que deseja transportar:");
            System.out.println("1 - Carro");
            System.out.println("2 - MiniVan");
            System.out.println("3 - Ônibus");
            System.out.println("4 - Caminhão");

            int tipoVeiculoEscolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            TipoVeiculo tipoVeiculo;

            if (tipoVeiculoEscolha < 1 || tipoVeiculoEscolha > 4) {
                System.out.println("Tipo de veículo inválido. Tente novamente.");
                return;
            } else {
                tipoVeiculo = TipoVeiculo.values()[tipoVeiculoEscolha - 1];
            }

            System.out.println("Escolha o estado do veículo:");
            System.out.println("1 - Novo");
            System.out.println("2 - Quebrado");

            int estadoVeiculoEscolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            EstadoConservacao estadoVeiculo;

            if (estadoVeiculoEscolha != 1 && estadoVeiculoEscolha != 2) {
                System.out.println("Estado do veículo inválido. Tente novamente.");
                return;
            } else {
                estadoVeiculo = (estadoVeiculoEscolha == 1) ? EstadoConservacao.NOVO : EstadoConservacao.QUEBRADO;
            }

            System.out.println("Escolha o trajeto entre bairros:");
            System.out.println("1 - C para C (e vice-versa): 5 km");
            System.out.println("2 - A para B (e vice-versa): 8 km");
            System.out.println("3 - C para A (e vice-versa): 10 km");
            System.out.println("4 - C para B (e vice-versa): 15 km");

            int trajetoEscolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            int distanciaEmKM = 0;

            switch (trajetoEscolha) {
                case 1:
                    distanciaEmKM = 5;
                    break;
                case 2:
                    distanciaEmKM = 8;
                    break;
                case 3:
                    distanciaEmKM = 10;
                    break;
                case 4:
                    distanciaEmKM = 15;
                    break;
                default:
                    System.out.println("Escolha de trajeto inválida.");
                    return;
            }

            Guincho guincho;
            String tipoGuinchoIdeal;

            if (estadoVeiculo == EstadoConservacao.QUEBRADO) {
                guincho = new CaminhaoCorrenteGancho();
                tipoGuinchoIdeal = "Caminhão de corrente e gancho";
            } else if (tipoVeiculo == TipoVeiculo.CAMINHAO) {
                guincho = new CaminhaoReboqueIntegrado();
                tipoGuinchoIdeal = "Caminhão de reboque integrado";
            } else if (tipoVeiculo == TipoVeiculo.MINIVAN || tipoVeiculo == TipoVeiculo.CARRO) {
                guincho = new CaminhaoGuinchoPlataforma();
                tipoGuinchoIdeal = "Caminhão guincho de plataforma";
            } else {
                System.out.println("Tipo de veículo não suportado.");
                return;
            }

            Trajeto trajeto = new DeslocamentoEntreBairros(distanciaEmKM);
            Veiculo veiculo = new VeiculoImpl(tipoVeiculo, estadoVeiculo);
            SimuladorDeOrcamento simulador = new SimuladorDeOrcamentoImpl(guincho);

            double custoTotal = simulador.calcularCustoTotal(veiculo, trajeto);

            System.out.println("Custo total do orçamento: R$" + custoTotal);
            System.out.println("Tipo de guincho ideal: " + tipoGuinchoIdeal);

        } catch (InputMismatchException e) {
            System.out.println("Entrada Inválida. Por favor, digite um número.");
            scanner.next(); // Limpar o buffer de entrada
        }
    }
}

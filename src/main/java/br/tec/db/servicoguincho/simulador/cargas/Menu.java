package br.tec.db.servicoguincho.simulador.cargas;


import br.tec.db.servicoguincho.simulador.Guincho;
import br.tec.db.servicoguincho.simulador.SimuladorDeOrcamento;
import br.tec.db.servicoguincho.simulador.Trajeto;
import br.tec.db.servicoguincho.simulador.Veiculo;

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

            TipoVeiculo tipoVeiculo = TipoVeiculo.values()[tipoVeiculoEscolha - 1];

            System.out.println("Escolha o estado do veículo:");
            System.out.println("1 - Novo");
            System.out.println("2 - Quebrado");

            int estadoVeiculoEscolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            EstadoConservacao estadoVeiculo = (estadoVeiculoEscolha == 1) ? EstadoConservacao.NOVO : EstadoConservacao.QUEBRADO;

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

            System.out.println("Escolha o tipo de guincho:");
            System.out.println("1 - Caminhão de corrente e gancho");
            System.out.println("2 - Caminhão de reboque integrado");
            System.out.println("3 - Caminhão guincho de plataforma");

            int guinchoEscolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            Guincho guincho;

            switch (guinchoEscolha) {
                case 1:
                    guincho = new CaminhaoCorrenteGancho();
                    break;
                case 2:
                    guincho = new CaminhaoReboqueIntegrado();
                    break;
                case 3:
                    guincho = new CaminhaoGuinchoPlataforma();
                    break;
                default:
                    System.out.println("Escolha de guincho inválida.");
                    return;
            }

            Trajeto trajeto = new DeslocamentoEntreBairros(distanciaEmKM);
            Veiculo veiculo = new VeiculoImpl(tipoVeiculo, estadoVeiculo);
            SimuladorDeOrcamento simulador = new SimuladorDeOrcamentoImpl(guincho);

            double custoTotal = simulador.calcularCustoTotal(veiculo, trajeto);
            System.out.println("Custo total do orçamento: R$" + custoTotal);

        } catch (InputMismatchException e) {
            System.out.println("Entrada Inválida. Por favor, digite um número.");
            scanner.next(); // Limpar o buffer de entrada
        }
    }
}

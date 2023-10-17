# Simulador_Guincho
Desafio de OOP para um Simulador de Orçamento de Guincho
Você está encarregado de desenvolver um sistema de simulação para um serviço de guincho que atende diversos tipos de veículos em uma cidade com 3 bairros.

Os três tipos de guinchos disponíveis são:

Caminhão de corrente e gancho: Mais barato e utilizado para veículos quebrados. Taxa de deslocamento: R$ 2,00 por quilômetro.
Caminhão de reboque integrado: Utilizado para veículos mais pesados. Taxa de deslocamento: R$ 10,00 por quilômetro.
Caminhão guincho de plataforma: Utilizado para veículos leves. Taxa de deslocamento: R$ 5,00 por quilômetro.
Os tipos de veículos a serem considerados são:

Carro (leve)
MiniVan (leve)
Ônibus (pesado)
Caminhão (pesado)
Cada veículo pode estar em um dos seguintes estados de conservação:

Novo
Quebrado
Bairros
A cidade possui 3 bairros:

Centro (Bairro C)
Bairro A
Bairro B
Tabela de Deslocamento (Deslocamento em quilômetros por trajeto)
Há uma tabela de deslocamento em quilômetros entre os bairros:

C para C (e vice-versa): 5 km
A para B (e vice-versa): 8 km
C para A (e vice-versa): 10 km
C para B (e vice-versa): 15 km
Estrutura do código
Este repositório já possui uma estrutura inicial que você deve seguir. Segue abaixo a descrição rápida de cada um dos elementos da estrutura.

// Enum para tipos de veículos
enum TipoVeiculo {
    CARRO, MINIVAN, ONIBUS, CAMINHAO
}

// Enum para estados de conservação
enum EstadoConservacao {
    NOVO, QUEBRADO
}

// Interface para trajetos entre bairros
interface Trajeto {
    Integer getDistanciaEmKM();
}

// Interface para tipos de guincho
interface Guincho {
    double calcularCustoDeslocamento(Trajeto trajeto);
}

// Interface para tipos de veículos
interface Veiculo {
    TipoVeiculo getTipo();
    EstadoConservacao getEstado();
}

// Interface para calcular o custo total do orcamento
interface SimuladorDeOrcamento {
    double calcularCustoTotal(Veiculo veiculo, Trajeto trajeto);
}

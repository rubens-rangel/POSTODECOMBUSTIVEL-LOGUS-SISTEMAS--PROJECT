package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import domain.BombaCombustivel;
import domain.Combustivel;
import domain.Veiculo;
import services.Abastecimento;
import services.LeituraCSV;

public class MainApplication {

	public static void main(String[] args) {
		
		  List<Veiculo> veiculos = LeituraCSV.lerVeiculos();
		  
		//Tipo de Combustivel
		Combustivel gasolina = new Combustivel("GASOLINA", 2.90);
		Combustivel etanol = new Combustivel("ETANOL", 2.27);
		
        // Simular o abastecimento dos veículos
		BombaCombustivel bombaGasolina = new BombaCombustivel("GASOLINA", 10); // Preço e velocidade da bomba de gasolina
		BombaCombustivel bombaEtanol = new BombaCombustivel("ETANOL", 12); // Preço e velocidade da bomba de etanol
		
//		List<BombaCombustivel> bombasList = new ArrayList<>();
//		bombasList.add(bombaGasolina);
//		bombasList.add(bombaEtanol);
		
		
        List<String> eventos = Abastecimento.simularAbastecimento(veiculos, bombaGasolina, bombaEtanol);

        // Imprimir os resultados da simulação
        System.out.println("Resultado da simulação\n---------------------------");
        for (String evento : eventos) {
            System.out.println(evento);
        }

        // Imprimir o resumo da simulação
        System.out.println("\nResumo da simulação\n---------------------------");
        System.out.println(bombaGasolina.getResumo());
        System.out.println(bombaEtanol.getResumo());
    }

}

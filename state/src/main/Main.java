package main;

import state.MaquinaGoma;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=".repeat(50));
        System.out.println("   MÁQUINA DE GOMAS - PADRÃO STATE ");
        System.out.println("=".repeat(50));
        
        System.out.print("\n Quantas gomas deseja colocar na máquina? ");
        int quantidade = scanner.nextInt();
        
        MaquinaGoma maquina = new MaquinaGoma(quantidade);
        
        System.out.println("\n Máquina inicializada com " + quantidade + " gomas!");
        System.out.println("Estado atual: " + maquina.getEstadoNome());
        
        int opcao;
        do {
            System.out.println("\n" + "=".repeat(45));
            System.out.println("              MENU INTERATIVO");
            System.out.println("=".repeat(45));
            System.out.println(" 1  - Inserir moeda");
            System.out.println(" 2  - Devolver moeda");
            System.out.println(" 3  - Girar alavanca");
            System.out.println(" 4  - Ver estado atual");
            System.out.println(" 5  - Ver gomas restantes");
            System.out.println(" 0  - Sair");
            System.out.println("=".repeat(45));
            System.out.print("Escolha: ");
            
            opcao = scanner.nextInt();
            System.out.println();
            
            switch (opcao) {
                case 1:
                    System.out.println("--- INSERIR MOEDA ---");
                    maquina.inserirMoeda();
                    break;
                    
                case 2:
                    System.out.println("--- DEVOLVER MOEDA ---");
                    maquina.ejectarMoeda();
                    break;
                    
                case 3:
                    System.out.println("--- GIRAR ALAVANCA ---");
                    maquina.acionarAlavanca();
                    break;
                    
                case 4:
                    System.out.println("--- ESTADO ATUAL ---");
                    System.out.println(maquina.getEstadoNome());
                    break;
                    
                case 5:
                    System.out.println("--- GOMAS RESTANTES ---");
                    System.out.println("Gomas disponíveis: " + maquina.getCount());
                    break;
                    
                case 0:
                    System.out.println("Saindo... Volte sempre!");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente 0-5.");
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }
}
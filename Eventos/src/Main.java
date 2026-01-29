import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            
                ArrayList<Eventos> eventos = new ArrayList<>();

            do{
                System.out.println("\n=== SISTEMA DE EVENTOS ===");
                System.out.println("1 - Cadastrar evento");
                System.out.println("2 - Listar eventos");
                System.out.println("3 - Remover evento");
                System.out.println("0 - Sair");
                System.out.println("Escolha uma opcao: ");
                
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1 ->{
                        Eventos evento = new Eventos();

                        scanner.nextLine();

                        System.out.println("Nome do Evento: ");
                        evento.nome = scanner.nextLine();

                        System.out.println("Local do Evento: ");
                        evento.local = scanner.nextLine();

                        System.out.println("Data do Evento: ");
                        evento.data = scanner.nextLine();

                        System.out.println("Cache do Evento: ");
                        evento.cache = scanner.nextDouble();

                        eventos.add(evento);

                        System.out.println("Evento cadastrado com sucesso!");

                    } 
                    case 2 -> {
                        if (eventos.isEmpty()){
                            System.out.println("nenhum evento cadastrado.");
                        } else {
                            for (Eventos e : eventos){
                                System.out.println("Nome: " + e.nome);
                                System.out.println("Local: " + e.local);
                                System.out.println("Data: " + e.data);
                                System.out.println("Cache: " + e.cache);
                                System.out.println("--------------------------");
                            }
                        }
                    }
                    case 3 -> System.out.println("Remoção de evento (Em desenvolvimento)");
                    case 0 -> System.out.println("Saindo do sistema...");
                    default -> System.out.println("Opção Invalida");
                }
            } while (opcao != 0);
        }
            
    }
}
    

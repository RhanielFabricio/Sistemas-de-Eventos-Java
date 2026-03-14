import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            int opcao;
            ArrayList<Eventos> eventos = new ArrayList<>();

            do {

                System.out.println("\n=== SISTEMA DE EVENTOS ===");
                System.out.println("1 - Cadastrar evento");
                System.out.println("2 - Listar eventos");
                System.out.println("3 - Remover evento");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opcao: ");

                opcao = scanner.nextInt();
                scanner.nextLine(); // limpa ENTER

                switch (opcao) {

                    case 1 -> {
                        Eventos evento = new Eventos();

                        System.out.println("Nome do Evento:");
                        evento.nome = scanner.nextLine();

                        System.out.println("Local do Evento:");
                        evento.local = scanner.nextLine();

                        System.out.println("Data do Evento:");
                        evento.data = scanner.nextLine();

                        System.out.println("Cache do Evento:");

                        while (true) {
                            try {
                                evento.cache = Double.parseDouble(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Valor inválido! Digite apenas números (ex: 500 ou 500.00):");
                            }
                        }

                        eventos.add(evento);
                        System.out.println("Evento cadastrado com sucesso!");
                    }

                    case 2 -> {
                        if (eventos.isEmpty()) {
                            System.out.println("Nenhum evento cadastrado.");
                        } else {
                            for (int i = 0; i < eventos.size(); i++) {
                                Eventos e = eventos.get(i);

                                System.out.println("Evento " + (i + 1));
                                System.out.println(e);
                                System.out.println("----------------------");
                            }
                        }
                    }

                    case 3 -> {
                        if (eventos.isEmpty()) {
                            System.out.println("Não há eventos para remover.");
                        } else {

                            System.out.println("Digite o número do evento que deseja remover:");
                            int indice = scanner.nextInt();
                            scanner.nextLine();

                            if (indice > 0 && indice <= eventos.size()) {
                                eventos.remove(indice - 1);
                                System.out.println("Evento removido com sucesso!");
                            } else {
                                System.out.println("Número inválido.");
                            }
                        }
                    }

                    case 0 -> System.out.println("Saindo do sistema...");

                    default -> System.out.println("Opção inválida.");
                }

            } while (opcao != 0);
        }
    }
}
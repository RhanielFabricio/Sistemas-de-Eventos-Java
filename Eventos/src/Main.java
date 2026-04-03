import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String caminho = "C:/Users/Rhani/Documents/Projetos/Sistemas-de-Eventos-Java/Eventos/src/arquivos.txt";

        System.out.println(" VERSÃO FINAL RODANDO ");
        System.out.println("Caminho: " + new File(caminho).getAbsolutePath());

        ArrayList<Eventos> eventos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                if (partes.length == 4) {
                    try {
                        Eventos e = new Eventos();

                        e.nome = partes[0].trim();
                        e.local = partes[1].trim();
                        e.data = partes[2].trim();
                        e.cache = Double.parseDouble(partes[3].trim());

                        eventos.add(e);

                    } catch (Exception ex) {
                        System.out.println("Erro ao converter linha: " + linha);
                    }
                }
            }

            System.out.println("Eventos carregados: " + eventos.size());

        } catch (Exception e) {
            System.out.println(" Arquivo não encontrado, será criado.");
        }

        try (Scanner scanner = new Scanner(System.in)) {

            int opcao;

            do {

                System.out.println("\n=== SISTEMA DE EVENTOS ===");
                System.out.println("1 - Cadastrar evento");
                System.out.println("2 - Listar eventos");
                System.out.println("3 - Remover evento");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opcao: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    case 1 -> {
                        Eventos evento = new Eventos();

                        System.out.print("Nome: ");
                        evento.nome = scanner.nextLine();

                        System.out.print("Local: ");
                        evento.local = scanner.nextLine();

                        System.out.print("Data: ");
                        evento.data = scanner.nextLine();

                        System.out.print("Cache: ");

                        while (true) {
                            try {
                                evento.cache = Double.parseDouble(scanner.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.print("Valor inválido, tenta de novo: ");
                            }
                        }

                        eventos.add(evento);

                        try (FileWriter writer = new FileWriter(caminho, true)) {

                            writer.write(evento.nome + ";" +
                                    evento.local + ";" +
                                    evento.data + ";" +
                                    evento.cache + "\n");

                        } catch (IOException e) {
                            System.out.println("Erro ao salvar.");
                        }

                        System.out.println("✅ Evento cadastrado!");
                    }

                    case 2 -> {
                        if (eventos.isEmpty()) {
                            System.out.println("Nenhum evento cadastrado.");
                        } else {
                            for (int i = 0; i < eventos.size(); i++) {
                                System.out.println("Evento " + (i + 1));
                                System.out.println(eventos.get(i));
                                System.out.println("------------------");
                            }
                        }
                    }

                    case 3 -> {
                        if (eventos.isEmpty()) {
                            System.out.println("Nada pra remover.");
                        } else {

                            System.out.print("Número do evento: ");
                            int indice = scanner.nextInt();
                            scanner.nextLine();

                            if (indice > 0 && indice <= eventos.size()) {
                                eventos.remove(indice - 1);

                                try (FileWriter writer = new FileWriter(caminho)) {
                                    for (Eventos e : eventos) {
                                        writer.write(e.nome + ";" +
                                                e.local + ";" +
                                                e.data + ";" +
                                                e.cache + "\n");
                                    }
                                }

                                System.out.println("🗑️ Removido!");
                            } else {
                                System.out.println("Número inválido.");
                            }
                        }
                    }

                    case 0 -> System.out.println("Saindo...");

                    default -> System.out.println("Opção inválida");
                }

            } while (opcao != 0);
        }
    }
}
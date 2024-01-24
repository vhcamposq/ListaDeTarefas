package model;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefas {
    private ArrayList<Tarefa> tarefas;

    public ListaDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada: " + descricao);
    }

    public void exibirTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa na lista.");
        } else {
            System.out.println("Lista de Tarefas:");
            for (int i = 0; i < tarefas.size(); i++) {
                Tarefa tarefa = tarefas.get(i);
                System.out.println((i + 1) + ". " + tarefa.getDescricao() +
                                   (tarefa.isConcluida() ? " (Concluída)" : ""));
            }
        }
    }

    public void marcarTarefaConcluida(int indice) {
        if (indice >= 1 && indice <= tarefas.size()) {
            Tarefa tarefa = tarefas.get(indice - 1);
            tarefa.marcarConcluida();
            System.out.println("Tarefa marcada como concluída: " + tarefa.getDescricao());
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void main(String[] args) {
        ListaDeTarefas listaDeTarefas = new ListaDeTarefas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n### Lista de Tarefas ###");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Exibir Tarefas");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    scanner.nextLine();  // Consumir a quebra de linha pendente
                    String descricao = scanner.nextLine();
                    listaDeTarefas.adicionarTarefa(descricao);
                    break;
                case 2:
                    listaDeTarefas.exibirTarefas();
                    break;
                case 3:
                    System.out.print("Digite o índice da tarefa a ser marcada como concluída: ");
                    int indice = scanner.nextInt();
                    listaDeTarefas.marcarTarefaConcluida(indice);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

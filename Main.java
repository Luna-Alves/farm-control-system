import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Main {
private static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
    try {
        limparArquivos();

        Fazenda minhaFazenda = new Fazenda("Moo Moo Farm", 1000, "Cidade X", "Estado Y");

        int escolha;
        do {
            exibirMenu();
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    adicionarFuncionario(minhaFazenda, scanner);
                    break;
                case 2:
                    adicionarAnimal(minhaFazenda, scanner);
                    break;
                case 3:
                    alimentarAnimais(minhaFazenda);
                    break;
                case 4:
                    emitirSomAnimais(minhaFazenda);
                    break;
                case 5:
                    removerAnimal(minhaFazenda, scanner);
                    break;
                case 6:
                    gerarRelatorioAnimais(minhaFazenda);
                    break;
                case 7:
                    calcularFolhaPagamento(minhaFazenda);
                    break;
                case 8:
                    calcularSituacaoFinanceira(minhaFazenda);
                    break;
                case 9:
                    exibirEstadoAnimais(minhaFazenda);
                    break;
                case 10:
                    realizarVendaAnimais(minhaFazenda);
                    break;
                case 11:
                    modificarPrecoQuiloAbate();
                    break;
                case 12:
                    modificarPrecoLitroLeite();
                    break;
                case 13:
                    extrairLeite(minhaFazenda, scanner);
                    break;
                case 14:
                    minhaFazenda.exibirInformacoesFuncionarios();
                    break;
                case 15:
                    minhaFazenda.exibirInformacoesFazenda();
                    break;
                case 16:
                    obterSomatorioPrecoEstimadoAnimais(minhaFazenda);
                    break;
                case 17:
                    obterPrecoEstimadoAnimaisPorPeso(minhaFazenda, scanner);
                    break;
                case 0:
                    System.out.println("Fechando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (escolha != 0);
    } finally {
        limparArquivos();

        if (scanner != null) {
            scanner.close();
        }
    }
}

private static void exibirMenu() {
    System.out.println("\n=== Menu ===");
    System.out.println("1. Adicionar Funcionário");
    System.out.println("2. Adicionar Animal");
    System.out.println("3. Alimentar Animais");
    System.out.println("4. Emitir Som dos Animais");
    System.out.println("5. Remover Animal");
    System.out.println("6. Gerar Relatório de Animais");
    System.out.println("7. Calcular Folha de Pagamento");
    System.out.println("8. Calcular Situação Financeira");
    System.out.println("9. Exibir Estado de Todos os Animais");
    System.out.println("10. Realizar Venda de Animais");
    System.out.println("11. Modificar preço do KG");
    System.out.println("12. Modificar preço do Leite");
    System.out.println("13. Extrair Leite");
    System.out.println("14. Exibir Informações dos Funcionários");
    System.out.println("15. Exibir Informações da Fazenda");
    System.out.println("16. Exibir Informações de venda atual");
    System.out.println("17. Obter preço estimado de venda de animais por peso");
    System.out.println("0. Sair");
    System.out.print("Escolha uma opção: ");
}

private static void limparArquivos() {
    try {
        limparConteudoArquivo("venda_animais.txt");
        limparConteudoArquivo("venda_leite.txt");
        limparConteudoArquivo("relatorio_animais.txt");
        limparConteudoArquivo("folha_pagamento.txt");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static void limparConteudoArquivo(String nomeArquivo) throws IOException {
    try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
        fileWriter.write("");
    }
}

    private static void adicionarFuncionario(Fazenda fazenda, Scanner scanner) {
        System.out.println("Informe o nome do funcionário: ");
        String nome = scanner.next();

        System.out.println("Informe a idade do funcionário: ");
        int idade = scanner.nextInt();

        System.out.println("Informe o CPF do funcionário: ");
        String cpf = scanner.next();

        System.out.println("Selecione o tipo de funcionário:");
        System.out.println("1. Tratador");
        System.out.println("2. Extrator de Leite");
        System.out.println("3. Gerente");

        int tipoFuncionario = scanner.nextInt();

        Funcionario novoFuncionario = null;

        switch (tipoFuncionario) {
            case 1:
                novoFuncionario = new Tratador(nome, idade, cpf);
                break;
            case 2:
                novoFuncionario = new ExtratorLeite(nome, idade, cpf);
                break;
            case 3:
                novoFuncionario = new Gerente(nome, idade, cpf);
                break;
            default:
                System.out.println("Tipo de funcionário inválido.");
                return;
        }

        fazenda.adicionarFuncionario(novoFuncionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    private static void adicionarAnimal(Fazenda fazenda, Scanner scanner) {
        System.out.println("Selecione o tipo de animal:");
        System.out.println("1. Gado de Abate");
        System.out.println("2. Porco");
        System.out.println("3. Vaca Leiteira");

        int tipoAnimal = scanner.nextInt();
        Animal novoAnimal = null;

      Random random = new Random();
      int numeroIdentificador = random.nextInt(1000);
      
        switch (tipoAnimal) {
            case 1:
                novoAnimal = new GadoAbate(numeroIdentificador, 900, 2);
                break;
            case 2:
                novoAnimal = new Porco(numeroIdentificador, 200, 1);
                break;
          case 3:
            System.out.println("Informe o nome do extrator de leite: ");
            String nomeExtrator = scanner.next();
            System.out.println("Informe a idade do extrator de leite: ");
            int idadeExtrator = scanner.nextInt();
            System.out.println("Informe o CPF do extrator de leite: ");
            String cpfExtrator = scanner.next();

            ExtratorLeite extratorLeite = new ExtratorLeite(nomeExtrator, idadeExtrator, cpfExtrator);
            fazenda.adicionarFuncionario(extratorLeite);
            novoAnimal = new VacaLeiteira(numeroIdentificador, 900, 3, extratorLeite);
            break;

          default:
              System.out.println("Tipo de animal inválido.");
              return;
        }

        fazenda.adicionarAnimal(novoAnimal);
        System.out.println("Animal adicionado com sucesso!");
    }
  private static void obterSomatorioPrecoEstimadoAnimais(Fazenda fazenda) {
      double somatorio = fazenda.obterSomatorioPrecoEstimadoAnimais();
      System.out.println("Somatório do preço estimado de todos os animais com peso atual: " + somatorio);
  }

  private static void obterPrecoEstimadoAnimaisPorPeso(Fazenda fazenda, Scanner scanner) {
      System.out.println("Informe os números identificadores dos animais separados por vírgula:");
      String input = scanner.next();
      String[] numerosIdentificadores = input.split(",");

      double somatorio = 0;
      for (String numeroIdentificador : numerosIdentificadores) {
          int id = Integer.parseInt(numeroIdentificador.trim());
          Animal animal = fazenda.obterAnimalPorNumeroIdentificador(id);

          if (animal != null) {
              somatorio += animal.calcularPreco();
          } else {
              System.out.println("Animal com número identificador " + id + " não encontrado.");
          }
      }

      System.out.println("Somatório do preço estimado de venda dos animais selecionados: " + somatorio);
  }

  
  private static void realizarVendaAnimais(Fazenda fazenda) {
      fazenda.realizarVendaAnimais();
      System.out.println("Venda de animais realizada com sucesso!");
  }
    private static void alimentarAnimais(Fazenda fazenda) {
        for (Animal animal : fazenda.getAnimais()) {
            animal.alimentar();
        }
        System.out.println("Animais foram alimentados.");
    }

    private static void emitirSomAnimais(Fazenda fazenda) {
        for (Animal animal : fazenda.getAnimais()) {
            animal.emitirSom();
        }
    }

    private static void removerAnimal(Fazenda fazenda, Scanner scanner) {
        System.out.println("Informe o número identificador do animal a ser removido:");
        int numeroIdentificador = scanner.nextInt();

        Animal animalRemover = null;

        for (Animal animal : fazenda.getAnimais()) {
            if (animal instanceof AnimalAbate && ((AnimalAbate) animal).getNumeroIdentificador() == numeroIdentificador) {
                animalRemover = animal;
                break;
            } else if (animal instanceof VacaLeiteira && ((VacaLeiteira) animal).getNumeroIdentificador() == numeroIdentificador) {
                animalRemover = animal;
                break;
            }
        }

        if (animalRemover != null) {
            fazenda.removerAnimal(animalRemover);
            System.out.println("Animal removido com sucesso!");
        } else {
            System.out.println("Animal não encontrado.");
        }
    }

    private static void gerarRelatorioAnimais(Fazenda fazenda) {
        fazenda.gerarRelatorioAnimais();
        System.out.println("Relatório de animais gerado com sucesso!");
    }

    private static void calcularFolhaPagamento(Fazenda fazenda) {
        fazenda.calcularFolhaPagamento();
        System.out.println("Folha de pagamento calculada e registrada.");
    }

    private static void calcularSituacaoFinanceira(Fazenda fazenda) {
        fazenda.calcularSituacaoFinanceira();
    }

    private static void exibirEstadoAnimais(Fazenda fazenda) {
        System.out.println("\n=== Exibir Estado de Todos os Animais ===");
        for (Animal animal : fazenda.getAnimais()) {
            animal.exibirEstado();
            System.out.println();
        }
    }
  private static void modificarPrecoQuiloAbate() {
      System.out.println("Informe o novo preço por quilo para abate:");
      double novoPreco = scanner.nextDouble();
      GadoAbate.setPrecoPorQuiloAbate(novoPreco);
      System.out.println("Preço por quilo para abate atualizado com sucesso!");
  }

  private static void modificarPrecoLitroLeite() {
      System.out.println("Informe o novo preço por litro de leite:");
      double novoPreco = scanner.nextDouble();
      VacaLeiteira.setPrecoPorLitroLeite(novoPreco);
      System.out.println("Preço por litro de leite atualizado com sucesso!");
  }

  private static void extrairLeite(Fazenda fazenda, Scanner scanner) {
      System.out.println("Vacas Leiteiras Cadastradas:");

      for (Animal animal : fazenda.getAnimais()) {
          if (animal instanceof VacaLeiteira) {
              VacaLeiteira vacaLeiteira = (VacaLeiteira) animal;
              System.out.println("Número Identificador: " + vacaLeiteira.getNumeroIdentificador());
          }
      }

      System.out.println("Informe o número identificador da vaca leiteira:");
      int numeroIdentificador = scanner.nextInt();

      for (Animal animal : fazenda.getAnimais()) {
          if (animal instanceof VacaLeiteira && animal.getNumeroIdentificador() == numeroIdentificador) {
              VacaLeiteira vacaLeiteira = (VacaLeiteira) animal;

              ExtratorLeite extratorLeite = selecionarFuncionarioExtrator(fazenda, scanner);

            if (extratorLeite != null) {
                double quantidadeExtraida = vacaLeiteira.extrairLeite(extratorLeite);
                double valorTotal = quantidadeExtraida * VacaLeiteira.getPrecoPorLitroLeite();

                Fazenda.adicionarValorArrecadadoLeite(valorTotal);

                try (PrintWriter writer = new PrintWriter(new FileWriter("venda_leite.txt", true))) {
                    writer.println("Extrator: " + extratorLeite.getNome() +
                            ", Quantidade de Litros: " + quantidadeExtraida +
                            ", Valor Total: " + valorTotal);
                } catch (IOException e) {
                    System.out.println("Erro ao registrar venda de leite: " + e.getMessage());
                }

                System.out.println("Leite extraído com sucesso!");
                return;
            } else {
                System.out.println("Nenhum Extrator de Leite selecionado.");
            }
          }
      }

      System.out.println("Vaca leiteira não encontrada com o número identificador fornecido.");
  }


  private static ExtratorLeite selecionarFuncionarioExtrator(Fazenda fazenda, Scanner scanner) {
      System.out.println("Selecione o funcionário extrator de leite:");

      List<Funcionario> extratoresLeite = new ArrayList<>();

      for (Funcionario funcionario : fazenda.getFuncionarios()) {
          if (funcionario instanceof ExtratorLeite) {
              extratoresLeite.add(funcionario);
              System.out.println(extratoresLeite.size() + ". " + funcionario.getNome());
          }
      }

      if (extratoresLeite.isEmpty()) {
          System.out.println("Nenhum Extrator de Leite disponível.");
          return null;
      }

      int escolhaExtrator = scanner.nextInt();

      if (escolhaExtrator >= 1 && escolhaExtrator <= extratoresLeite.size()) {
          return (ExtratorLeite) extratoresLeite.get(escolhaExtrator - 1);
      } else {
          System.out.println("Escolha inválida.");
          return null;
      }
    
  }

}
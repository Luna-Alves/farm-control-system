import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Fazenda {
    private String nome;
    private double dimensao;
    private String cidade;
    private String estado;
    private List<Funcionario> funcionarios;
    private List<Animal> animais;
    private static double totalArrecadado = 0;
    private static double valorArrecadadoLeite = 0;

    public Fazenda(String nome, double dimensao, String cidade, String estado) {
        this.nome = nome;
        this.dimensao = dimensao;
        this.cidade = cidade;
        this.estado = estado;
        this.funcionarios = new ArrayList<>();
        this.animais = new ArrayList<>();
    }
  public static double getValorArrecadadoLeite() {
      return valorArrecadadoLeite;
  }
  public static void adicionarValorArrecadadoLeite(double valor) {
      valorArrecadadoLeite += valor;
  }
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }
  public void realizarVendaAnimais() {
      List<Animal> animaisParaVenda = new ArrayList<>();

      for (Animal animal : animais) {
          if (animal.podeSerVendido()) {
              animaisParaVenda.add(animal);
          }
      }

      double valorTotalVenda = 0;
      for (Animal animal : animaisParaVenda) {
          double pesoVendido = animal.getPeso();
          double precoVenda = animal.getPrecoVenda();
          double valorVenda = pesoVendido * precoVenda;

          valorTotalVenda += valorVenda;

          animais.remove(animal);
      }

      try (PrintWriter writer = new PrintWriter(new FileWriter("venda_animais.txt", true))) {
          writer.println("Valor total arrecadado com venda de animais: " + valorTotalVenda);
      } catch (IOException e) {
          System.out.println("Erro ao registrar venda de animais: " + e.getMessage());
      }
  }
  
    public void removerAnimal(Animal animal) {
        animais.remove(animal);
        if (animal instanceof AnimalAbate) {
            totalArrecadado += ((AnimalAbate) animal).calcularPreco();
        } else if (animal instanceof VacaLeiteira) {
            totalArrecadado += ((VacaLeiteira) animal).calcularPreco();
        }
    }

  public static double getTotalArrecadado() {
      return totalArrecadado;
  }
  public void gerarRelatorioAnimais() {
      try (FileWriter writer = new FileWriter("relatorio_animais.txt")) {
          List<Animal> animaisOrdenados = new ArrayList<>(animais);

          Collections.sort(animaisOrdenados, Comparator.comparingInt(animal -> {
              if (animal instanceof GadoAbate) {
                  return 1;
              } else if (animal instanceof VacaLeiteira) {
                  return 2;
              } else if (animal instanceof Porco) {
                  return 3;
              }
              return 0;
          }));

          for (Animal animal : animaisOrdenados) {
              writer.write(animal.getClass().getSimpleName() + ": ");
              writer.write("Número Identificador: " + animal.getNumeroIdentificador() + ", ");
              writer.write("Peso: " + animal.getPeso() + " kg, ");
              writer.write("Idade: " + animal.getIdade());
              writer.write("\n");
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

    public void calcularFolhaPagamento() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("folha_pagamento.txt"))) {
            for (Funcionario funcionario : funcionarios) {
                writer.write(funcionario.getClass().getSimpleName() + ": ");
                funcionario.exibirEstado();
                writer.write("Salário: " + funcionario.calcularSalario() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao calcular a folha de pagamento: " + e.getMessage());
        }
    }

    public void calcularSituacaoFinanceira() {
        double despesaFolhaPagamento = calcularDespesaFolhaPagamento();
        double receitaVendaAnimais = getTotalVendaAnimais();
        double receitaVendaLeite = getTotalVendaLeite();

        double lucroOuPrejuizo = receitaVendaAnimais + receitaVendaLeite - despesaFolhaPagamento;

        System.out.println("Situação Financeira da Fazenda:");
        System.out.println("Despesa com Folha de Pagamento: " + despesaFolhaPagamento);
        System.out.println("Receita com Venda de Animais: " + receitaVendaAnimais);
        System.out.println("Receita com Venda de Leite: " + receitaVendaLeite);
        System.out.println("Lucro/Prejuízo: " + lucroOuPrejuizo);
    }

  public void realizarVendaLeite() {
      double totalLitrosVenda = 0;
      double valorTotalVendaLeite = 0;

      for (Animal animal : animais) {
          if (animal instanceof VacaLeiteira) {
              VacaLeiteira vacaLeiteira = (VacaLeiteira) animal;

              double litrosExtraidos = vacaLeiteira.extrairLeite(obterExtratorLeite());
              totalLitrosVenda += litrosExtraidos;
              valorTotalVendaLeite += litrosExtraidos * VacaLeiteira.getPrecoPorLitroLeite();
          }
      }
    valorArrecadadoLeite += valorTotalVendaLeite;

      try (PrintWriter writer = new PrintWriter(new FileWriter("venda_leite.txt", true))) {
          writer.println( "Litros de leite vendidos: " + totalLitrosVenda  + ",Valor total arrecadado com venda de leite: " + valorTotalVendaLeite );
      } catch (IOException e) {
          System.out.println("Erro ao registrar venda de leite: " + e.getMessage());
      }
  }

  private ExtratorLeite obterExtratorLeite() {
      for (Funcionario funcionario : funcionarios) {
          if (funcionario instanceof ExtratorLeite) {
              return (ExtratorLeite) funcionario;
          }
      }
      return null;
  }
  
    private double calcularDespesaFolhaPagamento() {
        double despesaTotal = 0;
        for (Funcionario funcionario : funcionarios) {
            despesaTotal += funcionario.calcularSalario();
        }
        return despesaTotal;
    }

    public List<Animal> getAnimais() {
        return new ArrayList<>(animais);
    }

  public Animal obterAnimalPorNumeroIdentificador(int numeroIdentificador) {
      for (Animal animal : animais) {
          if (animal.getNumeroIdentificador() == numeroIdentificador) {
              return animal;
          }
      }
      return null;
  }

    public List<Funcionario> getFuncionarios() {
        return new ArrayList<>(funcionarios);
    }

    public static double getTotalVendaAnimais() {
        return 0;
    }

    public static double getTotalVendaLeite() {
        return 0;
    }

  public void exibirInformacoesFuncionarios() {
      System.out.println("\n=== Informações dos Funcionários ===");
      for (Funcionario funcionario : funcionarios) {
          funcionario.exibirEstado();
          System.out.println("Salário: " + funcionario.calcularSalario() + "\n");
      }
  }

  public void exibirInformacoesFazenda() {
      System.out.println("\n=== Informações da Fazenda ===");
      System.out.println("Nome: " + nome);
      System.out.println("Dimensão: " + dimensao);
      System.out.println("Cidade: " + cidade);
      System.out.println("Estado: " + estado + "\n");
  }
  
  public double obterSomatorioPrecoEstimadoAnimais() {
      double somatorio = 0;
      for (Animal animal : animais) {
          somatorio += animal.calcularPreco();
      }
      return somatorio;
  }

}
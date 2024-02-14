public class Porco implements Animal {
    private int numeroIdentificador;
    private double peso;
    private int idade;
    private static double precoPorQuilo = 4.0;

    public Porco(int numeroIdentificador, double peso, int idade) {
        this.numeroIdentificador = numeroIdentificador;
        this.peso = peso;
        this.idade = idade;
    }

    @Override
    public void alimentar() {
        System.out.println("Porco sendo alimentado.");
        System.out.println("Peso antes da alimentação: " + getPeso() + " kg");
        this.peso += 1.5;
        System.out.println("Peso após a alimentação: " + getPeso() + " kg");
    }

    @Override
    public void emitirSom() {
        System.out.println("Oink! Oink!");
    }

    @Override
  public void exibirEstado() {
      System.out.println("Porco: Número Identificador: " + getNumeroIdentificador() +
                         ", Peso: " + getPeso() + " kg, Idade: " + getIdade() +
                         ", Peso em Arrobas: " + converterPesoParaArroba());
  }

    @Override
    public double calcularPreco() {
        return peso * precoPorQuilo;
    }
  @Override
  public double converterPesoParaArroba() {
      return getPeso() / 15.0;
  }
  @Override
  public boolean podeSerVendido() {
      return getPeso() >= 300;
  }

  @Override
  public double getPrecoVenda() {
      return 30;
  }
    @Override
    public int getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public double getPeso() {
        return peso;
    }

    public int getIdade() {
        return idade;
    }
}
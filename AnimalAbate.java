public class AnimalAbate implements Animal {
    private int numeroIdentificador;
    private double peso;
    private int idade;
    private static double precoPorQuilo = 5.0;

    public AnimalAbate(int numeroIdentificador, double peso, int idade) {
        this.numeroIdentificador = numeroIdentificador;
        this.peso = peso;
        this.idade = idade;
    }

  public static void setPrecoPorQuilo(double novoPreco) {
      precoPorQuilo = novoPreco;
  }

    @Override
    public void alimentar() {
        this.peso += 2.0;
    }
  @Override
  public double converterPesoParaArroba() {
      return getPeso() / 15.0;
  }

    @Override
    public void emitirSom() {
        System.out.println("Som de Animal de Abate");
    }

    @Override
  public void exibirEstado() {
      System.out.println("Animal Abate: Número Identificador: " + getNumeroIdentificador() +
                         ", Peso: " + getPeso() + " kg, Idade: " + getIdade() +
                         ", Peso em Arrobas: " + converterPesoParaArroba());
  }

    @Override
    public double calcularPreco() {
        return peso * precoPorQuilo;
    }

    @Override
    public int getNumeroIdentificador() {
        return numeroIdentificador;
    }
    @Override

    public double getPeso() {
        return peso;
    }

    public int getIdade() {
        return idade;
    }
  @Override
  public boolean podeSerVendido() {
      return getPeso() >= 105;
  }

  @Override
  public double getPrecoVenda() {
      return 10;
  }
}
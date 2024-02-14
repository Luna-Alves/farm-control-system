public class GadoAbate implements Animal {
    private AnimalAbate animalAbate;

    public GadoAbate(int numeroIdentificador, double peso, int idade) {
        this.animalAbate = new AnimalAbate(numeroIdentificador, peso, idade);
    }

  private static double precoPorQuiloAbate = 5.0;
    @Override
    public void alimentar() {
        System.out.println("Gado de Abate sendo alimentado.");
        System.out.println("Peso antes da alimentação: " + getPeso() + " kg");
        this.animalAbate.alimentar();
        System.out.println("Peso após a alimentação: " + getPeso() + " kg");
    }

    @Override
    public void emitirSom() {
        System.out.println("Muuu!");
    }

  @Override
  public double converterPesoParaArroba() {
      return getPeso() / 15.0;
  }
  
    @Override
  public void exibirEstado() {
      System.out.println("Gado Abate: Número Identificador: " + getNumeroIdentificador() +
                         ", Peso: " + getPeso() + " kg, Idade: " + getIdade() +
                         ", Peso em Arrobas: " + converterPesoParaArroba());
  }

    @Override
    public double calcularPreco() {
        return animalAbate.calcularPreco();
    }

    @Override
    public int getNumeroIdentificador() {
        return animalAbate.getNumeroIdentificador();
    }

    public double getPeso() {
        return animalAbate.getPeso();
    }

    public int getIdade() {
        return animalAbate.getIdade();
    }

    @Override
    public boolean podeSerVendido() {
        return getPeso() >= 1500;
    }

  public static void setPrecoPorQuiloAbate(double novoPreco) {
      precoPorQuiloAbate = novoPreco;
  }
    @Override
    public double getPrecoVenda() {
        return 10;
    }
}
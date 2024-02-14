import java.util.Random;

public class VacaLeiteira implements Animal {
    private int numeroIdentificador;
    private double peso;
    private int idade;
    private static double precoPorQuilo = 3.0;
    private static double precoPorLitroLeite = 2.0;
    private ExtratorLeite extratorLeite;

    public VacaLeiteira(int numeroIdentificador, double peso, int idade, ExtratorLeite extratorLeite) {
        this.numeroIdentificador = numeroIdentificador;
        this.peso = peso;
        this.idade = idade;
        this.extratorLeite = extratorLeite;
    }

    public static void setPrecoPorLitroLeite(double novoPreco) {
        precoPorLitroLeite = novoPreco;
    }

    public static double getPrecoPorLitroLeite() {
        return precoPorLitroLeite;
    }

    @Override
    public double converterPesoParaArroba() {
        return getPeso() / 15.0;
    }

    @Override
    public void alimentar() {
        System.out.println("Vaca Leiteira sendo alimentada.");
        System.out.println("Peso antes da alimentação: " + getPeso() + " kg");
        this.peso += 4.5;
        System.out.println("Peso após a alimentação: " + getPeso() + " kg");
    }

    @Override
    public void emitirSom() {
        System.out.println("Moo! Moo!");
    }

    @Override
    public void exibirEstado() {
        System.out.println("Vaca Leiteira: Número Identificador: " + getNumeroIdentificador() +
                ", Peso: " + getPeso() + " kg, Idade: " + getIdade() +
                ", Peso em Arrobas: " + converterPesoParaArroba());
    }

    @Override
    public double calcularPreco() {
        return peso * precoPorQuilo;
    }

    @Override
    public boolean podeSerVendido() {
        return getPeso() >= 1500;
    }

    @Override
    public double getPrecoVenda() {
        return 40;
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

  public double extrairLeite(ExtratorLeite extratorLeite) {
      double quantidadeExtraida = extratorLeite.extrairLeite();
      return quantidadeExtraida;
  }

}
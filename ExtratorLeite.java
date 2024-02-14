import java.util.Random;

public class ExtratorLeite extends Funcionario {
    private static double percentualVendaLeite = 0.1;
    private double litrosExtraidos;

    public ExtratorLeite(String nome, int idade, String cpf) {
        super(nome, idade, cpf);
    }

    public double extrairLeite() {
        Random random = new Random();
        double quantidadeExtraida = random.nextDouble() * 10.0;
        System.out.println("Leite extraído pelo extrator de leite: " + quantidadeExtraida + " litros");
        return quantidadeExtraida;
    }

    public double getLitrosExtraidos() {
        return litrosExtraidos;
    }

    @Override
    public void exibirEstado() {
        System.out.println("Extrator de Leite: " + getNome() + ", Idade: " + getIdade() + ", CPF: " + getCpf());
    }

    public void registrarLeiteExtraido(double litros) {
        System.out.println("Leite extraído por " + getNome() + ": " + litros + " litros.");
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (Fazenda.getTotalVendaLeite() * percentualVendaLeite);
    }
}
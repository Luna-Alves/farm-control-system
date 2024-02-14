class Tratador extends Funcionario {
    private static double percentualVenda = 0.05;

    public Tratador(String nome, int idade, String cpf) {
        super(nome, idade, cpf);
    }

    @Override
    public void exibirEstado() {
        System.out.println("Tratador: " + nome + ", Idade: " + idade + ", CPF: " + cpf);
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (Fazenda.getTotalVendaAnimais() * percentualVenda);
    }
}
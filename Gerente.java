class Gerente extends Funcionario {
    private static double percentualTotalArrecadado = 0.2;

    public Gerente(String nome, int idade, String cpf) {
        super(nome, idade, cpf);
    }

    @Override
    public void exibirEstado() {
        System.out.println("Gerente: " + nome + ", Idade: " + idade + ", CPF: " + cpf);
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (Fazenda.getTotalArrecadado() * percentualTotalArrecadado);
    }
}
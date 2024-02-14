public abstract class Funcionario {
    protected String nome;
    protected int idade;
    protected String cpf;
    protected static double salarioBase = 2000;

    public Funcionario(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public abstract void exibirEstado();
    public abstract double calcularSalario();

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }
}
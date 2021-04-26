import java.util.function.Supplier;

public class Fornecedores {
    /**
     * Nao recebem parametro
     * mas retornam algo          
     */
    public static void main(String[] args) {
        Supplier<Pessoa> suppliers = () -> new Pessoa();
        Supplier<Pessoa> instancia = Pessoa::new;
        System.out.println(suppliers.get());
        System.out.println(instancia.get());
    }    
}

class Pessoa {
    private String nome;
    private Integer idade;
    public Pessoa() { nome ="Cristinao"; idade=30;}
    @Override
    public String toString(){
        return String.format("nome: %s, idade %d", nome, idade);
    }

}

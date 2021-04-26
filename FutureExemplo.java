import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//
public class FutureExemplo {
    private static final ExecutorService pessoaExecutaAtividade = Executors.newFixedThreadPool(3);    
    public static void main(String[] args) {
        Casa casa = new Casa (new Quarto());
        casa.obterAfazeres().forEach( atividade -> pessoaExecutaAtividade.execute(() -> atividade.realizar()));
        //List<? extends Future<?>> futuros = casa.obterAfazeres().stream()
        //    .map(atividade -> pessoaExecutaAtividade.submit( () -> atividade.realizar()))
        //    .collect(Collectors.toList());
        

        pessoaExecutaAtividade.shutdown();
    }
}

class Casa {
    private List<Comodo> comodos;
    Casa(Comodo... comodos) { this.comodos = Arrays.asList(comodos); }
    List<Atividade> obterAfazeres() {
        return this.comodos.stream().map(Comodo::obterAfazeresComodo)
        .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
            pivo.addAll(atividades);
            return pivo;
        });
            
    }
}

interface Atividade {
    void realizar();
}
abstract class Comodo {
    abstract List<Atividade> obterAfazeresComodo();
}

class Quarto extends Comodo {
    @Override
    List<Atividade> obterAfazeresComodo(){
        return Arrays.asList(
            this::getArrumarCama,
            this::varrerQuarto,
            this::arrumarGuardaRoupa
        );
    }

    private void arrumarGuardaRoupa(){ System.out.println("Arrumando guarda roupa"); } 
    private void varrerQuarto(){ System.out.println("Varrendo o quarto"); }
    private void getArrumarCama() {System.out.println("Arrumando a cama"); }
}
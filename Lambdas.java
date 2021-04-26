public class Lambdas {
    public static void main(String[] args) {
        /**
         * interafaces funcionais possuem um metodo abastrato
         * default: define um metodo padrao na interface
         * @FunctionalInterface
         */

        /** Java 8: classe anonima */
        Funcao colocarPrefixo = new Funcao() {
            @Override
            public String gerar(String valor){
                return "Sr. "+valor;
            }
        };

        System.out.println(colocarPrefixo.gerar("Joao"));

        /** Lambda
         * InterfaceFuncional nomeVar = parametro -> logica
         */
        Funcao colocaPrefixoLambda = valor -> "Sr. " +valor;
        System.out.println(colocaPrefixoLambda.gerar("Joao"));

    }
    @FunctionalInterface
    interface Funcao {
        String gerar(String valor);
    }
}
public class FuncaoAltaOrdem {
    /** Paradigma Funcional de alta ordem
     * funcao que retorna uma funcao ou recebe uma 
     * funcao como parametro
     * maim comum: receber uma funcao como parametro
     *  */
    public static void main(String[] args) {
        Calculo soma = (a, b) -> a+b;
        Calculo sub = (a, b) -> a-b;
        Calculo div = (a, b) -> a/b;
        Calculo multi = (a, b) -> a*b;
        
        System.out.println(execOp(soma,1,2)); //3
        System.out.println(execOp(div,8,2)); //4
        System.out.println(execOp(multi,8,2)); //16
        System.out.println(execOp(sub,9,2)); //7

    }
    
    public static int execOp(Calculo c, int a, int b){
        return c.calcular(a,b);

    }

}
@FunctionalInterface //good pratice
interface Calculo {
    public int calcular(int a, int b);
}

import java.util.Scanner;
public class Cedulas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int original_value = teclado.nextInt();
        int notas_cem, notas_cinquenta, notas_vinte, notas_dez, notas_cinco, notas_dois, notas_um;
        notas_cem = notas_cinquenta = notas_vinte = notas_dez = notas_cinco = notas_dois = notas_um = 0;
        int valor = original_value;
        if (valor / 100 >= 1) {
            notas_cem = (int)(valor / 100);
            valor -= notas_cem * 100;} 
        if (valor / 50 >= 1) {
            notas_cinquenta = (int)(valor / 50);
            valor -= notas_cinquenta * 50;} 
        if (valor / 20 >= 1) {
            notas_vinte = (int)( valor / 20 );
            valor -= notas_vinte * 20;}
        if (valor / 10 >= 1) {
            notas_dez = (int)(valor / 10);
            valor -= notas_dez * 10;}
        if (valor / 5 >= 1) {
            notas_cinco = (int)(valor / 5);
            valor -= notas_cinco * 5;}
        if (valor / 2 >= 1) {
            notas_dois = (int)(valor / 2);
            valor -= notas_dois * 2;}        
        notas_um = valor;

        System.out.println(original_value);
        System.out.println(notas_cem + " nota(s) de R$ 100,00");
        System.out.println(notas_cinquenta + "  nota(s) de R$ 50,00");
        System.out.println(notas_vinte + "  nota(s) de R$ 20,00");
        System.out.println(notas_dez + "  nota(s) de R$ 10,00");
        System.out.println(notas_cinco + "  nota(s) de R$ 5,00");
        System.out.println(notas_dois + "  nota(s) de R$ 2,00");
        System.out.println(notas_um + "  nota(s) de R$ 1,00");
        teclado.close();
    }
}
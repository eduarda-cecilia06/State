package util;

public class TratarErros {
    public static void erro(String mensagem) {
        System.err.println("[ERRO] " + mensagem);
    }
    
    public static void info(String mensagem) {
        System.out.println("[INFO] " + mensagem);
    }
    
    public static void sucesso(String mensagem) {
        System.out.println("[SUCESSO] " + mensagem);
    }
}
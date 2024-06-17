package threads;

import javax.swing.*;

public class AulaThread2 {

    public static void main(String[] args) throws InterruptedException {

        /* Thread processando em paralelo do envio de e-mail */
        new Thread(){
            public void run() { /* Código da rotina */

                /* Código da rotina que eu quero executar em paralelo */
                for (int pos = 0; pos < 10; pos++) {

                    /* Executar esse envio com um tempo de parada ou com um tempo determinado */
                    System.out.println("Excutando alguma rotina, por exemplo envio de e-mail");

                    try {
                        Thread.sleep(2000); /* Da um tempo */
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                /* Fim do código em paralelo */
                System.out.println("Finalizou loop");

            }
        }.start(); /* Start liga a thread que fica processando paralelamente por trás */


        //------------------------------------ DIVISÃO DAS THREADS


        /* Thread processando em paralelo do envio de nota fiscal */
        new Thread(){
            public void run() { /* Código da rotina */

                /* Código da rotina que eu quero executar em paralelo */
                for (int pos = 0; pos < 10; pos++) {

                    /* Executar esse envio com um tempo de parada ou com um tempo determinado */
                    System.out.println("Excutando alguma rotina, por exemplo envio de nota fiscal");

                    try {
                        Thread.sleep(1000); /* Da um tempo */
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                /* Fim do código em paralelo */
                System.out.println("Finalizou loop");

            }
        }.start(); /* Start liga a thread que fica processando paralelamente por trás */

        /* Código continua o fluxo de trabalho, exemplo: cadastro de venda, emissão do nota fiscal */
        JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário");
    }
}

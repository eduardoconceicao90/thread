package threads.filaPilha;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

    private static ConcurrentLinkedQueue<ObjetoFilaThread> pilhaFila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

    public static void add(ObjetoFilaThread objetoFilaThread) {
        pilhaFila.add(objetoFilaThread);
    }

    @Override
    public void run() {

        System.out.println("Fila rodando");

        while(true) {

            Iterator iterator = pilhaFila.iterator();

            synchronized (iterator) { /* Bloquear o acesso a esta lista por outros processos */

                while (iterator.hasNext()){ /* Enquanto conter dados na lista irá processar */

                    ObjetoFilaThread processar = (ObjetoFilaThread) iterator.next(); /* Pega o objeto atual */

                    /* Processar 10 mil notas fiscais */
                    /* Gerar uma lista enorme de PDF */
                    /* Gerar um envio em massa de email */

                    System.out.println("---------------------------------");

                    System.out.println(processar.getNome());
                    System.out.println(processar.getEmail());

                    iterator.remove();

                    try {
                        Thread.sleep(1000); /* Dar um tempo para descarga de memoria */
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }

            try {
                Thread.sleep(1000); /* Processou lista e da um tempo para limpeza de memoria */
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}

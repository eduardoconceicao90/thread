package threads;

public class Sleep {

    public static void main(String[] args) throws InterruptedException {

        for (int pos = 0; pos < 10; pos++) {

            /* Executar esse envio com um tempo de parada ou com um tempo determinado */
            System.out.println("Excutando alguma rotina, por exemplo envio de e-mail");

            Thread.sleep(1000); /* Da um tempo */
        }

        System.out.println("Finalizou loop");
    }
}

import java.util.ArrayList;

public class Threadds extends Thread{
    private int numero;
    private boolean stay = true;
    private ArrayList<Integer> coloresHere;
    public Threadds(ArrayList<Integer> colores, int i){
        this.numero = i*51;
        this.coloresHere = colores;

        //return numero;
    }

    @Override
    public void run() {
        while(stay) {
            if (coloresHere.size() < 400) {
                // System.out.println(numero);
                coloresHere.add(numero);
                try {
                    Thread.sleep(0,1);
                } catch (InterruptedException e) {
                    System.err.println("Program failed");
                }
            } else {
                stay = false;
            }
        }
        Principal.colores = coloresHere;
    }
}

import java.util.ArrayList;

public class Threadds extends Thread{
    private int numero;
    private boolean stay = true;
    private ArrayList<Integer> coloresHere = new ArrayList<>();
    public int Threadds(ArrayList<Integer> colores, int i){
        this.numero = i*51;
        this.coloresHere = colores;

        return numero;
    }

    @Override
    public void run() {
        while(stay) {
            if (coloresHere.size() < 400) {
                System.out.println(numero);
                coloresHere.add(numero);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            } else {
                stay = false;
            }
        }
        Principal.colores = coloresHere;
    }
}

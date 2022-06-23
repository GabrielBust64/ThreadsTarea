import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class Principal {
    public static ArrayList<Integer> colores = new ArrayList<>();
    private static boolean stay = true;
    public static void main(String[] args) throws IOException {
        for (int i = 0; i <= 5; i++) {
            Threadds thread = new Threadds(colores,i);
            thread.start();
        }

        while(stay){
            if(colores.size()==400){
                crearImagen(colores);
                stay = false;
            }
        }
    }

    private static void crearImagen(ArrayList<Integer> colores) throws IOException {
        int[][] colores2d = new int[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                // System.out.println("[" + i + "] " + "[" + j + "]");
                colores2d[i][j]= colores.get((j*10)+i);
            }
        }

        BufferedImage imagen = new BufferedImage(20,20,BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Color whiteLevel = new Color(colores2d[i][j],colores2d[i][j],colores2d[i][j]);
                int rgb = whiteLevel.getRGB();
                imagen.setRGB(i,j,rgb);
            }
        }
        guardarImagen(imagen);
    }

    private static void guardarImagen(BufferedImage imagen) throws IOException {
        File file = new File("imagen.png");
        ImageIO.write(imagen, "png",file);
    }
}

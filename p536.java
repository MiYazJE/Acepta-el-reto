import java.util.*;

class Terreno {

    String nombre;
    int size;
    int cantidadAbono;
    int aguaNecesitada;
    int distancia;

    public Terreno(int size, int cantidadAbono, int aguaNecesitada, int distancia, String nombre) {
        this.nombre = nombre;
        this.size = size;
        this.cantidadAbono = cantidadAbono;
        this.aguaNecesitada = aguaNecesitada;
        this.distancia = distancia;
    }

}

public class p536 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int size, abono, agua, distancia;
        String nombre;
        Terreno res;

        while (s.hasNext()) {

            res = null;

            for (int i = s.nextInt(); i > 0; i--) {

                size = s.nextInt();
                abono = s.nextInt();
                agua = s.nextInt();
                distancia = s.nextInt();
                nombre = s.nextLine();

                if (res == null) {
                    res = new Terreno(size, abono, agua, distancia, nombre);
                }
                else {
                    if (res.size == size) {
                        if (res.aguaNecesitada == agua) {
                            if (distancia == res.distancia) {
                                if (abono < res.cantidadAbono) {
                                    res = new Terreno(size, abono, agua, distancia, nombre);
                                }
                            }
                            else if (distancia < res.distancia) {
                                res = new Terreno(size, abono, agua, distancia, nombre);
                            }
                        }
                        else if (agua < res.aguaNecesitada) {
                            res = new Terreno(size, abono, agua, distancia, nombre);
                        }
                    }
                    else if (size > res.size) {
                        res = new Terreno(size, abono, agua, distancia, nombre);
                    }
                }

            }

            System.out.println( res.nombre.trim() );
        }

    }

}

import java.util.Scanner;
import java.io.File;
public class Principal{
    public static void main(String[] args){
        mostrarMenu();
    }

    public static void mostrarMenu(){

        Scanner scan = new Scanner(System.in);
        boolean repetir = true;
        System.out.println("¡Bienvenido!");
        System.out.println("Ingrese una opción  de 1 a 10 o 666 para comenzar");
        while (repetir){ 

          int opcion = scan.nextInt();
            switch (opcion){
                case 0:
                repetir = false;
                System.out.println("Fin del programa");
                break;

                case 1:
                System.out.println("Vamos a registrar el vehiculo");
                System.out.println("Ingrese modelo del vehiculo");
                int mo = scan.nextInt();
                System.out.println("Ingrese marca del vehiculo");
                String ma = scan.next();
                System.out.println("Ingrese valor comercial del vehiculo");
                double va = scan.nextDouble();
                System.out.println("Ingrese color del vehiculo");
                String co = scan.next();
                Vehiculo V1 = new Vehiculo(mo, ma, va, co);
                break;

                case 2:
                System.out.println("Información de vehiculos almacenados: " +
                    Vehiculo.toStringVehiculos());
                break;

                case 3:
                System.out.println("Cantidad de vehiculos: " + Vehiculo.cantidadVehiculos());
                break;

                case 4:
                System.out.println("Información de vehiculos verdes: " + Vehiculo.toStringVehiculosVerde());
                break;

                case 5:
                try{ 
                    System.out.println("Ingrese Id del vehiculo");
                    int identificacion = scan.nextInt();
                    Vehiculo v1 = new Vehiculo();
                    v1 = Vehiculo.obtenerVehiculo(identificacion);
                    System.out.println("información de vehiculo: " + v1.toString());
                }catch(Exception e){
                    System.out.println("No se encuentra el vehiculo con ese Id");
                }
                break;

                case 6:
                try{ 
                    System.out.println("Ingrese Id del vehiculo");
                    int idv = scan.nextInt();
                    Vehiculo v1 = Vehiculo.obtenerVehiculo(idv);
                    System.out.println("Se le añadira un sensor al vehiculo");
                    System.out.println("Ingrese tipo de sensor");
                    String tipo= scan.next();
                    System.out.println("Ingrese valor del sensor");
                    double valor =scan.nextDouble();
                    Sensor s1 = new Sensor(tipo, valor); 
                    v1.anadirSensores(s1);
                }catch(Exception e){
                    System.out.println("Error, el vehiculo no se encuentra registrado");
                }
                break;
                
                case 7:
                try{
                    System.out.println("Ingrese un id");
                    int id2 = scan.nextInt();
                    Vehiculo v2 = Vehiculo.obtenerVehiculo(id2);
                    System.out.println("Información de los sensores del vehiculo "+ Sensor.mostrarSensores(v2.getSensores()));
                }catch(Exception e){
                    System.out.println("el vehiculo con el Id ingresado no se encuentra registrado");
                }
                break;
                
                case 8:
                System.out.println("Información sensores temperatura: " + Vehiculo.vehiculoSensores());
                break;
                
                case 9:
                System.out.println("Información vehiculo con más sensores " + Vehiculo.vehiculoMasSensores());   
                break;
                
                case 10:
                File file = new File("vehiculos.txt");
                try{
                    Scanner input = new Scanner(file);
                    String line;
                    while(input.hasNextLine()) {
                        line = input.nextLine();
                        String[] parts = line.split(",");
                        Vehiculo v1 = new Vehiculo(Integer.parseInt(parts[0]) ,parts[1],Double.parseDouble(parts[2]),parts[3]);

                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

                break;
                case 666:
                System.out.println("Información sensores" + Sensor.toStringSensores(Sensor.sensoresOrdenados(Vehiculo.vehiculos)));
                break;

                default:
                System.out.println("Ingresa un numero del 1 al 10 o el 666");
                break;
            }
        }
    }
}

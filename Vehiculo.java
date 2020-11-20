import java.util.ArrayList;
public class  Vehiculo{

    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static int idActual = 1;
    private int id;
    private int modelo;             // instacia de objeto
    private ArrayList <Sensor> sensores = new ArrayList<Sensor>();
    private String marca;
    private double valorComercial;
    private String color;

    public Vehiculo(){
        this.id = idActual ++; 
        vehiculos.add(this);
    } 

    public Vehiculo(int mo, String ma, double va){
        this(mo, ma,va,"verde");

    } 

    public Vehiculo(int mo, String ma, double va, String co){
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;
        this.id = idActual ++; 
        vehiculos.add(this);
    } 

    public  ArrayList getSensores(){
        return sensores;
    }

    public int getModelo(){
        return this.modelo;

    }

    public void setModelo(int mo){
        this.modelo = mo;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setMarca(String ma){
        this.marca = ma;
    }

    public double getValorComercial(){
        return this.valorComercial;
    }  

    public void setValorComercia(double va){
        this.valorComercial = va;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String co){
        this.color = co;
    }

    public int getId(){
        return this.id;

    }

    public void setId(int i){
        this.id = i;
    }

    public String toString(){
        String info = "";
        for(int i = 0; i < sensores.size(); i++){
            info = sensores.get(i).toString();
        }
        return " Id: "+ this.id +" Modelo: "+this.modelo + " Marca: "+ this.marca + " Valor: "+ this.valorComercial + 
        "Color "+this.color + "  " + info; 
    }

    public static String toStringVehiculos(){
        String salida = "";
        for(int i = 0; i < vehiculos.size(); i++){
            salida = vehiculos.toString()+ "\n";

        }   
        return salida;
    } 

    public static  int cantidadVehiculos(){
        return vehiculos.size();
    }

    public int cantidadSensores(){
        return sensores.size();
    }

    public void anadirSensores(Sensor s1){
        sensores.add(s1); 
    }

    public static String toStringVehiculosVerde(){
        String salida = "";
        for(int i = 0; i < vehiculos.size(); i++){
            if(vehiculos.get(i).getColor().equalsIgnoreCase("verde")){
                salida = salida + vehiculos.get(i).toString() + "\n";
            }
        }   
        return salida;
    }   

    public static String buscarEnArray(int identificacion){
        String buscar= "";
        for(int i = 0; i < vehiculos.size(); i++){
            if(vehiculos.get(i).getId() == identificacion){

                buscar = vehiculos.get(i).toString()+ "\n";
            }

        }
        return buscar;
    }

    public static Vehiculo obtenerVehiculo(int idv){

        Vehiculo v1=null;
        for(int i = 0; i < vehiculos.size(); i++){
            if(vehiculos.get(i).getId() == idv){
                v1 = vehiculos.get(i);
            }

        }
        return v1;

    }

    public static String vehiculoMasSensores(){
        Vehiculo v1 = vehiculos.get(0);

        for(int i = 0; i < vehiculos.size(); i++){
            if(vehiculos.get(i).sensores.size()> v1.sensores.size()){
                v1 = vehiculos.get(i);

            }
        }
        String vehiculo = v1.toString();
        return vehiculo;
    }

    public static String  vehiculoSensores(){
        String info ="";
        ArrayList<Sensor> sensor1 = new ArrayList<Sensor>();
        for(int i =0; i<vehiculos.size();i++){
            sensor1 = vehiculos.get(i).getSensores();
            info = info + Sensor.toStringSensoresTemperatura(sensor1);
        }
        return info;
    }
}
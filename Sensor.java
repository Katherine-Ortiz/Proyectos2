import java.util.ArrayList;
public class Sensor{
    private String tipo;
    private double valor; 
    private Vehiculo vehiculo;

    public Sensor(){
    }

    public Sensor(String t, double v){
        this.tipo = t;
        this.valor = v;
    }

    public double getValor(){
        return this.valor;
    }

    public void setValor(double v){
        this.valor = v;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String t){
        this.tipo = t;
    }

    public String toString(){
        return "Tipo: " + this.tipo +" Valor:  "+ this.valor;
    }

    public static String toStringSensores(ArrayList <Sensor> sensores){
        String info = "";
        for(int i = 0; i < sensores.size(); i++){
            info = info + sensores.get(i).toString() + "\n";
        }
        return info;
    }

    public static String toStringSensoresTemperatura(ArrayList <Sensor> sensores){
        String infoTem = "";
        for(int i = 0; i < sensores.size(); i++){
            if(sensores.get(i).getTipo().equals("temperatura")){
                infoTem = infoTem + sensores.get(i).toString() + "\n";
            }
        }
        return infoTem;
    }

    public static String mostrarSensores(ArrayList <Sensor> sensores){
        String info="";
        for(int i = 0; i < sensores.size(); i++){
             info = info + sensores.toString();
        }
        if(info==""){
            info = "El vehiculo no tiene sensores";
        } 
        return info;
    }
    
    public static ArrayList <Sensor> sensoresOrdenados(ArrayList <Vehiculo> vehiculos){
         ArrayList <Sensor> sensor1 = new ArrayList <Sensor>();
        for(int i=0; i< vehiculos.size(); i++){
            ArrayList <Sensor> sensores = vehiculos.get(i).getSensores();
            for(int j =0; j < sensores.size();j++){
            if(sensores.get(j).getTipo().equals("temperatura")){
               sensor1.add(sensores.get(j));
            }
        }
        }
        if(sensor1.size() >0){  
           Sensor aux = null;
            for(int i =0; i< sensor1.size(); i++){
                for(int j=0; j< sensor1.size() -i -1; j++ ){
                    if(sensor1.get(j+1).getValor() < sensor1.get(j).getValor()){
                        aux = sensor1.get(j+1);
                        sensor1.add(j+1,sensor1.get(j));
                        sensor1.add(j, aux);
                    }
                }
            } 
            return sensor1;
        } else{
            return null;
        }
    }
}
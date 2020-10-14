/**
 * La clase representa a un parking de una ciudad europea
 * que dispone de dos tarifas de aparcamiento para los clientes
 * que lo usen: la tarifa regular (que incluye una tarifa plana para
 * entradas "tempranas") y la tarifa comercial para clientes que trabajan
 * cerca del parking, aparcan un nº elevado de horas y se benefician de esta 
 * tarifa más económica
 * (leer enunciado)
 * 
 * @author-Irati Garcia
 */
public class Parking
{
    private final char REGULAR = 'R';   
    private final char COMERCIAL = 'C';   
    
    private final double PRECIO_BASE_REGULAR = 2.0;   
    private final double PRECIO_MEDIA_REGULAR_HASTA = 3.0;
    private final double PRECIO_MEDIA_REGULAR_DESPUES = 5.0;
    
    private final int HORA_INICIO_ENTRADA_TEMPRANA =  6 * 60;
    private final int HORA_FIN_ENTRADA_TEMPRANA =   8 * 60 + 30;
    private final int HORA_INICIO_SALIDA_TEMPRANA =  15 * 60;
    private final int HORA_FIN_SALIDA_TEMPRANA =  18 * 60;
    private final double PRECIO_TARIFA_PLANA_REGULAR =  15.0;
    
    private final double PRECIO_PRIMERAS_COMERCIAL =  5.00;
    private final double PRECIO_MEDIA_COMERCIAL =  3.00;

    private String nombre;
    private int cliente;
    private int importeTotal;
    private int regular;
    private int comercial;
    private int clientesLunes;
    private int clientesSabado;
    private int clientesDomingo;
    private int clienteMaximoComercial;
    private double importeMaximoComercial;
    
    
    
    /**
     * Inicializa el parking con el nombre indicada por el parámetro.
     * El resto de atributos se inicializan a 0 
     */
    public Parking(String queNombre)
    {
        nombre = queNombre;
        cliente = 0;
        importeTotal = 0;
        regular = 0;
        comercial = 0;
        clientesLunes = 0;
        clientesSabado = 0;
        clientesDomingo = 0;
        clienteMaximoComercial = 0;
        importeMaximoComercial = 0;
    }

    /**
     * accesor para el nombre del parking
     *  
     */
    public String getNombre() {
         return nombre;
    } 
    
    /**
     * mutador para el nombre del parking
     *  
     */
    public void insertarNombre (String nuevoNombre) {
        nombre = nuevoNombre;
    }

    /**
     *  Recibe cuatro parámetros que supondremos correctos:
     *    tipoTarifa - un carácter 'R' o 'C'
     *    entrada - hora de entrada al parking
     *    salida – hora de salida del parking
     *    dia – nº de día de la semana (un valor entre 1 y 7)
     *    
     *    A partir de estos parámetros el método debe calcular el importe
     *    a pagar por el cliente y mostrarlo en pantalla 
     *    y  actualizará adecuadamente el resto de atributos
     *    del parking para poder mostrar posteriormente (en otro método) las estadísticas
     *   
     *    Por simplicidad consideraremos que un cliente entra y sale en un mismo día
     *    
     *    (leer enunciado del ejercicio)
     */
    public void facturarCliente(char tipoTarifa, int entrada, int salida, int dia) {
        int hora_entrada = entrada / 100;
        int minutos_entrada = entrada % 100;
        int hora_salida = salida / 100;
        int minutos_salida = salida % 100;
        
        int horas_totales;
        int minutos_totales;
        
        double pago_horas;
        double pago_minutos;
        double pago_total;
        
        if(minutos_entrada <= minutos_salida)
        {
            horas_totales = hora_salida - hora_entrada;
            minutos_totales = minutos_salida - minutos_entrada;
        }else
        {
            horas_totales = hora_salida - hora_entrada - 1;
            minutos_totales = minutos_salida + (60 - minutos_entrada);
        }
        
        if(tipoTarifa == REGULAR)
        {
           if(entrada >= 600 && entrada <= 830 && 
              salida >= 1500 && salida <= 1800)
           {
               pago_horas = horas_totales * 15;
               pago_minutos = 15 * (minutos_totales / 60.0);
               pago_total = pago_horas + pago_minutos;
            }else
           {
              pago_horas = horas_totales * 17;
              pago_minutos = 17 * (minutos_totales / 60.0);
              pago_total = pago_horas + pago_minutos; 
           }
        }else
        {
       
        }
       
        
    }


    
    /**
     * Muestra en pantalla las estadísticcas sobre el parking  
     *   
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() {
         System.out.println("************************************************************");
         System.out.println("Importe total entre todos los clientes: " + importeTotal + "€");
         System.out.println("Nº clientes tarifa regular: " + regular);
         System.out.println("Nº clientes tarifa comercial: " + comercial);
         System.out.println("Cliente tarifa COMERCIAL con factura máxima fue el nº" + clienteMaximoComercial);
         System.out.println("y pagó " + importeMaximoComercial);
         System.out.println("************************************************************");        
    }

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que más clientes han utilizado el parking - "SÁBADO"   "DOMINGO" o  "LUNES"
     */
    public String diaMayorNumeroClientes() {
        String dia = "";
        
        if (clientesLunes > clientesSabado && clientesLunes > clientesDomingo){
            dia = "Lunes";
        }
        
        if (clientesSabado > clientesLunes && clientesSabado > clientesDomingo){
            dia = "Sábado";
        }
        
        if (clientesDomingo > clientesLunes && clientesDomingo > clientesSabado){
            dia = "Domingo";            
        }
        return dia;
    }

}

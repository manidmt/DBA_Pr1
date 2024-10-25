package dba_practica1;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.SequentialBehaviour;
import java.util.Scanner;

/**
 *
 * @author manidmt
 */
public class Tarea4_Agente extends Agent{
    
    private int numElementos;
    private int[] numeros;
    private int suma;
    
    private class SolicitarNumeros extends OneShotBehaviour {
        
        @Override
        public void action() {
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el número de elementos a leer: ");
            numElementos = scanner.nextInt();
            numeros = new int[numElementos];
        }
    }
    
    private class LeerNumeros extends Behaviour {
        
        private int contador = 0;
        
        @Override
        public void action() {
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el número " + (contador + 1) + ": ");
            numeros[contador] = scanner.nextInt();
            contador++;
        }
        
        @Override
        public boolean done() {
            return contador == numElementos;
        }
    }
    
    private class CalcularMedia extends OneShotBehaviour {
        
        @Override
        public void action() {
            
            suma = 0;
            for (int i = 0; i < numElementos; i++) {
                suma += numeros[i];
            }
            double media = (double) suma / numElementos;
            System.out.println("La suma es: " + suma);
            System.out.println("La media es: " + media);
            
            doDelete();
        }
    }
    
    @Override
    protected void setup() {
        
        System.out.println("Hola Manuel, Soy tu cuarto agente. Hago la media de los numeros que me des");
        
        SequentialBehaviour secuencia = new SequentialBehaviour();
        
        secuencia.addSubBehaviour(new SolicitarNumeros());
        secuencia.addSubBehaviour(new LeerNumeros());
        secuencia.addSubBehaviour(new CalcularMedia());
        
        addBehaviour(secuencia)
;    }
    
    @Override
    protected void takeDown(){
            
        System.out.println("Terminating agent...");
    }
}

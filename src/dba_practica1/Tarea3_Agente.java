package dba_practica1;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;


/**
 *
 * @author manidmt
 */
public class Tarea3_Agente extends Agent{
    
    private class Comportamiento extends CyclicBehaviour{
        
        @Override
        public void action() {

            System.out.println("Hola Manuel, Soy tu tercer agente. Me ejecuto cíclicamente"); 
            block(2000); // Esperar 2 segundos
        }
        
        protected void takeDown(){
            
            System.out.println("Terminating agent...");
        }
    }
    
    @Override
    protected void setup(){
        
        addBehaviour(new Comportamiento());
    }
}

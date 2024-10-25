package dba_practica1;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
/**
 *
 * @author manidmt
 */
public class Tarea2_Agente extends Agent {
    
    private class Comportamiento extends OneShotBehaviour{
        
        @Override
        public void action() {

            System.out.println("Hola Manuel, Soy tu segundo agente. Solo me ejecuto una vez"); 
            System.out.println("My local-name is" + getAID().getLocalName());
            System.out.println("My GUID is " + getAID().getName());
            doDelete();
        }
        
        protected void takeDown(){
            
            System.out.println("Terminating agent...");
        }
    }
    
    @Override
    protected void setup(){
        
        addBehaviour( new Comportamiento());
    }
    
    @Override
    protected void takeDown()
    {
        System.out.println("Terminating agent...");
    }
}

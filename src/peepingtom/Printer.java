package peepingtom;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que realiza a impressão da gráfica
 * @author Inatan e Marina
 */
public class Printer {
    private final int  X= 6; // valor de impressões máximas no dia
    private final int T=5000; // tempo de impressão expresso em milisegundos
    private boolean printing; // booleano que verifica se a impressora está trabalhando
    private int printednum; // numero de pedidos que já foram impressos
    
    Printer(){ // construtor
        this.printing= false;
        this.printednum=0;
    }
    
    
    /**
     * Método realiza a impressão de um pacote
     * Utiliza wait() para thread que está esperando outra que está imprimindo
     * Quando a impressão é concluida é chamado o Notify para acordar a próxima thread na fila
     * @param p - pacote que será impresso 
     */
    public void  print(Packet p){
        if(printednum < X){
            while(printing){
                try {
                       p.wait();
                }catch (InterruptedException ex) {
                        Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            printing = true;
            System.out.println("Packet " + p.getid() + " is printing right now");
            try {
                Thread.sleep(T);
            } catch (InterruptedException ex) {
                Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
            }
            printing=false;
            printednum++;
            synchronized(p){ // garante que não haverá erro entre duas threads executando em partes diferentes na mesma funçao em caso de notify apenas
                p.notify();
            }
        }
        else{
            System.out.println("Limit exceeded..."); // mensagem de limite excedido
        }
            
    }
    
    
    /**
     * @return booleando caso a impressora chegou o limite do dia
    */
    public boolean dayLimit(){
        return printednum >= X;
    }
}

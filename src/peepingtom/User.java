/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peepingtom;

import java.util.logging.Level;
import java.util.logging.Logger;
import static peepingtom.PeepingTom.packets;
import static peepingtom.PeepingTom.printer;

/**
 * A classe de Usuário envia requisições em um pacote o qual é mandado para a impressora
 * @author Inatan e Marina
 */
public class User implements UserPrint, Runnable{
    private int id; // id do usuário
    private static int newid=0;// id nova para cada usuário adicionado
    
    /**
     * Construtor do Objeto
     */
    public User(){
        this.id=newid;
        newid++; // atualiza id para o próximo usuário
    }
    
    /**
     * @return o valor máximo de usuários presentes
     */
    public static int numberofUsers(){
        return newid;
    }
    
    /**
     * @return id do usuário
     */
    public int getid(){
        return id;
    }

    /**
     * Executa enquanto o limite de impressões não é excedido procurando pacotes para enviar requisições
     */
    @Override
    public void run() {
        while(!printer.dayLimit()){
            try {
                Packet.findpacket(this);
            } catch (InterruptedException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }
}

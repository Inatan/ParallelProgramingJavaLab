/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peepingtom;

import java.util.ArrayList;
import static peepingtom.PeepingTom.packets;
import static peepingtom.PeepingTom.printer;

/**
 * Classe de pacotes que são preenchidos por requisições e mandados para a impressora
 * @author Inatan e Marina
 */


public class Packet implements PacketPrint, Runnable{
    private int id; // id do pacote 
    private final int maxUsers = 10; // maximo suportado pelos pacotes 
    private ArrayList usersId; // lista de requisições de usuários
    public boolean ready = false; // booleando que verifica se o pacote está pronto para ser impresso
    private static int newid = 1; // nova id para novos pacotes
    
    /**
     * Construtor do objeto
     */
    Packet(){
        id =  newid;
        newid++; // atualiza para proximo pacote
        usersId= new ArrayList();
    }
    
    /**
     * Limpa a lista para ser reenviado para fila
     */
    public void eraseList(){
        usersId=new ArrayList();
    }
    
    /**
     * @return id do pacote
     */
    public int getid(){
        return this.id;
    }
    
    /**
     * @param userid - inteiro com a ide do usuário que é adicionado na lista de pacotes 
     * insere usuário no primeiro pacote da fila
     */
    @Override
    public void addUser(int userid){ 
        if(usersId.size() < maxUsers ){ // verifica se o limite do pacote é excedido
            usersId.add(userid); // adiciona usuário no pacote
            if (usersId.size()==maxUsers) // verifica se chegou o limite
                ready=true; //pacote está pronto para ser mandado para a impressora
        }
        
    }
    
    /**
     * @param u - Usuário procura pacote na fila para inserir o seus dados para a impressão
     * @throws InterruptedException caso de erro da thread 
     */
    public synchronized static  void findpacket(User u) throws InterruptedException{
       if(!packets.isEmpty()){ 
            packets.element().addUser(u.getid());
            if(packets.element().ready)
            {  
                Packet p = packets.element();
                p.eraseList();
                packets.add(p);
                Thread t =new Thread(packets.poll());
                t.start();
                t.join();
            }
       }
    }
    
    /**
     * Quando o pacote está pronto é mandado para a impressora
     */
    @Override
    public void run() {
        printer.print(this);
    }
    
}

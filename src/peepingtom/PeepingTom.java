/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peepingtom;

import java.util.*;

/**
 * Classe Peeping Tom main do problema
 * @author Inatan e Marina
 */
public class PeepingTom {

    static Printer printer = new Printer(); // impressora da PeepingTom
    static Queue<Packet> packets =new LinkedList<Packet>(); // fila de pacotes para a impressora
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Packet p1 = new Packet();
        Packet p2 = new Packet();
        Packet p3 = new Packet();
        Packet p4 = new Packet();
        Packet p5 = new Packet();
        Packet p6 = new Packet();
        Packet p7 = new Packet();
        Packet p8 = new Packet();
        Packet p9 = new Packet();
        Packet p10 = new Packet();
        
        packets.add(p1);
        packets.add(p2);
        packets.add(p3);
        packets.add(p4);
        packets.add(p5);
        packets.add(p6);
        packets.add(p7);
        packets.add(p8);
        packets.add(p9);
        packets.add(p10);
        
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        User u4 = new User();
        User u5 = new User();
        User u6 = new User();
        User u7 = new User();
        User u8 = new User();
        User u9 = new User();
        User u10 = new User();
        User u11 = new User();
        User u12 = new User();
        User u13 = new User();
        User u14 = new User();
        User u15 = new User();
        User u16 = new User();
        User u17 = new User();
        User u18 = new User();
        User u19 = new User();
        User u20 = new User();
        
        System.out.println("The number of Users is " + User.numberofUsers()); // letra b
        // a construção de usuário já permite saber a quantidade de usuários sem precisar ativar thread primeiro
        
        new  Thread (u1).start();
        new  Thread (u2).start();
        new  Thread (u3).start();
        new  Thread (u4).start();
        new  Thread (u5).start();
        new  Thread (u6).start();
        new  Thread (u7).start();
        new  Thread (u8).start();
        new  Thread (u9).start();
        new  Thread (u10).start();
        new  Thread (u11).start();
        new  Thread (u12).start();
        new  Thread (u13).start();
        new  Thread (u14).start();
        new  Thread (u15).start();
        new  Thread (u16).start();
        new  Thread (u17).start();
        new  Thread (u18).start();
        new  Thread (u19).start();
        new  Thread (u20).start();     
    }
}

package semaforodos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import javax.swing.*;

public class SemaforoDos implements Runnable{

    //Este boolean es True(verdadero)
    public boolean iterar;
    /*Declaracion de variables: colores del semaforo y el indicador de segundos
    junto con los contadores de los colores*/
    public JButton jButtonRojo;
    public JButton jButtonAmarillo;
    public JButton jButtonVerde;
    public JTextField jTextFieldTiempo;
    public int contador=0, temp=0, temp2=0, temp3=0, temp4=0, timer=0;
    
    
    //Constructor o declaracion de parametros
    public SemaforoDos(JButton entrada1,JButton entrada2,JButton entrada3,JTextField entrada4)
    {
    this.jButtonRojo = entrada1;
    this.jButtonAmarillo = entrada2;
    this.jButtonVerde = entrada3;
    this.jTextFieldTiempo = entrada4;
    }
    
    @Override
    public void run(){
        
        //Mientras iterar sea True(verdadero)
        while(iterar)
        {
            //El tiempo va a incrementar
            contador++;
            
            //Hasta que contador sea 35, será rojo
            if(contador>=1 && contador<=35)
            {
                temp++;
                jTextFieldTiempo.setText(""+temp);
            }
            
            /*Si contador es 1, buttonrojo será de color rojo y los
            demas de color gris*/
            if(contador==1)
            {
                jButtonRojo.setBackground(Color.red);
                jButtonAmarillo.setBackground(Color.gray);
                jButtonVerde.setBackground(Color.gray);
                
            }
            
            //Hasta que contador sea 55, cambiará de rojo a amarillo
            if(contador>=35 && contador<=55)
            {
                temp2++;
                jTextFieldTiempo.setText(""+temp2);
            }
            
            /*Si contador es 35, buttonamarillo será de color amarillo 
            y los demas de color gris*/
            if(contador==35)
            {
                jButtonRojo.setBackground(Color.gray);
                jButtonAmarillo.setBackground(Color.yellow);
                jButtonVerde.setBackground(Color.gray);
            }
             
            //////PARPADEO///////
            if(contador>=36 && contador<=51){
                Timer uno = new Timer (500, new ActionListener ()       
                {
                private int count = 0;
                private int maxCount = 4;
                private boolean on = false;
                    public void actionPerformed(ActionEvent e)
                    { 
                    if (count >= maxCount) {
                        jButtonAmarillo.setBackground(null);
                        ((Timer) e.getSource()).stop();
                    } else {
                        jButtonAmarillo.setBackground( on ? Color.YELLOW : null);
                        on = !on;
                        count++;
                    }
                    }
            });

            uno.start();
            }
            /////////////
            
            //Hasta que contador sea 90, cambiará de amarillo a verde
            if(contador>=55 && contador<=90)
            {
                temp3++;
                jTextFieldTiempo.setText(""+temp3);
            }
            
            /*Si contador es 55, buttonverde será de color verde 
            y los demas de color gris*/
            if(contador==55)
            {
                jButtonRojo.setBackground(Color.gray);
                jButtonAmarillo.setBackground(Color.gray);
                jButtonVerde.setBackground(Color.green);
            }
            
            
            //Hasta que contador sea 110, cambiará de verde a amarillo
            if(contador>=90 && contador<=110)
            {
                temp4++;
                jTextFieldTiempo.setText(""+temp4);
            }
            
            /*Si contador es 90, buttonamarillo será de color amarillo 
            y los demas de color gris*/
            if(contador==90)
            {
                jButtonRojo.setBackground(Color.gray);
                jButtonAmarillo.setBackground(Color.yellow);
                jButtonVerde.setBackground(Color.gray);
            }

            //////PARPADEO///////
            if(contador>=91 && contador<=106){
                Timer uno = new Timer (500, new ActionListener ()       
                {
                private int count = 0;
                private int maxCount = 4;
                private boolean on = false;
                    public void actionPerformed(ActionEvent e)
                    { 
                    if (count >= maxCount) {
                        jButtonAmarillo.setBackground(null);
                        ((Timer) e.getSource()).stop();
                    } else {
                        jButtonAmarillo.setBackground( on ? Color.YELLOW : null);
                        on = !on;
                        count++;
                    }
                    }
            });

            uno.start();
            }
            /////////////
            
            /*Si contador es 109, todos los temp y contador valdrán 0
            por lo tanto empezará de nuevo el ciclo*/
            if(contador==109)
            {
                contador=0;
                temp=0;
                temp2=0;
                temp3=0;
                temp4=0;
            }
            
            try{
                sleep(1000);
            }   catch (Exception e){   
            }
        }
    }
    
    //Metodo iniciar
    public void start()
    {
        iterar = true;
        new Thread(this).start();
    }
    
    //Metodo detener
    public void detener()
    {
        contador=0;
        temp=0;
        temp2=0;
        temp3=0;
        temp4=0;
        jTextFieldTiempo.setText("");
    }
    
    //Metodo reiniciar
    public void reiniciar()
    {
        iterar = false;
    }
}

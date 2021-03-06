/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomiNations;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.ScrollPaneConstants;


/**
 *
 * @author Jessica
 */
public class Estadisticas extends JWindow
{ 
    int oro, comida, aldeanos;
    int oro_total, comida_total,aldeanos_disponibles;
    JPanel panel;
    JLabel et1, et2, et3, titulo1, titulo2;
    int x,y;
    ArrayList<LEF> listaLEF = new ArrayList<LEF>();
    JTextArea texto;
    JScrollPane scroll;
    int pos;
    
    public Estadisticas(){
    
    }
    
    public Estadisticas(int o, int c, int ad,int ot, int ct, int a)
    {
        super();
        oro=o;
        comida=c;
        aldeanos_disponibles=ad; 
        
        oro_total=ot;
        comida_total=ct;
        aldeanos=a;
    }    
    
    public void mostrar()
    {
        this.setBounds(x,y,240,600);
        this.getContentPane().setBackground(Color.BLACK);
        this.setEnabled(true);
        
        panel = new JPanel();
        panel.setBounds(10,10,220,580);
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        
        et1 = new JLabel("Oro: "+oro+"/"+oro_total);
        et1.setFont(new Font("Arial",Font.BOLD, 16));
        et1.setBounds(5,45,210,40);
        et1.setForeground(Color.WHITE);
        et1.setVisible(true);
        
        et2 = new JLabel("Comida: "+comida+"/"+comida_total);
        et2.setFont(new Font("Arial",Font.BOLD, 16));
        et2.setBounds(5,85,210,40);
        et2.setForeground(Color.WHITE);
        et2.setVisible(true);
        
        et3 = new JLabel("Aldeanos: "+aldeanos_disponibles+"/"+aldeanos);
        et3.setFont(new Font("Arial",Font.BOLD, 16));
        et3.setBounds(5,125,210,40);
        et3.setForeground(Color.WHITE);
        et3.setVisible(true);
        
        titulo1 = new JLabel("Estadísticas");
        titulo1.setFont(new Font("Arial",Font.BOLD, 18));
        titulo1.setBounds(55,10,110,40);
        titulo1.setForeground(Color.ORANGE);
        titulo1.setVisible(true);
        
        titulo2 = new JLabel("LEF");
        titulo2.setFont(new Font("Arial",Font.BOLD, 18));
        titulo2.setBounds(90,175,40,40);
        titulo2.setForeground(Color.ORANGE);
        titulo2.setVisible(true);
        
        texto = new JTextArea();
        texto.setFont(new Font("Arial",Font.BOLD,12));
        texto.setForeground(Color.DARK_GRAY);
        texto.setText(" Tiempo |        Descripcion");
        texto.append("\n___________________________");
        mostrar_LEF();
        texto.setBounds(5,230,210,320);
        
        scroll = new JScrollPane(texto);
        scroll.setBounds(5,230,210,320);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        panel.add(et1);
        panel.add(et2);
        panel.add(et3);
        panel.add(titulo1);
        panel.add(titulo2);
        panel.add(scroll);
        
        this.add(panel);
        
        this.setLayout(null);
        this.setVisible(true);
    }
    
    
    public void insertar_LEF(LEF obj)
    {
        System.out.println(obj.descripcion+" "+obj.tiempo+" "+obj.posicion);
        listaLEF.add(obj);
        pos++;
    }
    
    public void mostrar_LEF()
    { 
        for (LEF l : listaLEF)
        {
            texto.append(l.getLinea());
        }
    }
    public int Consultar_LEF(int tiempo){
        for (LEF l : listaLEF)
        {
           if(l.tiempo==tiempo ){
               if(l.evento_ocurrio==0){
               System.out.println("Ocurrio el evento "+l.descripcion);   
               
               l.evento_ocurrio=1;
               return l.posicion;
               
               }
           }
        }
        return -1;
     
    }
    
    public Estadisticas ConsultarRecursos_LEF(int tiempo, Estadisticas e){
     
        for (LEF l : listaLEF)
        {
           if(l.tiempo==tiempo ){
               if(l.evento_ocurrio==0){
               System.out.println("Ocurrio el evento "+l.descripcion);   
               if(l.descripcion.compareTo("Mina")==0){
                   System.out.println("AQUIIII");
               }
              
               l.evento_ocurrio=1;
               return e;
               
               }
           }
        }
        return null;
    }
    
    
    
    
      public int ConsultarTiempoEvento_LEF(String descripcion){
        for (LEF l : listaLEF)
        {
           if(l.descripcion.compareTo(descripcion)==0){
               if(l.evento_ocurrio==0){
               System.out.println("Ocurrio el evento "+l.descripcion);               
               l.evento_ocurrio=1;
               return l.tiempo;
               
               }
           }
        }
        return -1;
     
    }
    
  
    
    public void setOro(int o)
    {
        oro=o;
        et1.setText("Oro: "+oro+"/"+oro_total);
    }
    
    public void setAldeanos(int a)
    {
        aldeanos=a;
        et3.setText("Aldeanos: "+aldeanos_disponibles+"/"+aldeanos);
    }
    
    public void setComida(int c)
    {
        comida=c;
        et2.setText("Comida: "+comida+"/"+comida_total);

    }
    
    public void setOroTotal(int ot)
    {
        oro_total=ot;
        et1.setText("Oro: "+oro+"/"+oro_total);
    }
    
    public void setComidaTotal(int ct)
    {
        comida_total=ct;
        et2.setText("Comida: "+comida+"/"+comida_total);
    }
    
    public void setOro_Actual(int ot)
    {
        oro=ot;
        et1.setText("Oro: "+oro+"/"+oro_total);
    }
    
    public void setComida_Actual(int ct)
    {
        comida=ct;
        et2.setText("Comida: "+comida+"/"+comida_total);
    }
    
    public void setAldeanosDisponibles(int a)
    {
        aldeanos_disponibles=a;
        et3.setText("Aldeanos: "+aldeanos_disponibles+"/"+aldeanos);
    }
    
    public void Agregar_evento_al_text_area(LEF aux){
        texto.append("\n"+aux.descripcion+"  |  "+aux.tiempo);
    }
    
    
}

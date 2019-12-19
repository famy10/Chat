

package chat;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 
 */
public class MServidor extends Thread{
	//***** Declaración de variables**************************************  
	//VARIABLE
    private int port;
    //JFrame
    private JFrame ventana;
    //------ Fin de declaración de variables ---------------------------- 
    
    /** Creates a new instance of MServidor */
    public MServidor(JFrame ventana, int port) {
        this.port = port;
        this.ventana = ventana;
    }
    
    public void run(){
        ServerSocket ss=null;
        try{
            ss=new ServerSocket(port);
            while (true){
                Socket s=ss.accept();
                MSGestorConexiones.getInstance().conectaNuevo(new MSConexion(s));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana,"Error al abrir el puerto. Posiblemente ya esté en uso.");
        }
        try{
            ss.close();
        }catch(Exception e){
        }
    }//fin public void run()
    
}

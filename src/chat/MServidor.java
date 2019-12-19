

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
	//***** Declaraci�n de variables**************************************  
	//VARIABLE
    private int port;
    //JFrame
    private JFrame ventana;
    //------ Fin de declaraci�n de variables ---------------------------- 
    
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
            JOptionPane.showMessageDialog(ventana,"Error al abrir el puerto. Posiblemente ya est� en uso.");
        }
        try{
            ss.close();
        }catch(Exception e){
        }
    }//fin public void run()
    
}

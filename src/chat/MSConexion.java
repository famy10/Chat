

package chat;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *

 */
public class MSConexion extends Thread{
    
    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String nick;
    
    /** Creates a new instance of MSConexion */
    public MSConexion(Socket s) {
        try{
            this.s=s;
            dis=new DataInputStream(s.getInputStream());
            dos=new DataOutputStream(s.getOutputStream());
            start();
        }catch(Exception e){
        }
    }//fin public MSConexion(Socket s)
    
    public String getNick(){
        return nick;
    }
    
    public void run(){
        while (true){
            try{
                int nCodigo=dis.readInt();
                String sTrama=dis.readUTF();
                switch(nCodigo){
                    case 1:
                        nick=sTrama;
                        MSGestorConexiones.getInstance().enviarTrama(nCodigo, sTrama);
                        break;
                    case 2:
                        sTrama="<" + nick + "> - " + sTrama;
                        MSGestorConexiones.getInstance().enviarTrama(nCodigo, sTrama);
                        break;
                    case 3:
                        MSGestorConexiones.getInstance().desconecta(this);
                        break;
                }
                
            }catch(Exception e){
            }
            
        }
    }//public void run()
    
    public void enviarTrama(int nCodigo, String sTrama){
        try{
           dos.writeInt(nCodigo);
           dos.writeUTF(sTrama);
        }catch(Exception e){
        }
    }//fin public void enviarTrama(int nCodigo, String sTrama)
}

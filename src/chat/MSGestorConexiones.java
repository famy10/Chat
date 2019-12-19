

package chat;

import java.util.ArrayList;

/**
 *

 */
public class MSGestorConexiones {
    
    private static MSGestorConexiones singleton=new MSGestorConexiones();
    public  static MSGestorConexiones getInstance(){
        return singleton;
    }
    
    private ArrayList<MSConexion> conexiones = new ArrayList<MSConexion>();
    
    public void enviarTrama(int nCodigo, String sTrama){
        for (MSConexion ms:conexiones){
            ms.enviarTrama(nCodigo, sTrama);
        }
    }//fin public void enviarTrama(int nCodigo, String sTrama)
    
    public void conectaNuevo(MSConexion nuevo){
        for (MSConexion ms:conexiones){
            nuevo.enviarTrama(1, ms.getNick());
        }
        conexiones.add(nuevo);
    }//fin public void conectaNuevo(MSConexion nuevo)
    
    public void desconecta(MSConexion eliminar){
        int nPos=-1;
        for (int n=0;n<conexiones.size();n++){
            if (conexiones.get(n)==eliminar){
                nPos=n;
            }
        }
        if (nPos!=-1){
            for (int n=0;n<conexiones.size();n++){
                if (n!=nPos){
                    conexiones.get(n).enviarTrama(3, ""+nPos);
                }
            }
            conexiones.remove(nPos);
        }
    }  //fin public void desconecta(MSConexion eliminar)  
    
}

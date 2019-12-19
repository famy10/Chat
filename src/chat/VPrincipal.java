

package chat;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 
 */
public class VPrincipal extends javax.swing.JFrame {
//***** Declaración de variables 
	private JPanel contentPane;
	private JButton jbn_AbrirVentanaServidor;
    private JButton jbn_abrirVentanaCliente;
//------ Fin de declaración de variables
    /** Creates new form VPrincipal */
    public VPrincipal() {
        initComponents();
    }
    
   
   
    private void initComponents() {
        
    	this.setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); //absolute layout
        
        jbn_AbrirVentanaServidor = new JButton();
        jbn_AbrirVentanaServidor.setText("Abrir ventana servidor");
        jbn_AbrirVentanaServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jbn_AbrirVentanaServidor.setBounds(27, 29, 181, 30);
        contentPane.add(jbn_AbrirVentanaServidor);
        
        

        jbn_abrirVentanaCliente = new JButton();
        jbn_abrirVentanaCliente.setText("Abrir ventana cliente");
        jbn_abrirVentanaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jbn_abrirVentanaCliente.setBounds(27, 89, 181, 30);
        contentPane.add(jbn_abrirVentanaCliente);

       
    } //fin private void initComponents()

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
        (new VCliente()).setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
        (new VServidor()).setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPrincipal().setVisible(true);
            }
        });
    }
    
  
    
}

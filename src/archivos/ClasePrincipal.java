package archivos;

import archivos.gui.FileInfo;
import javax.swing.JFrame;

/**
 * Clase principal de la aplicacion.
 *
 * @author Jhoan Munoz
 */
public class ClasePrincipal
{
    /**
     * Crea e inicializa el componente principal de GUI.
     *
     * @param args Argumentos pasados por consola.
     */
    public static void main(String args[])
    {
        JFrame frame = new JFrame("FileInfo");
        frame.setContentPane(new FileInfo().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}

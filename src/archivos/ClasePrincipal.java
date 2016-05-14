package archivos;

import archivos.gui.FileEditor;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
        JFrame frame = new JFrame("Hyper Editor");
        frame.setContentPane(new FileEditor().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 600);
        frame.setVisible(true);
        frame.setResizable(false);

        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
    }
}

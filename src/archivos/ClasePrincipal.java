package archivos;

import archivos.gui.TranslatorGUI;

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
        JFrame frame = new JFrame("Translator");
        frame.setContentPane(new TranslatorGUI().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(280, 125);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}

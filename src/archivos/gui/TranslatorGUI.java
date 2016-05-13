package archivos.gui;

import archivos.reader.Translator;

import javax.swing.*;

/**
 * GUI para una aplicacion que traduce palabras de español a ingles.
 *
 * @author Jhoan Munoz
 */
public class TranslatorGUI
{
    private JTextField spanish;
    private JTextField english;
    private JButton translate;
    private JPanel mainPanel;

    /**
     * Inicializa los escuchadores
     */
    public TranslatorGUI()
    {
        spanish.addActionListener(actionEvent -> translate());
        translate.addActionListener(actionEvent -> translate());
    }

    /**
     * Utiliza una instancia de {@link Translator} para traducir a ingles la palabra escrita en el
     * campo de texto correspondiente a español.
     */
    private void translate()
    {
        english.setText(new Translator().translate(spanish.getText()));
    }

    /**
     * Da acceso al panel principal de la GUI.
     *
     * @return El {@link JPanel} principal de la aplicacion
     */
    public JPanel getMainPanel()
    {
        return mainPanel;
    }
}

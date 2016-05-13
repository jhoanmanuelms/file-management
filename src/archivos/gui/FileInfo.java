package archivos.gui;

import archivos.reader.FileController;

import javax.swing.*;

/**
 * GUI para una aplicacion que carga los datos basicos de un archivo o carpeta en una ruta
 * especifica.
 *
 * @author Jhoan Munoz
 */
public class FileInfo
{
    private JPanel mainPanel;
    private JTextField nombreArchivo;
    private JScrollPane scrollPanel;
    private JTextArea infoArchivo;

    /**
     * Inicializa los escuchadores
     */
    public FileInfo()
    {
        nombreArchivo.addActionListener(actionEvent -> getFileInfo());
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

    /**
     * Utiliza una instancia de {@link FileController} para cargar la informacion del archivo o
     * carpeta de la ruta especificada en el campo de texto.
     */
    private void getFileInfo()
    {
        FileController fileController = new FileController(nombreArchivo.getText());
        infoArchivo.setText(fileController.getFileInfo());
    }
}

package archivos.gui;

import archivos.reader.FileController;

import javax.swing.*;

/**
 * GUI para un editor de texto simple.
 */
public class FileEditor
{
    private JPanel mainPanel;
    private JButton open;
    private JButton save;
    private JTextArea fileContent;
    private FileController fileController;

    /**
     * Inicializa componentes y escuchadores.
     */
    public FileEditor()
    {
        open.setIcon(new ImageIcon("resources/img/abrir.JPG"));
        save.setIcon(new ImageIcon("resources/img/guardar.JPG"));

        open.addActionListener(actionEvent -> openFile());
        save.addActionListener(actionEvent -> saveFile());
    }

    /**
     * Selecciona el archivo especificado por el usuario y muestra su contenido en el area de texto.
     */
    private void openFile()
    {
        JFileChooser fileChooser = new JFileChooser();
        int selection = fileChooser.showOpenDialog(mainPanel);

        if (selection == JFileChooser.APPROVE_OPTION)
        {
            fileController = new FileController(fileChooser.getSelectedFile());
            fileContent.setText(fileController.getFileContent());
        }
    }

    /**
     * Toma el contenido del area de texto y la guarda en el archivo seleccionado por el usuario.
     */
    private void saveFile()
    {
        if (fileContent.getText().equals(""))
        {
            JOptionPane.showMessageDialog(
                null, "Debes escribir algo para guardar", "Ojo", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JFileChooser fileChooser = new JFileChooser();
            int selection = fileChooser.showOpenDialog(mainPanel);

            if (selection == JFileChooser.APPROVE_OPTION)
            {
                fileController = new FileController(fileChooser.getSelectedFile());
                fileController.save(fileContent.getText());
            }
        }
    }

    public JPanel getMainPanel()
    {
        return mainPanel;
    }
}

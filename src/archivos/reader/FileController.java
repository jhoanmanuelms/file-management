package archivos.reader;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

/**
 * Controlador para realizar acciones con archivos.
 *
 * @author Jhoan Munoz
 */
public class FileController
{
    /** Referencia de {@link File} que apuntara al archivo con el que se esta trabajando. */
    protected File file;

    /**
     * Busca el archivo o carpeta referenciado en el parametro e inicializa la referencia.
     *
     * @param fileName Ruta al archivo o carpeta.
     */
    public FileController(String fileName)
    {
        file = new File(fileName);
    }

    /**
     * Inicializa el controlador con el archivo entregado.
     *
     * @param file Archivo que sera manejado por el controlador.
     */
    public FileController(File file)
    {
        this.file = file;
    }

    /**
     * Obtiene la informacion del archivo o carpeta referenciado en el constructor.
     *
     * @return Si la ruta apunta a un archivo, retorna el contenido. Si apunta a una carpeta retorna
     *         cada uno de los archivos contenidos en la misma. En ambos casos retorna tambien la
     *         ruta relativa y absoluta.
     */
    public String getFileInfo()
    {
        StringBuilder fileInfo = new StringBuilder();
        if (file.exists())
        {
            fileInfo.append("\nRuta: " + file.getPath() + "\nRuta absoluta: " + file.getAbsolutePath());

            if (file.isFile())
            {
                fileInfo.append(getFileContent());
            }
            else if (file.isDirectory())
            {
                fileInfo.append("\n\nCONTENIDO DE LA CARPETA:\n");

                for (String contenido : file.list())
                {
                    fileInfo.append(contenido + "\n");
                }
            }
        }
        else
        {
            fileInfo.append("La ruta especificada no apunta a ningun archivo o carpeta");
        }

        return fileInfo.toString();
    }

    /**
     * Lee el contenido del archivo por medio de una instancia de {@link RandomAccessFile}.
     *
     * @return El contenido del archivo.
     */
    public String getFileContent()
    {
        StringBuilder fileContent = new StringBuilder();
        try
        {
            RandomAccessFile fileReader = new RandomAccessFile(file, "r");
            String line = fileReader.readLine();

            while (line != null)
            {
                fileContent.append("\n").append(line);
                line = fileReader.readLine();
            }

        }
        catch (FileNotFoundException fne)
        {
            JOptionPane.showMessageDialog(
                null,
                "El archivo no existe",
                "ERROR EN ARCHIVO",
                JOptionPane.ERROR_MESSAGE);
            fne.printStackTrace();
        }
        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(
                null,
                "Error al leer el archivo",
                "ERROR EN ARCHIVO",
                JOptionPane.ERROR_MESSAGE);
            ioe.printStackTrace();
        }

        return fileContent.toString();
    }

    /**
     * Guarda el contenido entregado como parametro en el archivo.
     *
     * @param fileContent Contenido a guardar.
     */
    public void save(String fileContent)
    {
        try
        {
            PrintStream printStream = new PrintStream(new FileOutputStream(file));
            printStream.println(fileContent);
            printStream.flush();
            printStream.close();
        }
        catch (FileNotFoundException fne)
        {
            JOptionPane.showMessageDialog(
                null,
                "El archivo no existe",
                "ERROR EN ARCHIVO",
                JOptionPane.ERROR_MESSAGE);
            fne.printStackTrace();
        }
    }
}

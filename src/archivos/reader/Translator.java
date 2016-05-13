package archivos.reader;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Clase especializada de {@link FileController} que se lee una base de datos de palabras para
 * realizar traducciones de español a ingles.
 *
 * @author Jhoan Munoz
 */
public class Translator extends FileController
{
    /** Ruta del archivo que contiene la base de datos de palabras. */
    private static final String TRANSLATION_DATABASE = "resources/input/data.txt";

    /** Lector utilizado para consultar la base de datos de palabras. */
    private RandomAccessFile fileReader;

    /**
     * Inicializa la referencia a la base de datos de palabras.
     */
    public Translator()
    {
        super(TRANSLATION_DATABASE);
        try
        {
            fileReader = new RandomAccessFile(file, "r");
        }
        catch (FileNotFoundException fne)
        {
            JOptionPane.showMessageDialog(
                null,
                "La base de datos de traduccion no fue encontrada",
                "Error Base Datos Traduccion",
                JOptionPane.ERROR_MESSAGE);
            fne.printStackTrace();
        }
    }

    /**
     * Busca la palabra entregada como parametro dentro de la base de datos de palabras y retorna su
     * respectiva traduccion a ingles. Se espera que la base de datos de palabras tenga el formato
     * palabra_espanol#palabra_ingles y esten escritas en mayuscula. Ejemplo: PERRO#DOG
     *
     * @param word Palabra en espanol
     *
     * @return Traduccion a ingles de la palabra entregada como parametro. Un mensaje de error si la
     *         palabra no esta registrada.
     */
    public String translate(String word)
    {
        String translation = "Palabra No Registrada";

        try
        {
            String line = fileReader.readLine();
            while(line != null)
            {
                String[] tupla = line.split("#");

                if (tupla[0].equals(word.toUpperCase()))
                {
                    translation = tupla[1];
                    break;
                }

                line = fileReader.readLine();
            }

        }
        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(
                null,
                "Error al leer la base de datos de palabras",
                "Error Base Datos Traduccion",
                JOptionPane.ERROR_MESSAGE);
            ioe.printStackTrace();
        }
        finally
        {
            try
            {
                fileReader.close();
            }
            catch (IOException ioe)
            {
                JOptionPane.showMessageDialog(
                    null,
                    "Error al cerrar la base de datos de palabras",
                    "Error Base Datos Traduccion",
                    JOptionPane.ERROR_MESSAGE);
                ioe.printStackTrace();
            }
        }

        return translation;
    }
}

package historial;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HistorialLogger {
    private static Logger log = Logger.getLogger("HistorialLogger");

    static{
        try {
            FileHandler fileHandler=new FileHandler("historial.log",true);

            fileHandler.setFormatter(new SimpleFormatter());

            log.addHandler(fileHandler);
            log.setUseParentHandlers(false);
            log.setLevel(Level.INFO);

        } catch (IOException ex) {
            System.out.println("Error al crear el archivo de historial"+ex.getMessage());
        }
    }

    public static void agg(String user, String accion) {
        log.info(user+" "+accion);
    }
}

package com.eurystic.Services;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class InputParameters {

    public static LinkedHashMap<String, String[]> descripcionEscenarios = new LinkedHashMap<>();

    public static Date fechaInicioProduccion;

    public static HashMap<String, String[]> readEscenarios() throws IOException {
        File basefolder = new File(System.getProperty("user.dir") + "/Escenarios");
        String[] files = basefolder.list();

        ArrayList<String> excelFiles = new ArrayList<>();
        for (String file : files) {
            if (file.endsWith(".xlsm")){
                excelFiles.add(file);
            }
        }

        for (String excelFile : excelFiles) {
            String escenario = excelFile.substring(0, excelFile.length()-5);

            File file = new File(basefolder.getAbsolutePath() + "/" + excelFile);
            //TODO illegal reflective access cuando leo el archivo con el apache
            Workbook workbook = new XSSFWorkbook(new FileInputStream(file));

            String descripcion = workbook.getSheet("Resumen").getRow(3).getCell(12).getStringCellValue();
            descripcion = insertNewLine(descripcion,34);

            Date fechaInicioProduccionLocal = workbook.getSheet("Parámetros").getRow(5).getCell(1).getDateCellValue();
            String fechaInicioProduccionLocalString = printDate(fechaInicioProduccionLocal);

            descripcionEscenarios.put(escenario, new String[]{descripcion, file.getPath(), fechaInicioProduccionLocalString});

            if (fechaInicioProduccion == null) {
                fechaInicioProduccion = fechaInicioProduccionLocal;
            }

        }
        return descripcionEscenarios;
    }

    public static String printDate(Date fechaInicioProduccionLocal){
        Calendar fechaInicioProduccionCalendar = Calendar.getInstance();
        fechaInicioProduccionCalendar.setTime(fechaInicioProduccionLocal);
        String dia = Integer.toString(fechaInicioProduccionCalendar.get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(fechaInicioProduccionCalendar.get(Calendar.MONTH) + 1);
        String año = Integer.toString(fechaInicioProduccionCalendar.get(Calendar.YEAR));
        return dia + "/" + mes + "/" + año;
    }

    private static String insertNewLine(String descripcion, int lineLength) {
        int lines = (int)Math.ceil(descripcion.length()/lineLength);
        for (int line = 1; line <= lines; line++) {
            if (descripcion.charAt(line*lineLength) == ' '){
                int enterNewLineAt = line*lineLength;
                descripcion = descripcion.substring(0,enterNewLineAt) + "\n" + descripcion.substring(enterNewLineAt);
            } else {
                int enterNewLineAt = line*lineLength;
                while (descripcion.charAt(enterNewLineAt) != ' '){
                    enterNewLineAt--;
                }
                descripcion = descripcion.substring(0,enterNewLineAt + 1) + "\n" + descripcion.substring(enterNewLineAt + 1);
            }
        }
        return descripcion;
    }
}

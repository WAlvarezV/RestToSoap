/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import static java.time.temporal.ChronoUnit.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author william.alvarez
 */
public class Functions {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date fechaActual = new Date();
    String sfa = format.format(fechaActual);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    public String getEdad(String fn) {
        ChronoLocalDate from = ChronoLocalDate.from(formatter.parse(fn));
        ChronoLocalDate to = ChronoLocalDate.from(formatter.parse(sfa));
        ChronoPeriod period = ChronoPeriod.between(from, to);
        String r = String.format("%d años, %d meses y %d días", period.get(YEARS), period.get(MONTHS), period.get(DAYS));
        System.out.printf("%d años, %d meses y %d días", period.get(YEARS), period.get(MONTHS), period.get(DAYS));
        return r;
    }

    public String getTiempoVinculacion(String fv) {
        ChronoLocalDate from = ChronoLocalDate.from(formatter.parse(fv));
        ChronoLocalDate to = ChronoLocalDate.from(formatter.parse(sfa));
        ChronoPeriod period = ChronoPeriod.between(from, to);
        String r = String.format("%d años, %d meses y %d días", period.get(YEARS), period.get(MONTHS), period.get(DAYS));
        System.out.printf("%d años, %d meses y %d días", period.get(YEARS), period.get(MONTHS), period.get(DAYS));
        return r;
    }

    public boolean esMayor(String fn) {
        ChronoLocalDate from = ChronoLocalDate.from(formatter.parse(fn));
        ChronoLocalDate to = ChronoLocalDate.from(formatter.parse(sfa));
        ChronoPeriod period = ChronoPeriod.between(from, to);
        return period.get(YEARS) >= 18;
    }

    public String strOracleFormat(String f) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        return ft.format(format.parse(f));
    }
}

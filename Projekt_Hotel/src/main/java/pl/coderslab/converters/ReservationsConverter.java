package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.ReservationsDao;

import java.time.LocalDate;
import java.util.Date;

public class ReservationsConverter implements Converter<String, LocalDate> {
    @Autowired
    private ReservationsDao reservationsDao;
    @Override
    public LocalDate convert(String source) {
        LocalDate date = LocalDate.parse(source);
        System.out.println(date);
        return  date;
    }
}
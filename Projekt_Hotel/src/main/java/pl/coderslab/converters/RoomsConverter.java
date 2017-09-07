package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.dao.RoomsDao;
import pl.coderslab.entity.Rooms;

public class RoomsConverter implements Converter<String, Rooms> {
    @Autowired
    private RoomsDao personGroupDao;
    @Override
    public Rooms convert(String source) {
        Rooms group = personGroupDao.findById(Integer.parseInt(source));
        return  group;
    }
}
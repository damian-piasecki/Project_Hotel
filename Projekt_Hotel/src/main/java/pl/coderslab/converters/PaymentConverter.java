package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.dao.PaymentDao;
import pl.coderslab.entity.Payment;
import pl.coderslab.entity.Rooms;

public class PaymentConverter implements Converter<String, Payment> {
    @Autowired
    private PaymentDao paymentDao;
    @Override
    public Payment convert(String source) {
        Payment payment = paymentDao.findById(Integer.parseInt(source));
        return  payment;
    }
}
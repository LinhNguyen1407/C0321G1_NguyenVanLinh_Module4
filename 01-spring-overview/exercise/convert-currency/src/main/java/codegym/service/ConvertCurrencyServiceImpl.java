package codegym.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertCurrencyServiceImpl implements ConvertCurrencyService {
    @Override
    public Float convert(Float rate, Float usd) {
        return rate*usd;
    }
}

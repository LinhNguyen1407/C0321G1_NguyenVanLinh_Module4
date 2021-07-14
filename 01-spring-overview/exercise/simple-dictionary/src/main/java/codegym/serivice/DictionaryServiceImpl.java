package codegym.serivice;

import codegym.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    DictionaryRepository repository;

    @Override
    public String find(String word) {
        return repository.find(word);
    }
}

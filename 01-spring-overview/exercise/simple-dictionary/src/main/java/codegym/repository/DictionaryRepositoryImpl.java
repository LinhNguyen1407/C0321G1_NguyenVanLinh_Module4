package codegym.repository;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryRepositoryImpl implements DictionaryRepository {

    private static Map<String, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
    }


    @Override
    public String find(String word) {
        String result = dictionary.get(word);
        if (result != null) {
            return result;
        } else {
            return "Not found";
        }
    }
}

import java.util.*;

public class ResponseValidator {

    public void validate(Round round) {
        char expectedLetter = round.getLetter();

        Map<Category, Map<String, Integer>> respostasPorCategoria = new HashMap<>();

        for (Category category : Category.values()) {
            respostasPorCategoria.put(category, new HashMap<>());
        }

        for (List<Response> respostas : round.getResponses().values()) {
            for (Response r : respostas) {
                if(r.getAnswer().toUpperCase().charAt(0) == Character.toUpperCase(expectedLetter)) {
                    r.setValid(true);
                    Map<String, Integer> map = respostasPorCategoria.get(r.getCategory());
                    String key = r.getAnswer().toLowerCase();
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
        }

        // Se a resposta for duplicada ai vale = 5
        for (List<Response> respostas : round.getResponses().values()) {
            for (Response r : respostas) {
                if (r.isValid()) {
                    int count = respostasPorCategoria.get(r.getCategory()).get(r.getAnswer().toLowerCase());
                    if (count > 1) {
                        r.setValid(true);
                    }
                }
            }
        }
    }
}

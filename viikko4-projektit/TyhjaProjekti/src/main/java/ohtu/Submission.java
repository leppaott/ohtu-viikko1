package ohtu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Submission {
    private Map<String, Object> map;

    public Submission(Map<String, Object> map) {
        this.map = map;
    }

    public char getWeek() {
        return map.get("week").toString().charAt(0);
    }

    public int getTaskCount() {
        List<String> tasks = Arrays.asList("a1", "a2", "a3", "a4",
                "a5", "a6", "a7", "a8", "a9", "a10", "a11", "a12", "a13", "a14", "a15");
        return tasks.stream().mapToInt(t -> map.get(t) != null ? 1 : 0).sum();

    }

    public int getHours() {
        return (int) Double.parseDouble(map.get("hours").toString());
    }

    public String getTaskList() {
        List<String> tasks = Arrays.asList("a1", "a2", "a3", "a4",
                "a5", "a6", "a7", "a8", "a9", "a10", "a11", "a12", "a13", "a14", "a15");
        return tasks.stream().map(s -> {
            if (map.get(s) != null) {
                return s.substring(1);
            } else {
                return "";
            }
        }).filter(s -> s.length()>0).collect(Collectors.joining(", "));
    }
}

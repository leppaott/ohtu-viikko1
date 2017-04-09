package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.client.fluent.Request;

public class Main {

    private static Map<String, Object> cheat;

    public static String getMax(String week) {
        return cheat.get(week).toString();
    }

    public static void main(String[] args) throws IOException {
        String studentNr = "034343434";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Map<String, Object>[] map = new HashMap[0];
        map = mapper.fromJson(bodyText, map.getClass());

        List<Submission> subs = new ArrayList<>();
        for (Map<String, Object> m : map) {
            subs.add(new Submission(m));
        }

        String courseInfo = Request.Get("https://ohtustats2017.herokuapp.com/courses/1.json")
                .execute().returnContent().asString();
        Map<String, Object> mm = new HashMap<>();
        mm = mapper.fromJson(courseInfo, mm.getClass());
        cheat = mm;

        System.out.println("Kurssi: " + mm.get("name").toString()
                + ", " + mm.get("term").toString());

        System.out.println("\nopiskelijanumero: " + studentNr + "\n");
        subs.forEach(s -> {
            System.out.println("  viikko " + s.getWeek() + ": "
                    + "tehtyjä tehtäviä yhteensä: " + s.getTaskCount()
                    + " (maksimi "
                    + getMax("week" + s.getWeek())
                    + ")"
                    + " aikaa kului " + s.getHours() + " tuntia"
                    + ", tehdyt tehtävät: " + s.getTaskList());
        });

        System.out.println("\nyhteensä: "
                + subs.stream().mapToInt(s -> s.getTaskCount()).sum()
                + " tehtävää "
                + subs.stream().mapToInt(s -> s.getHours()).sum()
                + " tuntia");
    }
}

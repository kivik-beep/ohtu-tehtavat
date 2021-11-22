package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        List<Player> ps = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            if (players[i].getNationality().equals("FIN")) {
                ps.add(players[i]);
            }
        }
        Collections.sort(ps);

        System.out.println("Oliot:");
        for (Player player : ps) {
            System.out.println(player);
        }
    }

}

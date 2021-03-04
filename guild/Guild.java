package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(r -> r.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {

            if (player.getName().equals(name)) {
                player.setDescription("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {

        Player[] players = this.roster.stream()
                .filter(p -> p.getClazz().equals(clazz))
                .toArray(Player[]::new);

        for (Player player : players) {
            this.roster.removeIf(p -> p.getName().equals(player.getName()));
        }

        return players;
    }


    public int count() {
        return this.roster.size();

    }

    public String report() {
        StringBuilder out = new StringBuilder();

        out.append(String.format("Players in the guild: %s:", this.name));
        out.append(System.lineSeparator());

        for (Player player : roster) {

            out.append(player.toString()).append(System.lineSeparator());

        }
        return out.toString().trim();
    }
}

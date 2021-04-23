package sample;

import java.util.List;

public class Champion {
    public enum Origins {
        CULTIST,DIVINE,ELDERWOOD,ENLIGHTENED,EXILE,FORTUNE,NINJA,BOSS,WARLORD
    }
    public enum Classes {
        ADEPT,ASSASSIN,BRAWLER,DUELIST,EMPEROR,KEEPER,MAGE,MYSTIC,SHARPSHOOTER,VANGUARD
    }
    private String name;
    private List<Origins> origins;
    private List<Classes> classes;
    private List<String> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addOrigin(Origins origin) {
        origins.add(origin);
    }

    public void addClass(Classes classs) {
        classes.add(classs);
    }

    public void addItem(String item) {
        items.add(item);
    }
}
package sample;

import java.util.ArrayList;
import java.util.List;

public class Champion {
    public enum Origins {
        CULTIST,DIVINE,ELDERWOOD,ENLIGHTENED,EXILE,FORTUNE,NINJA,BOSS,WARLORD,SPIRIT,FABLED,DRAGONSOUL,DAREDEVIL
    }
    public enum Classes {
        ADEPT,ASSASSIN,BRAWLER,DUELIST,EMPEROR,KEEPER,MAGE,MYSTIC,SHARPSHOOTER,VANGUARD,SYPHONER,SLAYER,EXECUTIONER,BLACKSMITH
    }
    private String name;
    private List<Origins> origins = new ArrayList<>();
    private List<Classes> classes = new ArrayList<>();
    private List<String> items = new ArrayList<>();

    public Champion(String name) {
        this.name = name;
    }

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

    public List<Origins> getOrigins() {
        return origins;
    }

    public void setOrigins(List<Origins> origins) {
        this.origins = origins;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
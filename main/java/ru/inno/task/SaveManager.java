package ru.inno.task;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SaveManager {

    Map<Date, List<Save>> map;
    void loadTo (Date date){
        for (Save s:map.get(date)) s.load();
    }
}

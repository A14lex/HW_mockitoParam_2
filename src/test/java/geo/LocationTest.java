package geo;

import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class LocationTest {
    public Location locLocalHost = new Location(null, null, null, 0);
    public Location locLocalMoscow = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
    public Location locLocalNEW_YORK = new Location("New York", Country.USA, " 10th Avenue", 32);
    public Location locLocalRussia = new Location("Moscow", Country.RUSSIA, null, 0);
    public Location locLocalEnglish = new Location("New York", Country.USA, null, 0);
    public int hashLocalHost = locLocalHost.hashCode();
    public int hashLocalMoscow = locLocalMoscow.hashCode();
    public int hashLocalNEW_YORK = locLocalNEW_YORK.hashCode();
    public int hashLocalRussia = locLocalRussia.hashCode();
    public int hashLocalEnglish = locLocalEnglish.hashCode();
}

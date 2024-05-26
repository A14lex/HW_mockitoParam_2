package geo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertAll;

public class GeoServiceTest<assertEquals> {
        /*
    public Location locLocalHost = new Location(null, null, null, 0);
    public Location locLocalMoscow = new Location("Moscow",     Country.RUSSIA, "Lenina", 15);
    public Location locLocalNEW_YORK = new Location("New York", Country.USA,    " 10th Avenue", 32);
    public Location locLocalRussia = new Location("Moscow",     Country.RUSSIA,    null, 0);
    public Location locLocalEnglish = new Location("New York",  Country.USA,        null, 0);



     */


    @ParameterizedTest
    @CsvSource(value = {"127.0.0.1,     null,       null,   null,       0",
                        "172.0.32.11,   Moscow,     RUSSIA, Lenina,     15",
                        "96.44.183.149, 'New York', USA,    10th Avenue,32",
                        "172.111.111.111,Moscow,    RUSSIA, null,       0",
                        "96.111.111.111,'New York', USA,    null,       0"})

//    @CsvSource(value = {"127.0.0.1, null",
//            "172.0.32.11, Moscow",
//            "96.44.183.149, 'New York'",
//            "172.111.111.111, Moscow",
//            "96.111.111.111, 'New York'"
//    })
    void testLocation(String ipRes, String city, String country, String street, int building) {
//    void testLocation(String ipRes, String city){
        GeoService geoService = new GeoServiceImpl();
        Location locationExpected = geoService.byIp(ipRes);


//        LocalizationService localizationService = new LocalizationServiceImpl();
        if (city == "null") {
            city = null;
        }
        if (street == "null") {
            street = null;
        }
        if (country == "null") {
            country = null;
            Location locationOriginal = new Location(city, null, street, building);
        }else{
            Location locationOriginal = new Location(city, Country.valueOf(country), street, building);
        }



//        if (city.equals(location.getCity()) && (Country.valueOf(country)).equals(location.getCountry()) && street.equals(location.getStreet()) && building == location.getBuiling()) {
//
//        }


//        String cityRes = location.getCity();
//        Assertions.assertEquals(locationExpected, locationOriginal);
        boolean b = true;
//        Assertions.assertTrue(b);

//        Assertions.assertEquals("A", "A");
//        Assertions.assertEquals("C", "C");

    }


}

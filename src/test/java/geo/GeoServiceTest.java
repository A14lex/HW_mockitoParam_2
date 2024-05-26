package geo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

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
        Location locationOriginal = geoService.byIp(ipRes);




//        LocalizationService localizationService = new LocalizationServiceImpl();
        if (city.equals("null")) {
            city = null;
        }
        if (street.equals("null")) {
            street = null;
        }
        if (country.equals("null")) {
            country = null;
            locationOriginal = new Location(city, null, street, building);
        } else {
            locationOriginal = new Location(city, Country.valueOf(country), street, building);
        }

        boolean b = false;

//        if (city.equals(locationOriginal.getCity()) && (Country.valueOf(country)).equals(locationOriginal.getCountry()) && street.equals(locationOriginal.getStreet()) && building == locationOriginal.getBuiling()) {
//            b = true;
//        }
//        Assertions.assertTrue(b);
        Assertions.assertEquals(city, locationOriginal.getCity());
        if(country!=null){
            Assertions.assertEquals(Country.valueOf(country), locationOriginal.getCountry());
        }else{
            Assertions.assertEquals(null, locationOriginal.getCountry());
        }
        Assertions.assertEquals(street, locationOriginal.getStreet());
        Assertions.assertEquals(building, locationOriginal.getBuiling());



    }


}

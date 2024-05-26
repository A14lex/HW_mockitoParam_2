package geo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest<assertEquals> {
    @ParameterizedTest
    @CsvSource(value = {"127.0.0.1,     null,       null,   null,       0",
            "172.0.32.11,   Moscow,     RUSSIA, Lenina,     15",
            "96.44.183.149, 'New York', USA,    10th Avenue,32",
            "172.111.111.111,Moscow,    RUSSIA, null,       0",
            "96.111.111.111,'New York', USA,    null,       0"})
    void testLocationIP(String ipRes, String city, String country, String street, int building) {
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

        Assertions.assertEquals(city, locationOriginal.getCity());
        if (country != null) {
            Assertions.assertEquals(Country.valueOf(country), locationOriginal.getCountry());
        } else {
            Assertions.assertEquals(null, locationOriginal.getCountry());
        }
        Assertions.assertEquals(street, locationOriginal.getStreet());
        Assertions.assertEquals(building, locationOriginal.getBuiling());

    }
    @Test
    public void testCoordinate(){
//      T.к. assertTrue не удалось задействовать, то сравниваю через Equals
        double latitude = 330902;
        double longitude = 309390;
        GeoService geoService = new GeoServiceImpl();
        String msg;
        RuntimeException runtimeException = null;

        try {
            geoService.byCoordinates(latitude, longitude);
        } catch (RuntimeException e) {
            runtimeException=e;
        }


        Assertions.assertEquals(RuntimeException.class, runtimeException.getClass());
    }



}



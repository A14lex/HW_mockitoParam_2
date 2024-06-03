package geo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeoServiceTest<assertEquals> {
    @ParameterizedTest
    @CsvSource(value = {"127.0.0.1,,,,       0",
            "172.0.32.11,   Moscow,     RUSSIA, Lenina,     15",
            "96.44.183.149, 'New York', USA,   ' 10th Avenue',32",
            "172.111.111.111,Moscow,    RUSSIA,,       0",
            "96.111.111.111,'New York', USA,,       0"})
    void testLocationIP(String ipRes, String city, Country country, String street, int building) {

        GeoService geoService = new GeoServiceImpl();
        Location locationOriginal = geoService.byIp(ipRes);
        Assertions.assertEquals(city, locationOriginal.getCity());
        Assertions.assertEquals(country, locationOriginal.getCountry());
        Assertions.assertEquals(street, locationOriginal.getStreet());
        Assertions.assertEquals(building, locationOriginal.getBuiling());


    }
    @Test
    public void testCoordinate() throws RuntimeException {

        double latitude = 330902;
        double longitude = 309390;
        GeoService geoService = new GeoServiceImpl();
        String msg;
        Throwable  runtimeException = null;

        runtimeException = assertThrows(
                Throwable.class,
                () -> {
                    geoService.byCoordinates(latitude, longitude);
                }
        );
        Assertions.assertEquals(RuntimeException.class, runtimeException.getClass());


    }



}



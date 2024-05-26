package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

public class MessageSenderImplTest {
    @ParameterizedTest
    @CsvSource(value = {"172.0.32.11, 'Добро пожаловать'", "127.0.0.1, Welcome", "96.10.32.11, Welcome"})
    public void parameterMessage(String ip, String msg){
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.10.32.11")).thenReturn(new Location("New York", Country.USA, null,  0));
        Mockito.when(geoService.byIp("172.33.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        Mockito.when(geoService.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Mockito.when(geoService.byIp("127.0.0.1")).thenReturn(new Location(null, null, null, 0));

        LocalizationService lsi = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(lsi.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        Mockito.when(lsi.locale(Country.GERMANY)).thenReturn("Welcome");
        Mockito.when(lsi.locale(Country.USA)).thenReturn("Welcome");
        Mockito.when(lsi.locale(Country.BRAZIL)).thenReturn("Welcome");
        Mockito.when(lsi.locale(null)).thenReturn("Welcome");


        MessageSender messageSender = new MessageSenderImpl(geoService, lsi);
        Map<String, String> header = new HashMap<>();
        header.put(IP_ADDRESS_HEADER, ip);

        String result = messageSender.send(header);

        Assertions.assertEquals(result, msg);

    }
}

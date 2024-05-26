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
    @CsvSource(value = {"172.202.203.200, 'Добро пожаловать'", "96.202.203.200, Welkome"})
    public void parameterMessage(String ip, String msg){
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(Mockito.any(String.class))).thenReturn(Mockito.any(Location.class));

        LocalizationService lsi = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(lsi.locale(Mockito.any(Country.class))).thenReturn(msg);


        MessageSender messageSender = new MessageSenderImpl(geoService, lsi);
        Map<String, String> header = new HashMap<>();
        header.put(IP_ADDRESS_HEADER, ip);

        String result = messageSender.send(header);

        Assertions.assertEquals(result, msg);

    }
}

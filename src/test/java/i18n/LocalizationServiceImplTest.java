package i18n;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;


public class LocalizationServiceImplTest {
    //Сделал 26.05.24, работает.
    @ParameterizedTest
    @CsvSource(value = {"BRAZIL, Welcome", "GERMANY, Welcome","USA, Welcome","RUSSIA, 'Добро пожаловать'"})
    public void testLocale(String country, String msg){
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();


        String msgOriginal = localizationService.locale(Country.valueOf(country));

        Assertions.assertEquals(msgOriginal, msg);

    }



}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/CashbackData.csv", numLinesToSkip = 1)
    void shouldCalculateCashback(int amount, int expected, String message) {
        CashbackHackService service = new CashbackHackService();
        int actual = CashbackHackService.remain(amount);
        assertEquals(expected, actual, message);
    }


    @Test
    void shouldGiveMassageIfAmountLessThanZero(){
        CashbackHackService service = new CashbackHackService();
        int amount = -10;
        assertThrows(IllegalArgumentException.class, ()-> service.remain(amount) );
    }


//    @Test
//    void shouldReturnTrueIfAmountls2900() {
//        CashbackHackService service = new CashbackHackService();
//        int amount = 2900;
//
//        int actual = service.remain(amount);
//        int expected = 100;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void shouldReturnFalseIfAmountls1000() {
//        CashbackHackService service = new CashbackHackService();
//        int amount = 1000;
//
//        int actual = service.remain(amount);
//        int expected = 0;
//
//        assertEquals(expected, actual);
//    }
}
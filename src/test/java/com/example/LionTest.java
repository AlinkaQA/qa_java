package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LionTest {

    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        feline = mock(Feline.class);
        lion = new Lion("Самец", feline);
    }

    @Test(expected = Exception.class)
    public void createLionTestThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Неизвестно", feline);
    }

    @Test
    public void getKittensTestReturnsExpectedValue() {
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodTestReturnsExpectedList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void doesHaveManeTestReturnsTrueForMale() throws Exception {
        Lion maleLion = new Lion("Самец", feline);
        assertEquals(true, maleLion.doesHaveMane());
    }

    @Test
    public void doesHaveManeTestReturnsFalseForFemale() throws Exception {
        Lion femaleLion = new Lion("Самка", feline);
        assertEquals(false, femaleLion.doesHaveMane());
    }
}

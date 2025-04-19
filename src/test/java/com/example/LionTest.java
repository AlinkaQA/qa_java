package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LionTest {

    private Predator predator;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        predator = mock(Predator.class);
        when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        lion = new Lion("Самец", predator);
    }

    @Test(expected = Exception.class)
    public void createLionThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Неизвестно", predator);
    }

    @Test
    public void getKittensReturnsExpectedValue() {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(1);
        try {
            Lion lionWithFeline = new Lion("Самец", feline);
            assertEquals(1, lionWithFeline.getKittens());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doesHaveManeReturnsTrueForMale() throws Exception {
        Lion maleLion = new Lion("Самец", predator);
        assertEquals(true, maleLion.doesHaveMane());
    }

    @Test
    public void doesHaveManeReturnsFalseForFemale() throws Exception {
        Lion femaleLion = new Lion("Самка", predator);
        assertEquals(false, femaleLion.doesHaveMane());
    }

    @Test
    public void getFoodReturnsExpectedList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood());
    }
}

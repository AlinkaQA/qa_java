package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void getFamilyTest() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals("Метод getFamily() возвращает неверную строку", expected, animal.getFamily());
    }

    @Test(expected = Exception.class)
    public void getFoodTestThrowsExceptionWhenTypeIsUnknown() throws Exception {
        animal.getFood("Неизвестный");
    }
}
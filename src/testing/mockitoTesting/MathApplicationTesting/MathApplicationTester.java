package testing.mockitoTesting.MathApplicationTesting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    private CalculatorService calcService;

    @Test
    public void testAdd(){

        when(calcService.add(10.0,20.0)).thenReturn(30.0);

        Assert.assertEquals(mathApplication.add(10.0,20.0),30.0,0);

        verify(calcService).add(10.0,20.0);
    }

    @Test
    public void testSubtract(){

        when(calcService.subtract(10.0,20.0)).thenReturn(-10.0);

        Assert.assertEquals(mathApplication.subtract(10.0,20.0),-10.0,0);

        verify(calcService).subtract(10.0,20.0);
    }


    @Test
    public void testMultiply(){

        when(calcService.multiply(10.0,20.0)).thenReturn(200.0);

        Assert.assertEquals(mathApplication.multiply(10.0,20.0),200.0,0);

        verify(calcService).multiply(10.0,20.0);
    }

    @Test
    public void testDivide(){

        when(calcService.divide(20.0,10.0)).thenReturn(2.0);

        Assert.assertEquals(mathApplication.divide(20.0,10.0),2.0,0);
        Assert.assertEquals(mathApplication.divide(20.0,10.0),2.0,0);

        verify(calcService,atLeast(1)).divide(20.0,10.0);
        verify(calcService,times(2)).divide(20.0,10.0);
        verify(calcService,atMost(2)).divide(20.0,10.0);
        verify(calcService,atLeastOnce()).divide(20.0,10.0);
        verify(calcService,never()).multiply(20.0,10.0);
    }

}

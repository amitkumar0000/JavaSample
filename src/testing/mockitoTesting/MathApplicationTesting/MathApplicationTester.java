package testing.mockitoTesting.MathApplicationTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.BDDMockito.given;
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

    /*@Before
    public void setup(){
        Calculator calculator = new Calculator();
        calcService = spy(calculator);
        mathApplication.setCalculatorService(calcService);

    }*/

    @Test
    public void testAdd1(){

        //Given
        given(calcService.add(20.0,10.0)).willReturn(30.0);

        //when
        double result = calcService.add(20.0,10.0);

        //then
        Assert.assertEquals(result,30.0,0);

        //verify call to add method to be completed within 100 ms
        verify(calcService, timeout(1)).add(20.0,10.0);
    }

    @Test
    public void testAdd(){

        when(calcService.add(10.0,20.0)).thenReturn(30.0);

        Assert.assertEquals(mathApplication.add(10.0,20.0),30.0,0);

        verify(calcService).add(10.0,20.0);

        //reset the mock
        reset(calcService);

        //test the add functionality after resetting the mock
        Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);

        //add the behavior to throw exception
        doThrow(new RuntimeException("Add operation not implemented"))
                .when(calcService).add(10.0,20.0);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);


        //add the behavior to add numbers
        when(calcService.add(20.0,10.0)).thenAnswer(new Answer<Double>() {

            @Override
            public Double answer(InvocationOnMock invocation) throws Throwable {
                //get the arguments passed to mock
                Object[] args = invocation.getArguments();

                //get the mock
                Object mock = invocation.getMock();

                //return the result
                return 30.0;
            }
        });

        //test the add functionality
        Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);
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


        //add the behavior to throw exception
        doThrow(new RuntimeException(" Divide by Zero"))
                .when(calcService).divide(10.0,0.0);
        Assert.assertEquals(mathApplication.divide(20.0,10.0),2.0,0);

        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(calcService);

        //following will make sure that add is first called then subtract is called.
//        inOrder.verify(calcService).add(20.0,10.0);
    }



    class Calculator implements CalculatorService {
        @Override
        public double add(double input1, double input2) {
            return input1 + input2;
        }

        @Override
        public double subtract(double input1, double input2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }

        @Override
        public double multiply(double input1, double input2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }

        @Override
        public double divide(double input1, double input2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }
    }

}

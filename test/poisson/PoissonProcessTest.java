package poisson;

import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class PoissonProcessTest {

  static final int SAMPLES = 10000;

  private void testEvents(double lambda) {
    PoissonProcess pp = new PoissonProcess(lambda, new Random(0) );
    SampleValues s = new SampleValues("Events / " + lambda);

    for (int i = 1; i <= SAMPLES; i++) {
      int e = pp.events();
      s.add(e);
    }
    // TODO: make choice of tol statistically sound (ad-hoc for now)
    double tol = lambda / 10;
    System.out.println(s);
    assertEquals("mean", lambda, s.mean(), tol);
    assertEquals("variance", lambda, s.variance(), tol);

  }
  
  @Test
  public void testEvents_0_01() {
    testEvents(0.01);
  }
  
  @Test
  public void testEvents_0_1() {
    testEvents(0.1);
  }
  
  @Test
  public void testEvents_1_0() {
    testEvents(1.0);
  }
  
  @Test
  public void testEvents_2_5() {
    testEvents(2);
  }
  
  @Test
  public void testEvents_10_1() {
    testEvents(10.1);
  }
  
  @Test
  public void testEvents_100_33() {
    testEvents(100.33);
  }
  
  private void testArrivalTimes(double lambda) {
    PoissonProcess pp = new PoissonProcess(lambda, new Random(0) );
    SampleValues s = new SampleValues("Arrival Times / " + lambda);

    for (int i = 1; i <= SAMPLES; i++) {
      double t = pp.timeForNextEvent();
      s.add(t);
    }

    double invLambda = 1d / lambda;
    // TODO: make choice of tol statistically sound (ad-hoc for now)
    double tol = Math.pow(10, -Math.log10(lambda)) / lambda; 
    System.out.println(s.toString() + " " + tol);
    assertEquals("mean", invLambda, s.mean(), tol);
    assertEquals("variance", invLambda / lambda, s.variance(), tol );
  }
  
  
  @Test
  public void testArrivalTimes_0_01() {
    testArrivalTimes(0.01);
  }
  
  @Test
  public void testArrivalTimes_0_1() {
    testArrivalTimes(0.1);
  }
  
  @Test
  public void testArrivalTimes_1_0() {
    testArrivalTimes(1.0);
  }
  
  @Test
  public void testArrivalTimes_2_5() {
    testArrivalTimes(2.5);
  }
  
  @Test
  public void testArrivalTimes_10_1() {
    testArrivalTimes(10.1);
  }
  
  @Test
  public void testArrivalTimes_100_33() {
    testArrivalTimes(100.33);
  }
}

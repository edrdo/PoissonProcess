package poisson;

public class Sample {

  private final String id;
  private int count;
  private double sum, sumSq, min, max;
  
  Sample(String statsId) {
    id = statsId;
    count = 0;
    sum = 0;
    sumSq = 0;
    min = Double.MAX_VALUE;
    max = Double.MIN_VALUE;

  }
  
  public void update(double v) {
    count++;
    sum += v;
    sumSq += (v * v);
    min = Math.min(v, min);
    max = Math.max(v, max);
  }
  
  public String id() {
    return id;
  }
  
  public double min() { 
    return min; 
  }
  
  public double max() { 
    return max; 
  }
  
  public int count() { 
    return count; 
  }
  
  public double average() { 
    return sum / count; 
  }
  
  public double stddev() { 
    return Math.sqrt(variance());
  }
   
  public double variance() { 
    double u = average();
    return u * u + (sumSq - 2 * u * sum)/count;
  }
  
  @Override
  public String toString() {
    return String.format("%s|count=%d|avg=%f|variance=%f|min=%f|max=%f",
                         id(), count(), average(), variance(), min(), max());
  }
  
  public void mergeWith(Sample other) {
    count += other.count;
    sum += other.sum;
    sumSq += other.sumSq;
    min = Math.min(min, other.min);
    max = Math.max(max, other.max);
  }
  
}

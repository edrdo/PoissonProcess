# Poisson process simulation

## Author

Eduardo R. B. Marques, 2017

## Description

Basic support for Poisson process simulation. 

The `PoissonProcess` class simulates a Poisson process in terms of
* number of events  (`events`)
* inter-arrival times (`timeForNextEvent`)

## Usage


    import poisson.PoissonProcess;
    ...
    Random rng = ... ; // base RNG to use
    double lambda = ... ; // rate parameter
    PoisonProcess pp = new PoissonProcess(lambda, rng);
    ...
    // Get number of events
    int events = pp.events(); // unit interval
    int delta = ... ;
    int eventsDelta = pp.events(delta); // delta-time interval

    // Get time for next event (inter-arrival time)
    double t = pp.timeForNextEvent();
     

# pbt-java8

I have become a big fan of property based testing (PBT) and the associated frameworks that are available.  However 
Java 6 has very limited support for property based testing primarily because:

- It does not have lambdas - this makes combining generators and creating code blocks a little cumbersome,
- It does not have collection classes - so performing operations over lists is typically done using loops rather than 
  using nifty functional constructs like map, fold (or reduce) and filter.

Over the past couple of months I have had a need to create PB tests on projects where the developers associated with
the project are not comfortable to adopt a new language such as Scala for the purposes of testing.  So I knocked 
together a library for Java 6 whilst performing the String Calculator Kata hoping to see what would pop out.  Much to
my surprise most of the effort went into creating the boilerplate code necessary to support PBT in Java 6 rather than
the tests themselves.  The Java 6 library became so useful I ported it to Java 8 - this is the result.

# The Concept

The scope of a traditional unit test is centered around cherry picking data to validate a specific scenario.  This works
 well to validate that the code under test is behaving as it is expected to.  The issue with this style of testing is that
 you only test scenarios that you can think of.  The philosophy behind PBT is to confirm that the invariant between a 
 component's input and output data is valid for a set of input data.
   
# An Example

The structure of a PBT is to describe the inputs to the test using one or more generators and then to validate that, 
 given the input the results are as expected.
 
Using the [String Calculator](http://osherove.com/tdd-kata-1/) as a backdrop let's look at a number of scenarios.

## Given an integer should return its value

```java
	import za.co.no9.pbt.Generator;
	import za.co.no9.pbt.IntegerGenerator;
	import static za.co.no9.pbt.Gen.forAll;

    @Test
    public void given_a_number_should_return_its_value() {
    	Generator<Integer> integers = IntegerGenerator.from(-2000, 2000);
    	
        forAll(integers, n ->
                assertEquals(normaliseInt(n), add(n.toString())));
    }
```

# Kotlin

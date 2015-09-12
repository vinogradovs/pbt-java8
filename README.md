# pbt-java8

I have become a big fan of property based testing (PBT) and the associated frameworks that are available.  However 
Java 6 has very limited support for property based testing primarily because:

- It does not have lambdas - this makes combining generators and creating code blocks a little cumbersome,
- It does not have collection classes - so performing operations over lists is typically done using loops rather than using nifty functional constructs like map, fold (or reduce) and filter.

Over the past couple of months I have had a need to create PB tests on projects where the developers associated with
the project are not comfortable to adopt a new language such as Scala for the purposes of testing.  So I knocked 
together a library for Java 6 whilst performing the String Calculator Kata hoping to see what would pop out.  Much to
my surprise most of the effort went into creating the boilerplate code necessary to support PBT in Java 6 rather than
the tests themselves.  The Java 6 library became so useful I ported it to Java 8 - this is the result.

Enjoy - the code really is simple.

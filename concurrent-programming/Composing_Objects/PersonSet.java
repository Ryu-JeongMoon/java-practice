package net.jcip.examples;

import java.util.HashSet;
import java.util.Set;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * PersonSet
 * <p/>
 * Using confinement to ensure thread safety
 *
 * @author Brian Goetz and Tim Peierls
 */

@ThreadSafe
public class PersonSet {

  @GuardedBy("this")
  private final Set<Person> mySet = new HashSet<>();

  public synchronized void addPerson(Person p) {
    mySet.add(p);
  }

  public synchronized boolean containsPerson(Person p) {
    return mySet.contains(p);
  }

  interface Person {

  }
}

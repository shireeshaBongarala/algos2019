package practice.dojo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import practice.dojo.HelloWorld;

class HelloWorldTest {

  @Test
  void shouldGreet(){

    assertEquals("Hello, Shireesha", new HelloWorld().greet("Shireesha"));
  }

}
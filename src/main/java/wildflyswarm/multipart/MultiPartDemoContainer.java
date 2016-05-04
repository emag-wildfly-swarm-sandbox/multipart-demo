package wildflyswarm.multipart;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.undertow.UndertowFraction;

public class MultiPartDemoContainer {

  public static Container newContainer() throws Exception {
    Container container = new Container();

    UndertowFraction undertowFraction = UndertowFraction.createDefaultFraction();
    undertowFraction.subresources()
        .server("default-server").subresources()
        .httpListener("default")
        .maxPostSize(1024L);

    container.fraction(undertowFraction);

    return container;
  }

}

package wildflyswarm.multipart;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

@RunWith(Arquillian.class)
public class MediaControllerIT {

  @Deployment(testable = false)
  public static JAXRSArchive createDeployment() throws Exception {
    return MultiPartDemoDeployment.createDeployment();
  }

  @Test
  public void doNothing() throws Exception {}

}

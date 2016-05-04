package wildflyswarm.multipart;

public class App {

  public static void main(String[] args) throws Exception {
    MultiPartDemoContainer.newContainer()
      .start()
      .deploy(MultiPartDemoDeployment.createDeployment());
  }

}

package wildflyswarm.multipart;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.joda.time.DateTime;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/media")
public class MediaController {

  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response upload(MultipartFormDataInput input) {
    Map<String, List<InputPart>> inputParts = input.getFormDataMap();
    InputPart file = inputParts.get("file").get(0);
    MultivaluedMap<String, String> headers = file.getHeaders();

    String fileName = getFileName(headers);

    String message = String.format("uploaded file name: %s at %s", fileName, new DateTime());
    
    return Response.status(200)
      .entity(message).build();
  }

  private String getFileName(MultivaluedMap<String, String> headers) {
    String[] contentDisposition = headers.getFirst("Content-Disposition").split(";");

    for (String filename : contentDisposition) {
      if ((filename.trim().startsWith("filename"))) {
        String[] name = filename.split("=");
        return name[1].trim().replaceAll("\"", "");
      }
    }

    return "unknown";
  }

}

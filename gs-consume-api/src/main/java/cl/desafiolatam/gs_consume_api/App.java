package cl.desafiolatam.gs_consume_api;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Client client = ClientBuilder.newClient();
       
        WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts");
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response respuestaPublicaciones = invocationBuilder.get();

        List<Publicacion> listaPublicaciones = respuestaPublicaciones.readEntity(new GenericType<List<Publicacion>>(){});
        System.out.println( listaPublicaciones.get(0));
        
        System.out.println(respuestaPublicaciones.getStatusInfo());
        System.out.println(respuestaPublicaciones.getStatus());
        
        listaPublicaciones.forEach(System.out::println);
    }
}

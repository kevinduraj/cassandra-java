package kduraj;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import static java.lang.System.out;

public class CassandraModel {

    private Cluster cluster;
    private Session session;
    private int counter=0;
    /*-------------------------------------------------------------------------------------------------------*/
    public void connect(final String node, final int port) {

        this.cluster = Cluster.builder().addContactPoint(node).withPort(port).build();
        final Metadata metadata = cluster.getMetadata();
        out.printf("Connected to cluster: %s\n", metadata.getClusterName());

        for (final Host host : metadata.getAllHosts()) {
            out.printf("DataCenter: %s; Host: %s; Rack: %s\n"
                    , host.getDatacenter(), host.getAddress(), host.getRack());
        }
        session = cluster.connect();
    }

    /*-------------------------------------------------------------------------------------------------------*/
    public void insertMovie(final String title
            , final int year
            , final String description
            , final String rating) {

        if((counter % 10000) == 0) {
            out.println(counter + " INSERT: title=" + title + " year=" + year + " description=" + description + " rating=" + rating);
        }
         
        session.execute(
                    "INSERT INTO keyspace2.movies (title, year, description, rating) "
                        + " VALUES (?, ?, ?, ?)",
                    title, year, description, rating);
        counter++;
    }
    /*-------------------------------------------------------------------------------------------------------*/
    public void deleteMovie(final String title, final int year) {

        out.println(" DELETE: title=" + title + " year=" + year );
        session.execute("DELETE FROM keyspace2.movies WHERE title = ? AND year = ?", title, year);
    }

    /*-------------------------------------------------------------------------------------------------------*/
    public Session getSession() {
        return this.session;
    }

    /*-------------------------------------------------------------------------------------------------------*/
    public void close()  {
        session.close();
        cluster.close();
    }
    /*-------------------------------------------------------------------------------------------------------*/
}

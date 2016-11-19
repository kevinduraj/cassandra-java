package kduraj;

import java.util.Random;

/*
 * http://www.datastax.com/documentation/cql/3.0/cql/cql_reference/drop_keyspace_r.html
 */
public class App {

    private static String ipAddress;
    private static int port;

    static Random r = new Random();
    final static int COUNT = 100;

    /*----------------------------------------------------------------------------------------*/
    public static void main(final String[] args) {

        ipAddress = args.length > 0 ? args[0] : "localhost";
        port = args.length > 1 ? Integer.parseInt(args[1]) : 9042;

        for(int i=0; i<101; i++) {
            testMultipleInserts();
        }
    }

    /*----------------------------------------------------------------------------------------*/
    private static void testMultipleInserts() {

        final CassandraModel client = new CassandraModel();
        client.connect(ipAddress, port);
        Random r = new Random();
        
        for(int i=0; i<900000; i++) {
            int R = r.nextInt(2015) + 1999;
            client.insertMovie(genString(10), R, genString(4), genString(4));
        }

        client.close();
    }
    /*----------------------------------------------------------------------------------------*/
    private static void testInserts() {

        final CassandraModel client = new CassandraModel();
        client.connect(ipAddress, port);
        client.insertMovie("kevin12", 1912, "Linux12", "PG12");
        client.insertMovie("kevin13", 1913, "Linux13", "PG13");
        client.deleteMovie("kevin13", 1913);
        client.close();
    }
    /*----------------------------------------------------------------------------------------*/
    public static String genString(int len) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append((char) (r.nextInt(24) + 'a'));
        }
        return sb.toString();
    }
    /*----------------------------------------------------------------------------------------*/
}

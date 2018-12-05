import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnections {


    //jdbc driver name and URL
    static final String JDBC_DRIVER="org.h2.Driver";
    static final String DB_URL="jdbc:h2:~/test";


    //credentials
    static final String USER = "sa";
    static final String PASS = "sa";

    static final String CreateRegistrationTbl =    " CREATE TABLE   REGISTRATION " +
                                                   "(id INTEGER not NULL, " +
                                                    " first VARCHAR(255), " +
                                                    " last VARCHAR(255), " +
                                                    " age INTEGER, " +
                                                    " PRIMARY KEY ( id ))";

    //H2 Local Connection
    public static void ToLocalH2Db(String sql)
    {
        //Queries = CreateRegistrationTbl;
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            //String sql = "";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");

    }

    public static void main(String[] args) {



        //LocalH2Db(CreateEmptbl);
        //LocalH2Db(CreateRandonTbl);

    }

}


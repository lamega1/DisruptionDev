public class MainContainer {

    public static void main(String[] args){

        String CreateCanubdaTbls =    " CREATE TABLE CamundaTbl " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))";



        dbConnections.ToLocalH2Db(CreateCanubdaTbls);

    }
}

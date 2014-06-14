package ga.thesis.hibernate.util;

/**
 * Created by sky_lady on 6/14/14.
 */
public class DBReaderWriter {

    // public static Boolean sendData(String username, String password)
    // throws IllegalArgumentException {
    // Connection conn = DBconnection.getConn();
    //
    // String query = "INSERT INTO users (username,password) " + "VALUES ('"
    // + username + "','" + password + "')";
    //
    // try {
    // Statement insert = conn.createStatement();
    // insert.executeUpdate(query);
    //
    // insert.close();
    //
    // conn.close();
    // } catch (SQLException e) {
    // System.err.println("Mysql Statement Error: " + query);
    // e.printStackTrace();
    // return false;
    //
    // }
    // return true;
    // }

//    public static Boolean validateUserdb(User user) {
//
//        try {
//            List<User> users = Factory.getInstance().getUserDAO().getAllUsers();
//            for (User u: users) {
//                if (user.getUsername().equalsIgnoreCase(
//                        u.getUsername())
//                        && !user.getPassword().equalsIgnoreCase(
//                        u.getPassword())) {
//                    return true;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public static Boolean findUserdb(User user) {
//        try {
//            List<User> users = Factory.getInstance().getUserDAO().getAllUsers();
//            for (User u: users) {
//                if (user.getUsername().equalsIgnoreCase(
//                        u.getUsername())
//                        && user.getPassword().equalsIgnoreCase(
//                        u.getPassword())) {
//                    return true;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }

    // public static ArrayList<ArrayList<String>> getData(String query,
    // int numberOfArguments) throws IllegalArgumentException {
    // ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
    //
    // Connection conn = DBconnection.getConn();
    // try {
    // Statement select = conn.createStatement();
    // ResultSet result = select.executeQuery(query);
    // while (result.next()) {
    // ArrayList<String> tmp = new ArrayList<String>();
    // for (int i = 1; i <= numberOfArguments; i++) {
    // tmp.add(result.getObject(i).toString());
    //
    // }
    //
    // list.add(tmp);
    //
    // }
    // select.close();
    // result.close();
    // conn.close();
    // return list;
    // } catch (SQLException e) {
    // System.err.println("Mysql Statement Error: " + query);
    // e.printStackTrace();
    // return null;
    //
    // }
    // }

}

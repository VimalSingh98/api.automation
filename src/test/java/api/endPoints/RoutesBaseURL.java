package api.endPoints;

public class RoutesBaseURL {

    //https://petstore.swagger.io/v2/user

    public static String base_URL= "https://petstore.swagger.io/v2";

    public static String post_URL= base_URL+"/user";
    public static String get_URL= base_URL+"/user/{username}";
    public static String update_URL= base_URL+"/user/{username}";
    public static String delete_URL= base_URL+"/user/{username}";


}

package api.config;

public class ApiEndpoints {
    public static class User {
        public static final String BASE = "/user";

        public static String GetAll() {
            return BASE;
        }

        public static String GetById(String id) {
            return String.format("%s/%s", BASE, id);
        }

        public static String DeleteById(String id) {
            return GetById(id);
        }

        public static String CreateUser() {
            return BASE;
        }

        public static String UpdateById(String id) {
            return String.format("%s/%s", BASE, id);
        }
    }

}

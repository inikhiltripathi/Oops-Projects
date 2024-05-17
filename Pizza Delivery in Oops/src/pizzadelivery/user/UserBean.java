package pizzadelivery.user;

public class UserBean {

    private String name;
    private String mobile;
    private String email;
    private String password;

    private static UserBean obj;

    public static synchronized UserBean getObj(){
        if (obj == null) {
            obj = new UserBean();
        }
        return obj;
    }


    @Override
    public String toString() {
        return "UserBean [name=" + name + ", mobile=" + mobile + ", email=" + email + ", password=" + password + "]";
    }

    public UserBean() {
    }

    public UserBean(String name, String mobile, String email, String password) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

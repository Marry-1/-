public class Person {
    private String pname;
    private String telephone;
    private String address;
    private String postalCode; //邮政编码
    private String Email;
    private String homePhone; //家庭电话

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getPname() {
        return pname;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getEmail() {
        return Email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    @Override
    public String toString() {
        return "Person{" + "pname='" + pname + '\'' + ", telephone='" + telephone + '\'' + ", address='" + address + '\'' + ", postalCode='" + postalCode + '\'' + ", Email='" + Email + '\'' + ", homePhone='" + homePhone + '\'' + '}';
    }
}

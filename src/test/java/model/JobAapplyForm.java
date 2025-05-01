package model;

public class JobAapplyForm {
    private String firstName;
    private String lastName;
    private String phone;
    private String emailAddres;
    private String filePath;
    private String motivation;

    public JobAapplyForm(String firstName, String lastName, String phone, String emailAddres, String filePath, String motivation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.emailAddres = emailAddres;
        this.filePath = filePath;
        this.motivation = motivation;
    }

    public JobAapplyForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailAddres() {
        return emailAddres;
    }

    public void setEmailAddres(String emailAddres) {
        this.emailAddres = emailAddres;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }
}

package ERyder;
public class Feedback {
    private String firstName;
    private String lastName;
    private String email;

    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void analyseFeedback(boolean isConcatenation, String sent1, String sent2, String sent3, String sent4, String sent5) {
        if (isConcatenation) {
            completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
        } else {
            completeFeedback = feedbackUsingStringBuilder(sent1, sent2, sent3, sent4, sent5).toString();
        }

        checkFeedbackLength(completeFeedback);
        createReviewID();
    }

    private String feedbackUsingConcatenation(String s1, String s2, String s3, String s4, String s5) {
        return s1 + s2 + s3 + s4 + s5;
    }

    private StringBuilder feedbackUsingStringBuilder(String s1, String s2, String s3, String s4, String s5) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        sb.append(s3);
        sb.append(s4);
        sb.append(s5);
        return sb;
    }

    private boolean checkFeedbackLength(String feedback) {
        if (feedback.length() > 500) {
            longFeedback = true;
        } else {
            longFeedback = false;
        }
        return longFeedback;
    }

    private void createReviewID() {
        String namePart = (firstName + lastName).substring(2, 6).toUpperCase();
        String feedbackPart = completeFeedback.substring(10, 15).toLowerCase();
        String lengthStr = String.valueOf(completeFeedback.length());
        String timeStr = String.valueOf(System.currentTimeMillis());

        String tempID = namePart + feedbackPart + lengthStr + "_" + timeStr;
        reviewID = tempID.replace(" ", "");
    }

    @Override
    public String toString() {
        return "Feedback Info:" +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nEmail: " + email +
                "\nComplete Feedback: " + completeFeedback +
                "\nLong Feedback: " + longFeedback +
                "\nReview ID: " + reviewID;
    }

    public static void main(String[] args) {
        String sent1 = "I was very satisfied with the service.";
        String sent2 = "The e-Bike is quite comfortable to ride.";
        String sent3 = "The battery life of the e-Bike is impressive.";
        String sent4 = "The customer support was helpful and responsive.";
        String sent5 = "I would recommend this e-Bike to my friends and family.";

        Feedback feedback = new Feedback("Yichen", "You", "yichen@example.com");
        feedback.analyseFeedback(true, sent1, sent2, sent3, sent4, sent5);
        System.out.println(feedback);
    }
}

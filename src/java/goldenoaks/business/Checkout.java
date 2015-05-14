package goldenoaks.business;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement

public class Checkout implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private long checkoutNumber;
 
    private String firstName;
   
    private String lastName;
   
    private String emailAddress;
   
    private String bookTitle;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    
    public Checkout() {
        firstName = "";
        lastName = "";
        emailAddress = "";
        bookTitle = "";
        dueDate = new Date();
        
        // The following code sets a default due date 14 days in the future.
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dueDate);
        calendar.add(Calendar.DATE, 14);
        dueDate.setTime(calendar.getTime().getTime());
    }
    
    public long getCheckoutNumber() {
        return checkoutNumber;
    }

    public void setCheckoutNumber(long checkoutNumber) {
        this.checkoutNumber = checkoutNumber;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Date getDueDate() {
        return dueDate;
    }
    
    public boolean isOverdue() {
        return dueDate.before(new Date());
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    public String getFormattedDate() {
        return new SimpleDateFormat("MM-dd-yyyy").format(dueDate);
    }
    
}

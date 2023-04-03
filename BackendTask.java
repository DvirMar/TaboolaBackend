import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyClass {
    private Date m_time;
    private String m_name;
    private List<Long> m_numbers;
    private List<String> m_strings;

    public MyClass(Date time, String name, List<Long> numbers, List<String>
            strings) {
        m_time = time;
        m_name = name;
        m_numbers = numbers;
        m_strings = strings;
    }

    /*public boolean equals(Object obj) {
        if (obj instanceof MyClass) {
            return m_name.equals(((MyClass)obj).m_name);
        }
        return false;
    }
    */


    //I dont know if its a bug but this function only checks if the two objects(that are from Myclass class)
    // have the same name and its not checking the date, and the two lists of numbers and strings.
    //fixed :
    public boolean equals(Object obj) {
        if (obj instanceof MyClass) {
            MyClass newObj = (MyClass) obj;
            //added a condition that checks if the date,name and the two listd are equals
            if (m_name.equals(newObj.m_name) && m_time.equals(newObj.m_time) && m_numbers.equals(newObj.m_numbers) && m_strings.equals(newObj.m_strings))
                return true;
            else
                return false;
        }
        return false;
    }


    /*
    public String toString() {
        String out = m_name;
        for (long item : m_numbers) {
            out += " " + item;
        }
        return out;

     */

    //I added the date and the strings list to the function
    //fixed:
    public String toString() {
        //i added the date toString here
        String out = m_time.toString() + "" + m_name;
        for (long item : m_numbers) {
            out += " " + item;
        }
        //added the strings list here
        for (String item : m_strings) {
            out += " " + item;
        }
        return out;
    }



    /*public void removeString(String str) {
        for (int i = 0; i < m_strings.size(); i++) {
            if (m_strings.get(i).equals(str)) {
                m_strings.remove(i);
            }
        }
    }

     */

    //when we are iterating we shouldnt change the list when we do that. the list will chage and so does the indexes.
    //fixed:
    public void removeString(String str) {
        for (int i = 0; i < m_strings.size(); i++) {
            if (m_strings.get(i).equals(str)) {
                m_strings.remove(i);
                i--;
            }
        }
    }


    /*public boolean containsNumber(long number) {
        for (long num : m_numbers) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }
     */

    //iterating over the whole list will take a lot of time and resources and converting it to hashmap will be more efficient
    public boolean containsNumber(long number) {
        //creating the hashmap
        Set<Long> numberSet = new HashSet<>(m_numbers);
        //checking if contain the number
        return numberSet.contains(number);
    }

    /*public boolean isHistoric() {
        return m_time.before(new Date());
    }
     */

    //to make the function more flexible we should take a date and check if a date is older then the given date
    //fixed:
    public boolean isHistoric(Date givenDate) {

        return m_time.before(givenDate);
    }

}


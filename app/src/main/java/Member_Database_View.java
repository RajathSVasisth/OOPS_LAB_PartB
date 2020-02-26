import androidx.room.ColumnInfo;
import androidx.room.DatabaseView;
import androidx.room.PrimaryKey;

import com.example.nitinpandit.aicte_activity.*;

public class Member_Database_View {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "Full Name")
    public String name;

    @ColumnInfo(name = "Gender")
    public String gender;

    @ColumnInfo(name="age")
    public int age;

    @ColumnInfo(name="Phone Number")
    public String phone_number;

    @ColumnInfo(name="Occupation")
    public String occupation;

    @ColumnInfo(name = "Cards Available")
    String cards;

}

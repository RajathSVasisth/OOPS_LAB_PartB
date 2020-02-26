import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Member_info_entity {
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

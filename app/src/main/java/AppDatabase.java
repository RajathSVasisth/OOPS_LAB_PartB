import android.content.Context;

import com.example.nitinpandit.aicte_activity.MemberList;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Member_info_entity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract Member_dao memberDao();


}

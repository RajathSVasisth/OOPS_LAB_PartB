import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface Member_dao {

        @Query("SELECT * FROM Member_info_entity")
        List<Member_info_entity> getAll();

        @Query("SELECT * FROM Member_info_entity WHERE uid IN (:userIds)")
        List<Member_info_entity> loadAllByIds(int[] userIds);

        @Query("SELECT * FROM Member_info_entity WHERE `Full Name` LIKE :first ")
        Member_info_entity findByName(String first);

        @Insert
        void insertAll(Member_info_entity... members);

        @Delete
        void delete(Member_info_entity member);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        public void insertMembers(Member_info_entity... members);

        @Update
        public void updateMembers(Member_info_entity... members);

        @Delete
        public void deleteMembers(Member_info_entity...members);

}

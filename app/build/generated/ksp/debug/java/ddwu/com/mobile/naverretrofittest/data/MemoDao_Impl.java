package ddwu.com.mobile.naverretrofittest.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MemoDao_Impl implements MemoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MemoDto> __insertionAdapterOfMemoDto;

  private final EntityDeletionOrUpdateAdapter<MemoDto> __deletionAdapterOfMemoDto;

  private final EntityDeletionOrUpdateAdapter<MemoDto> __updateAdapterOfMemoDto;

  public MemoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMemoDto = new EntityInsertionAdapter<MemoDto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `memo_table` (`id`,`poster_path`,`title`,`date`,`theater`,`memo`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MemoDto value) {
        stmt.bindLong(1, value.getId());
        if (value.getPoster_path() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPoster_path());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
        if (value.getTheater() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTheater());
        }
        if (value.getMemo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMemo());
        }
      }
    };
    this.__deletionAdapterOfMemoDto = new EntityDeletionOrUpdateAdapter<MemoDto>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `memo_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MemoDto value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfMemoDto = new EntityDeletionOrUpdateAdapter<MemoDto>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `memo_table` SET `id` = ?,`poster_path` = ?,`title` = ?,`date` = ?,`theater` = ?,`memo` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MemoDto value) {
        stmt.bindLong(1, value.getId());
        if (value.getPoster_path() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPoster_path());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
        if (value.getTheater() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTheater());
        }
        if (value.getMemo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMemo());
        }
        stmt.bindLong(7, value.getId());
      }
    };
  }

  @Override
  public Object insertMemo(final MemoDto memo, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMemoDto.insert(memo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteMemo(final MemoDto memo, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMemoDto.handle(memo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateMemo(final MemoDto memo, final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__updateAdapterOfMemoDto.handle(memo);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<MemoDto>> getAllMemos() {
    final String _sql = "SELECT * FROM memo_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"memo_table"}, new Callable<List<MemoDto>>() {
      @Override
      public List<MemoDto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTheater = CursorUtil.getColumnIndexOrThrow(_cursor, "theater");
          final int _cursorIndexOfMemo = CursorUtil.getColumnIndexOrThrow(_cursor, "memo");
          final List<MemoDto> _result = new ArrayList<MemoDto>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MemoDto _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpPoster_path;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPoster_path = null;
            } else {
              _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpTheater;
            if (_cursor.isNull(_cursorIndexOfTheater)) {
              _tmpTheater = null;
            } else {
              _tmpTheater = _cursor.getString(_cursorIndexOfTheater);
            }
            final String _tmpMemo;
            if (_cursor.isNull(_cursorIndexOfMemo)) {
              _tmpMemo = null;
            } else {
              _tmpMemo = _cursor.getString(_cursorIndexOfMemo);
            }
            _item = new MemoDto(_tmpId,_tmpPoster_path,_tmpTitle,_tmpDate,_tmpTheater,_tmpMemo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getMemoById(final long id, final Continuation<? super List<MemoDto>> continuation) {
    final String _sql = "SELECT * FROM memo_table WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<MemoDto>>() {
      @Override
      public List<MemoDto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTheater = CursorUtil.getColumnIndexOrThrow(_cursor, "theater");
          final int _cursorIndexOfMemo = CursorUtil.getColumnIndexOrThrow(_cursor, "memo");
          final List<MemoDto> _result = new ArrayList<MemoDto>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MemoDto _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpPoster_path;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPoster_path = null;
            } else {
              _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpTheater;
            if (_cursor.isNull(_cursorIndexOfTheater)) {
              _tmpTheater = null;
            } else {
              _tmpTheater = _cursor.getString(_cursorIndexOfTheater);
            }
            final String _tmpMemo;
            if (_cursor.isNull(_cursorIndexOfMemo)) {
              _tmpMemo = null;
            } else {
              _tmpMemo = _cursor.getString(_cursorIndexOfMemo);
            }
            _item = new MemoDto(_tmpId,_tmpPoster_path,_tmpTitle,_tmpDate,_tmpTheater,_tmpMemo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

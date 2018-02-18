package com.alexschacher.dietapp.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Food.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FoodDao foodDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                            .addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback callback = new Callback() {

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final FoodDao foodDao;

        PopulateDbAsync(AppDatabase db) {
            foodDao = db.foodDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            foodDao.deleteAll();

            Food food = new Food("Strawberry", 5, 1, "Berry");
            foodDao.insert(food);
            return null;
        }
    }
}

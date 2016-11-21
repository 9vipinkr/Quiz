package com.vipinkr.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vipin K R on 21-11-2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c
    private SQLiteDatabase dbase;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " varchar(100), " + KEY_ANSWER + " varchar(50), " + KEY_OPTA + " varchar(50), "
                + KEY_OPTB + "  varchar(50), " + KEY_OPTC + "  varchar(50))";
        db.execSQL(sql);
        addQuestions();

        Log.i("create table","table created");
//db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
// Drop older table if existed

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);

        onCreate(sqLiteDatabase);

    }

    private void addQuestions() {
        Question q1 = new Question("Which company is the largest manufacturer" + " of network equipment?", "HP", "IBM", "CISCO", "C");
        this.addQuestion(q1);
        Question q2 = new Question("Which of the following is NOT " + "an operating system?", "SuSe", "BIOS", "DOS", "B");
        this.addQuestion(q2);
        Question q3 = new Question("Which of the following is the fastest" + " writable memory?", "RAM", "FLASH", "Register", "C");
        this.addQuestion(q3);
        Question q4 = new Question("Which of the following device" + " regulates internet traffic?", "Router", "Bridge", "Hub", "A");
        this.addQuestion(q4);
        Question q5 = new Question("Which of the following is NOT an" + " interpreted language?", "Ruby", "Python", "BASIC", "C");
        this.addQuestion(q5);
    }

    // Adding new question
    public void addQuestion(Question quest) {
//SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQuestion());
        values.put(KEY_ANSWER, quest.getAnswer());
        values.put(KEY_OPTA, quest.getOpta());
        values.put(KEY_OPTB, quest.getOptb());
        values.put(KEY_OPTC, quest.getOptc());
// Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setId(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quest.setOpta(cursor.getString(3));
                quest.setOptb(cursor.getString(4));
                quest.setOptc(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }


    public int rowcount() {
        int row = 0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }
}

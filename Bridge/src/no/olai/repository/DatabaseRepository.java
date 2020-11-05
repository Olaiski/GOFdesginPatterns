package no.olai.repository;

import no.olai.LogMessage;

import java.sql.*;

public class DatabaseRepository implements StorageRepository {

    public static final String DB_NAME = "log.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\databasesUdemy\\" + DB_NAME;

    public static final String TABLE_LOG = "log";
    public static final String COLUMN_LOG_ID = "id";
    public static final String COLUMN_LOG_MESSAGE = "message";
    public static final String COLUMN_LOG_DATE = "date";


    public static final String CREATE_TABLE_LOG = "CREATE TABLE IF NOT EXISTS " + TABLE_LOG + " (\n"
            +  COLUMN_LOG_ID + " INTEGER PRIMARY KEY, \n"
            +  COLUMN_LOG_MESSAGE + " TEXT, \n"
            +  COLUMN_LOG_DATE + " TEXT " + ");";


    public static final String INSERT_LOG = "INSERT INTO " + TABLE_LOG +
            '(' + COLUMN_LOG_ID + ", " + COLUMN_LOG_MESSAGE + ", " + COLUMN_LOG_DATE + ") VALUES(?, ?, ?)";

    public static final String QUERY_LOG_ID = "SELECT * FROM " + TABLE_LOG
            + " WHERE " + COLUMN_LOG_ID + " = ?";


    private Connection conn;
    private PreparedStatement insertLog;



    private static DatabaseRepository instance = new DatabaseRepository();
    private DatabaseRepository() {

    }

    public static DatabaseRepository getInstance() {
        return instance;
    }


    public void open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);

            Statement statement = conn.createStatement();
            statement.execute(CREATE_TABLE_LOG);

            insertLog = conn.prepareStatement(INSERT_LOG);

        } catch (SQLException e) {
            System.out.println("Couldn't connect to DB " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void close() {
        try {

            if (insertLog != null)
                insertLog.close();


            if (conn != null)
                conn.close();


        } catch (SQLException e) {
            System.out.println("Couldn't close connection " + e.getMessage());
            e.printStackTrace();
        }

    }


    @Override
    public void store(LogMessage message) {

        try {

            insertLog.setInt(1, message.getId());
            insertLog.setString(2, message.getMessage());
            insertLog.setString(3, message.getDate());

            int affectedRows = insertLog.executeUpdate();
            if (affectedRows != 1) {
                throw new SQLException("Something went wrong with INSERT");
            }

        }catch (SQLException ignored) {}

    }
}

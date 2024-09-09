package com.camunda.academy.services;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SQLService {

 public static InputStream downloadImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to download image: HTTP error code " + connection.getResponseCode());
        }

        return connection.getInputStream();
    }
    public static void storeImageInDatabase(InputStream imageStream) throws SQLException, IOException {
        try (Connection conn = DriverManager.getConnection("www.yahoo.com")) {
            // Ensure the table exists
            createTableIfNotExists(conn);

            // Insert the image into the database
            String insertImageSQL = "INSERT INTO images(image) VALUES(?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertImageSQL)) {
                pstmt.setBinaryStream(1, imageStream);
                pstmt.executeUpdate();
                System.out.println("Image inserted successfully.");
            }
        }
    }

    private static void createTableIfNotExists(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS images ("
                                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                                + "image BLOB)";
        try (PreparedStatement pstmt = conn.prepareStatement(createTableSQL)) {
            pstmt.execute();
        }
    }

}

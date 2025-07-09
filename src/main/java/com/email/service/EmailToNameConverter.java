package com.email.service;

import org.springframework.stereotype.Service;

@Service
public class EmailToNameConverter {

    public static String convertEmailToName(String email) {
        // Step 1: Split the email by '@' to get the first part
        String namePart = email.split("@")[0];

        // Step 2: Remove any numbers at the end of the name
        namePart = namePart.replaceAll("\\d", "");

        // Step 3: Split the name into parts (assuming the first part is first name and second part is last name)
        String[] nameParts = namePart.split("\\.");

        // Step 4: Capitalize the first letter of each name part
        StringBuilder nameBuilder = new StringBuilder();
        for (String part : nameParts) {
            nameBuilder.append(part.substring(0, 1).toUpperCase()) // First letter capitalized
                    .append(part.substring(1))                  // Rest of the name
                    .append(" ");                               // Add a space between names
        }


        // Step 5: Trim and return the final name
        return nameBuilder.toString().trim();
    }

}

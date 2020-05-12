/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.util;

import offlineio.payload.response.JwtAuthResponse;

/**
 *
 * @author Bhaskor
 */
public class StaticAppData {

    private static JwtAuthResponse authResponse;
    private static String message;
    private static String color;
    private static String pinUser;
    private static String pinUserId;
    private static String pinThanaCode;
    private static String loggedInUser;
    private static String loggedInUserId;
    private static String nextWindow;
    private static String modifySuspectId;

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        StaticAppData.message = message;
    }

    public static JwtAuthResponse getAuthResponse() {
        return authResponse;
    }

    public static void setAuthResponse(JwtAuthResponse authResponse) {
        StaticAppData.authResponse = authResponse;
    }

    public StaticAppData() {
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        StaticAppData.color = color;
    }

    public static String getPinUser() {
        return pinUser;
    }

    public static void setPinUser(String pinUser) {
        StaticAppData.pinUser = pinUser;
    }

    public static String getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(String loggedInUser) {
        StaticAppData.loggedInUser = loggedInUser;
    }

    public static String getPinUserId() {
        return pinUserId;
    }

    public static void setPinUserId(String pinUserId) {
        StaticAppData.pinUserId = pinUserId;
    }

    public static String getLoggedInUserId() {
        return loggedInUserId;
    }

    public static void setLoggedInUserId(String loggedInUserId) {
        StaticAppData.loggedInUserId = loggedInUserId;
    }

    public static String getNextWindow() {
        return nextWindow;
    }

    public static void setNextWindow(String nextWindow) {
        StaticAppData.nextWindow = nextWindow;
    }

    public static String getPinThanaCode() {
        return pinThanaCode;
    }

    public static void setPinThanaCode(String pinThanaCode) {
        StaticAppData.pinThanaCode = pinThanaCode;
    }

    public static String getModifySuspectId() {
        return modifySuspectId;
    }

    public static void setModifySuspectId(String modifySuspectId) {
        StaticAppData.modifySuspectId = modifySuspectId;
    }

    
}
